package com.sisfo.tugaspraktikum6.model;

import com.google.gson.annotations.SerializedName;

public class Bubble {
    @SerializedName("text")
    private String text;

    @SerializedName("time")
    private String time;

    @SerializedName("type")
    private String sender;

    public Bubble(String text, String time, String sender) {
        this.text = text;
        this.time = time;
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public String getTime() {
        return time;
    }

    public String getSender() {
        return sender;
    }

}
