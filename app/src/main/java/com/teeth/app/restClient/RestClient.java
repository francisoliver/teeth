package com.teeth.app.restClient;


import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.teeth.app.service.TeethService;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

import java.util.Date;

public class RestClient {

//    private static final String BASE_URL = "http://192.168.0.97:8080/teeth-api";
    private static final String BASE_URL = "http://10.49.236.51:8080/teeth-api";
    private TeethService teethService;

    public RestClient() {

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .registerTypeAdapter(Date.class, new DateTypeAdapter())
                .create();


        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setConverter(new GsonConverter(gson))
                .build();

        teethService = restAdapter.create(TeethService.class);

    }

    public TeethService getTeethService() {
        return teethService;
    }

}
