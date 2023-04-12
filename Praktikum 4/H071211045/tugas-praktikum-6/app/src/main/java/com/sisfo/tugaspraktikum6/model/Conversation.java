package com.sisfo.tugaspraktikum6.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Conversation {
    @SerializedName("number")
    private String number;

    @SerializedName("bubble")
    private List<Bubble> bubbles;

    public Conversation(String number, List<Bubble> bubbles) {
        this.number = number;
        this.bubbles = bubbles;
    }

    public String getNumber() {
        return number;
    }

    public List<Bubble> getBubbles() {
        return bubbles;
    }
}

