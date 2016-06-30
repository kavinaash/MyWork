package com.example.crypsis.send;

/**
 * Created by crypsis on 21/6/16.
 */
public class MessageInfoModel {
    protected String message;
    protected boolean isSender;

    public boolean isSender() {
        return isSender;
    }



    public String getMessage() {
        return message;
    }




        protected String first_name;
        protected String last_name;
        protected String profile_pic;
        protected String locale;
        protected String gender;
        protected String id;

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public void setProfile_pic(String profile_pic) {
            this.profile_pic = profile_pic;
        }

        public void setLocale(String locale) {
            this.locale = locale;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getFirst_name() {
            return first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public String getProfile_pic() {
            return profile_pic;
        }

        public String getLocale() {
            return locale;
        }

        public String getGender() {
            return gender;
        }
        public String getId(){
            return id;
        }

    
}
