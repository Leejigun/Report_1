package com.example.dopy.facebook.data_model;

import java.util.List;

/**
 * Created by dlwlr on 2017-07-06.
 */

public class MessageList extends Items {
    private List<Message> messageList;

    public MessageList(int viewType, List<Message> messageList) {
        super(viewType);
        this.messageList = messageList;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }
}
