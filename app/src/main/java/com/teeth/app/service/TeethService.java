package com.teeth.app.service;

import com.teeth.app.model.Login;
import com.teeth.app.model.User;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
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

    @POST("/api/login")
    Response login(@Body Login login);

}
