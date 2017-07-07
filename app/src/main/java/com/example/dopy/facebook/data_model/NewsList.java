package com.example.dopy.facebook.data_model;

import java.util.List;

/**
 * Created by dlwlr on 2017-07-06.
 */

public class NewsList extends Items {
    private List<News> newsList;

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public NewsList(int viewType, List<News> newsList) {
        super(viewType);
        this.newsList=newsList;

    }
}
