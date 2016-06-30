package com.example.crypsis.send;

import java.util.Date;

/**
 * Created by crypsis on 21/6/16.
 */
public class ConversationListInfoModel {

        protected String lastMessage;
        protected Date time;
        protected String firstName;
        protected String lastName;
        protected Number fbid;

    public void setTime(Date time) {
        this.time = time;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFbid(Number fbid) {
        this.fbid = fbid;
    }

    public String getLastName() {
            return lastName;
        }


        public String getFirstName() {
            return firstName;
        }

        public Number getFbid() {
            return fbid;
        }


        public Date getTime() {
            return time;
        }

        public void setLastMessage(String lastMessage) {
            this.lastMessage = lastMessage;
        }

        public String getLastMessage() {
            return lastMessage;
        }



        @Override
        public String toString() {
            return this.firstName;
        }

    }

