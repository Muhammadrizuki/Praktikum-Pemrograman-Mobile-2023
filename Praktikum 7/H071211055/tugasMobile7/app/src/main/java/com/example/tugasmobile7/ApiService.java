package com.example.tugasmobile7;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("api/users")
    Call<DataResponse> getUser(@Query("per_page") String per_page);
    @GET("api/users/{id}")
    Call<DataResponse2> getUser2(@Path("id") String id);

}
