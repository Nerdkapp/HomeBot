package com.nerdkapp.homebot.infrastructure.resources;

import com.nerdkapp.homebot.domain.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdatesResource
{
  private final Logger log = LoggerFactory.getLogger(this.getClass());

  @RequestMapping(value = "/updates", method = RequestMethod.POST)
  public void receiveMessage(@RequestBody Update update) {
    log.info("HomeBot has received a message: {}", update);
  }
}
