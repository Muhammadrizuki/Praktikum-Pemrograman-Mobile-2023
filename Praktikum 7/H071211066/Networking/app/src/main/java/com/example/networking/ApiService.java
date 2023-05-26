package com.example.networking;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("api/users?page=1&per_page=12")
    Call<DataResponse> getUser();

    @GET("api/users/{id}")
    Call<DataResponse2> getUser2(@Path("id") String id);
}

