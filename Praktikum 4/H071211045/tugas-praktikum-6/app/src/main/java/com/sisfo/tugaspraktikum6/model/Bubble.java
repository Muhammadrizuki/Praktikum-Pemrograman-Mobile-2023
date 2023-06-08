package com.sisfo.tugaspraktikum6.model;

import com.google.gson.annotations.SerializedName;

<<<<<<< Updated upstream
public class Bubble {
=======
import java.io.Serializable;

public class Bubble implements Serializable {
>>>>>>> Stashed changes
    @SerializedName("text")
    private String text;

    @SerializedName("time")
    private String time;

    @SerializedName("type")
<<<<<<< Updated upstream
    private String sender;

    public Bubble(String text, String time, String sender) {
        this.text = text;
        this.time = time;
        this.sender = sender;
=======
    private String type;

    public Bubble(String text, String time, String type) {
        this.text = text;
        this.time = time;
        this.type = type;
>>>>>>> Stashed changes
    }

    public String getText() {
        return text;
    }

    public String getTime() {
        return time;
    }

<<<<<<< Updated upstream
    public String getSender() {
        return sender;
=======
    public String getType() {
        return type;
>>>>>>> Stashed changes
    }

}
