package com.nerdkapp.homebot.infrastructure.iot;

import com.nerdkapp.homebot.domain.iot.Camera;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;

public class RestRaspberryCamera implements Camera
{
  RestTemplate restTemplate = new RestTemplate();

  @Override
  public ByteArrayResource getPicture()
  {
    PictureLocation pictureLocation = restTemplate.getForEntity("http://192.168.1.101:8080/takePicture",PictureLocation.class).getBody();

    try
    {
      return new ByteArrayResource(IOUtils.toByteArray(new URL("http://192.168.1.101:8080/" + pictureLocation.getImage())));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

    return null;
  }
}
