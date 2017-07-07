package com.example.dopy.facebook.data_model;

/**
 * Created by dlwlr on 2017-07-06.
 */

public class News {
    private int DrawableImage;
    private String name;
    private String Message;

    public News(int drawableImage, String name, String message) {
        DrawableImage = drawableImage;
        this.name = name;
        Message = message;
    }
    public int getDrawableImage() {
        return DrawableImage;
    }
    public void setDrawableImage(int drawableImage) {
        DrawableImage = drawableImage;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
