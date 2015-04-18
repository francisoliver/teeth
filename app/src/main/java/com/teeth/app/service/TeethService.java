package com.teeth.app.service;

import com.teeth.app.model.User;
import retrofit.http.GET;
import retrofit.http.Path;

import java.util.List;

public interface TeethService {

    @GET("ping")
    boolean isConnected();

    @GET("/api/user")
    List<User> list();

    @GET("/api/user/{username}")
    User getUser(@Path("username") String username);

    @POST("/api/user")
    Response register(@Body User user);

}
