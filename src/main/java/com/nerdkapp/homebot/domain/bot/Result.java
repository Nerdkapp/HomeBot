package com.nerdkapp.homebot.domain.bot;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result
{
  @JsonProperty("message_id")
  private Integer messageId;
  private From from;
  private Chat chat;
  private Integer date;

  public Integer getMessageId()
  {
    return messageId;
  }

  public void setMessageId(Integer messageId)
  {
    this.messageId = messageId;
  }

  public From getFrom()
  {
    return from;
  }

  public void setFrom(From from)
  {
    this.from = from;
  }

  public Chat getChat()
  {
    return chat;
  }

  public void setChat(Chat chat)
  {
    this.chat = chat;
  }

  public Integer getDate()
  {
    return date;
  }

  public void setDate(Integer date)
  {
    this.date = date;
  }

  @Override
  public String toString()
  {
    return "Result{" +
        "messageId=" + messageId +
        ", from=" + from +
        ", chat=" + chat +
        ", date=" + date +
        '}';
  }
}
