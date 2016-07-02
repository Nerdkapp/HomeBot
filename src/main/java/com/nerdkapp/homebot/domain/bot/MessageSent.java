package com.nerdkapp.homebot.domain.bot;

public class MessageSent
{
  private Boolean ok;
  private Result result;

  public Boolean getOk()
  {
    return ok;
  }

  public void setOk(Boolean ok)
  {
    this.ok = ok;
  }

  public Result getResult()
  {
    return result;
  }

  public void setResult(Result result)
  {
    this.result = result;
  }

  @Override
  public String toString()
  {
    return "MessageSent{" +
        "ok=" + ok +
        ", result=" + result +
        '}';
  }
}
