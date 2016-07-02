package com.nerdkapp.homebot.infrastructure.iot;

public class PictureLocation
{
  private String image;

  public String getImage()
  {
    return image;
  }

  public void setImage(String image)
  {
    this.image = image;
  }

  @Override
  public String toString()
  {
    return "PictureLocation{" +
        "image='" + image + '\'' +
        '}';
  }
}
