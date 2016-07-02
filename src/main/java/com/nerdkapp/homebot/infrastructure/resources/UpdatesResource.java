package com.nerdkapp.homebot.infrastructure.resources;

import com.nerdkapp.homebot.domain.bot.MessageSent;
import com.nerdkapp.homebot.domain.bot.Update;
import com.nerdkapp.homebot.domain.iot.Camera;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
public class UpdatesResource
{
  private final Logger log = LoggerFactory.getLogger(this.getClass());

  private Camera camera;

  @Autowired
  public UpdatesResource(Camera camera)
  {
    this.camera = camera;
  }

  @RequestMapping(value = "/updates", method = RequestMethod.POST)
  public void receiveMessage(@RequestBody Update update) {
    log.info("HomeBot has received a message: {}", update);

    MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();

    map.add("photo", camera.getPicture());
    map.add("chat_id", 184011338);

    final String filename="somefile.jpg";
    ByteArrayResource contentsAsResource = null;
    try
    {
      contentsAsResource = new ByteArrayResource(
          IOUtils.toByteArray(new FileInputStream(new File("/Users/lcoccia/Desktop/roma.jpg"))))
      {
        @Override
        public String getFilename()
        {
          return filename;
        }
      };
      map.add("photo", contentsAsResource);
      RestTemplate restTemplate = new RestTemplate();
      MessageSent messageSent = restTemplate.postForObject("https://api.telegram.org/bot226896590:AAEXOVKAHmR6zwxqdWMupOv_CLf7BjHMSRo/sendPhoto", map, MessageSent.class);
      log.info("Message sent: {}", messageSent);
    }catch (Exception e){
      log.error("Error: {}", e);
    }
  }
}
