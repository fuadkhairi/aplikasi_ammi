package com.example.crudammi.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {
    public static String BASE_URL = "https://json-jantung.000webhostapp.com/public/index.php/api/";

    public Retrofit doRequest() {
        Retrofit.Builder builder = new Retrofit.Builder();
        return builder.baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public ApiInterface instance() {
        return doRequest().create(ApiInterface.class);
    }
}
