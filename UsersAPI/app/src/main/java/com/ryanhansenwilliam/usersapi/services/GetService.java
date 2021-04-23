package com.ryanhansenwilliam.usersapi.services;

import com.ryanhansenwilliam.usersapi.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetService {
    @GET("/users")
    Call<List<User>> getUsersList();
}
