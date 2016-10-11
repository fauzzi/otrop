package me.fauzi.portofiolio.model;

/**
 * Created by akhma on 02/10/2016.
 */

public class Landing {
  private String title;
  private int icon;

  public Landing(String title, int icon) {
    this.title = title;
    this.icon = icon;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getIcon() {
    return icon;
  }

  public void setIcon(int icon) {
    this.icon = icon;
  }
}
