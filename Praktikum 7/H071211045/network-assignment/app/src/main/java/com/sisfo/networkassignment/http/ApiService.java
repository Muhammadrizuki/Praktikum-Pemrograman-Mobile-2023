package com.sisfo.networkassignment.http;

import com.sisfo.networkassignment.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("api/users")
    Call<Response<List<User>>> getUserPerPage(@Query("page") int pageNumber);

    @GET("api/users/{id}")
    Call<Response<User>> getUserById(@Path("id") int id);
}
