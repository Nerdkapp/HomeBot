
package com.nerdkapp.homebot.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Chat {
  private Integer id;
  @JsonProperty("first_name")
  private String firstName;
  private String type;

  @Override
  public String toString()
  {
    return "Chat{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", type='" + type + '\'' +
        '}';
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getType()
  {
    return type;
  }

  public void setType(String type)
  {
    this.type = type;
  }
}
