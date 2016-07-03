package com.nerdkapp.homebot.infrastructure.iot;

import com.nerdkapp.homebot.domain.iot.Camera;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Component
public class RestRaspberryCamera implements Camera
{
  private final Logger log = LoggerFactory.getLogger(this.getClass());
  private RestTemplate restTemplate = new RestTemplate();

  private String cameraEndpoint;

  @Autowired
  public RestRaspberryCamera(@Value("${camera.endpoint:http://192.168.1.101:8080}") String cameraEndpoint)
  {
    this.cameraEndpoint = cameraEndpoint;
  }

  @Override
  public ByteArrayResource getPicture()
  {
    PictureLocation pictureLocation = restTemplate.getForEntity(cameraEndpoint + "/takePicture", PictureLocation.class).getBody();

    log.info("Image retrieved from camera: {}", pictureLocation);
    final String filename = "somefile.jpg";

    ByteArrayResource contentsAsResource = null;
    try
    {
      try(InputStream in = new URL(cameraEndpoint + pictureLocation.getImage()).openStream()){
        Files.copy(in, Paths.get("/tmp/" + UUID.randomUUID()));
      }


      contentsAsResource = new ByteArrayResource(
          IOUtils.toByteArray(new FileInputStream(new File("/tmp/image.jpg"))))
      {
        @Override
        public String getFilename()
        {
          return filename;
        }
      };

//      ByteArrayResource byteArrayResource = new ByteArrayResource(IOUtils.toByteArray(new URL("http://192.168.1.101:8080" + pictureLocation.getImage())));
      log.info("Image size: {}", contentsAsResource.contentLength());

      return contentsAsResource;
    }
    catch (Exception e)
    {
      log.error("Error retrieving picture from camera {} ", e);
    }

    return null;
  }
}
