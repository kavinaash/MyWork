package com.example.crypsis.send;

/**
 * Created by crypsis on 25/5/16.
 */
public class AwayMessagesClass {
    boolean status;
    String message;
    String monOpen, monClose, tuesOpen, tuesClose, wedOpen, wedClose, thursOpen, thursClose, friOpen, friClose, satOpen, satClose, sunOpen, sunClose;

    public AwayMessagesClass(boolean status, String msg, String monOpen, String monClose, String tuesOpen, String tuesClose, String wedOpen, String wedClose, String thursOpen,
                             String thursClose, String friOpen, String friClose, String satOpen, String satClose, String sunOpen, String sunClose) {
        this.status = status;
        this.message = msg;
        this.monOpen = monOpen;
        this.monClose = monClose;
        this.tuesOpen = tuesOpen;
        this.tuesClose = tuesClose;
        this.wedOpen = wedOpen;
        this.wedClose = wedClose;
        this.thursOpen = thursOpen;
        this.thursClose = thursClose;
        this.friOpen = friOpen;
        this.friClose = friClose;
        this.satOpen = satOpen;
        this.satClose = satClose;
        this.sunOpen = sunOpen;
        this.sunClose = sunClose;

    }
}
