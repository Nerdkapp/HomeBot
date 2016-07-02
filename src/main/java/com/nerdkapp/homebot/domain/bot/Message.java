
package com.nerdkapp.homebot.domain.bot;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
  @JsonProperty("message_id")
  private Integer messageId;
  private From from;
  private Chat chat;
  private Integer date;
  private String text;

  @Override
  public String toString()
  {
    return "Message{" +
        "messageId=" + messageId +
        ", from=" + from +
        ", chat=" + chat +
        ", date=" + date +
        ", text='" + text + '\'' +
        '}';
  }

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

  public String getText()
  {
    return text;
  }

  public void setText(String text)
  {
    this.text = text;
  }
}
