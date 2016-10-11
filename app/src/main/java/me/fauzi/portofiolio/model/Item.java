package me.fauzi.portofiolio.model;

/**
 * Created by akhma on 02/10/2016.
 */

public class Item {

  private int image;
  private String title;

  public Item(String title, int image) {
    this.title = title;
    this.image = image;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getImage() {
    return image;
  }

  public void setImage(int image) {
    this.image = image;
  }
}
