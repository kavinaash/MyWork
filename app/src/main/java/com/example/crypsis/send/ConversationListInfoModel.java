package com.example.crypsis.send;

/**
 * Created by crypsis on 21/6/16.
 */
public class ConversationListInfoModel {
    protected String lastMessage;
    protected String time;
    protected String name;
    protected String id;


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getLastMessage() {
        return this.lastMessage;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
