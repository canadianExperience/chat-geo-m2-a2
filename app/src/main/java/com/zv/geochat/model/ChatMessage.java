package com.zv.geochat.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class ChatMessage {
    private String id;
    private String userName;
    private String body;
    private String date;

    public ChatMessage() {
    }

    public ChatMessage(String userName, String body, String date) {
        this.userName = userName;
        this.body = body;
        this.date = date;
    }

    public ChatMessage(String id, String userName, String body, String date) {
        this.id = id;
        this.userName = userName;
        this.body = body;
        this.date = date;
    }


    public String getUserName() {
        return userName;
    }

    public String getBody() {
        return body;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
//        final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
//        sdf.setTimeZone(TimeZone.getDefault());
//        String dt = sdf.format(this.date);
        return date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", body='" + body + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
