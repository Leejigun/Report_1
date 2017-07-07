package com.example.dopy.facebook.data_model;

import java.util.List;

/**
 * Created by dlwlr on 2017-07-06.
 */

public class FriendList extends Items {
    private List<Friend> friendList;
    public FriendList(int viewType,List<Friend> friendList) {
        super(viewType);
        this.friendList=friendList;
    }

    public List<Friend> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<Friend> friendList) {
        this.friendList = friendList;
    }
}
