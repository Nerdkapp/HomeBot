package com.nerdkapp.homebot.infrastructure.iot;

import org.junit.Test;
import org.springframework.core.io.ByteArrayResource;

import static org.junit.Assert.*;

public class RestRaspberryCameraIT
{

  private String endpoint = "http://192.168.1.101:8080";

  @Test
  public void retrieve_image() throws Exception
  {
    RestRaspberryCamera camera = new RestRaspberryCamera(endpoint);

    ByteArrayResource file = camera.getPicture();

    assertNotNull(file);
    System.out.println(file.contentLength());
  }
}