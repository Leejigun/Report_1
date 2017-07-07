package com.example.dopy.facebook.data_model;

/**
 * Created by dlwlr on 2017-07-06.
 */

public class Friend {
    private int Type;
    private String name;

    public Friend(int type, String name) {
        Type = type;
        this.name = name;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
