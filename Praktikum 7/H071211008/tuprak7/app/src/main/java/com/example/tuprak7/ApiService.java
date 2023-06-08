package com.example.tuprak7;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("api/users/{id}")
    Call<Profil> getProfilById (@Path("id") String id);

    @GET("api/users")
    Call<User> getUsers(@Query("per_page") String per_page);
}
