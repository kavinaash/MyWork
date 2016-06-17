package com.example.crypsis.send;

/**
 * Created by crypsis on 13/6/16.
 */
public class MessageModel {
    protected   String UserName;
    protected String Message;
    protected String TimeStamp;



    public void setUserName(String UserName)
    {
        this.UserName = UserName;
    }

    public void setMessage(String Message)
    {
        this.Message = Message;
    }

    public void setTimeStamp(String TimeStamp)
    {
        this.TimeStamp = TimeStamp;
    }



    public String getUserName()
    {
        return this.UserName;
    }

    public String getMessage()
    {
        return this.Message;
    }

    public String getTimeStamp()
    {
        return this.TimeStamp;
    }
}
