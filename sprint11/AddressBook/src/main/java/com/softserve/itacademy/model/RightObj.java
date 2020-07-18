package com.softserve.itacademy.model;

public class RightObj {

    private String message = "";
    private String messageUpdate = "";

    public String getMessageUpdate() {
        return messageUpdate;
    }

    public void setMessageUpdate() {
        this.messageUpdate = "Updated successfully";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage() {
        this.message = "This person added successfully";
    }
}
