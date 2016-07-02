package com.nerdkapp.homebot.infrastructure.iot;

import org.junit.Test;
import org.springframework.core.io.ByteArrayResource;

import static org.junit.Assert.*;

public class RestRaspberryCameraIT
{
  @Test
  public void retrieve_image() throws Exception
  {
    RestRaspberryCamera camera = new RestRaspberryCamera();

    ByteArrayResource file = camera.getPicture();

    assertNotNull(file);
    System.out.println(file.contentLength());
  }
}