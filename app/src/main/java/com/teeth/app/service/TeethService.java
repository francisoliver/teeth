package com.teeth.app.service;

import retrofit.http.GET;

public interface TeethService {

    @GET("ping")
    boolean isConnected();

}
