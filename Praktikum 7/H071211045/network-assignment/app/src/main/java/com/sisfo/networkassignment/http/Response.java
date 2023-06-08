package com.sisfo.networkassignment.http;

import com.google.gson.annotations.SerializedName;

public class Response<T> {

    @SerializedName("data")
    private T data;

    public T getData() {
        return data;
    }

}
