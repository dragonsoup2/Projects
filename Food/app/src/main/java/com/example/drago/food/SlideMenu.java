package com.example.drago.food;

/**
 * Created by drago on 2016-01-20.
 */
public class SlideMenu
{
    private int imgId;
    private String title;

    public SlideMenu(int imgId, String title) {
        this.imgId = imgId;
        this.title = title;
    }

    public int getImgId() {
        return imgId;
    }

    public String getTitle() {
        return title;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
