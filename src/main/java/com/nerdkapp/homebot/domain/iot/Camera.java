package com.nerdkapp.homebot.domain.iot;

import org.springframework.core.io.ByteArrayResource;

public interface Camera
{
  public ByteArrayResource getPicture();
}
