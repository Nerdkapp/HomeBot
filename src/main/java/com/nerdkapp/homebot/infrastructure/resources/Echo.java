package com.nerdkapp.homebot.infrastructure.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Echo
{
  private final Logger log = LoggerFactory.getLogger(this.getClass());

  @RequestMapping(value = "/echo", method = RequestMethod.GET)
  public String echo() {
    log.info("Echo resource was called");

    return "ECHO!";
  }
}
