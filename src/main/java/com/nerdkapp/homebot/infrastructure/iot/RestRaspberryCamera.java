package com.nerdkapp.homebot.infrastructure.iot;

import com.nerdkapp.homebot.domain.iot.Camera;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;

@Component
public class RestRaspberryCamera implements Camera
{
  private final Logger log = LoggerFactory.getLogger(this.getClass());
  private RestTemplate restTemplate = new RestTemplate();

  @Override
  public ByteArrayResource getPicture()
  {
    PictureLocation pictureLocation = restTemplate.getForEntity("http://192.168.1.101:8080/takePicture",PictureLocation.class).getBody();

    log.info("Image retrieved from camera: {}", pictureLocation);
    try
    {
      ByteArrayResource byteArrayResource = new ByteArrayResource(IOUtils.toByteArray(new URL("http://192.168.1.101:8080" + pictureLocation.getImage())));
      log.info("Image size: {}", byteArrayResource.contentLength());

      return byteArrayResource;
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

    return null;
  }
}
