package com.example.crypsis.send;

/**
 * Created by crypsis on 30/6/16.
 */
public class NewMessageObject {
    protected String message;
    protected Number fbid;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Number getFbid() {
        return fbid;
    }

    public void setFbid(Number fbid) {
        this.fbid = fbid;
    }
}
