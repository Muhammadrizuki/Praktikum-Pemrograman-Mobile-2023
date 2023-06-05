package com.example.networkassigment;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("api/users")
    Call<Data> getUser(@Query("per_page") String per_page);

    @GET("api/users/{id}")
    Call<Data2> getUser2(@Path("id") String id);
}
