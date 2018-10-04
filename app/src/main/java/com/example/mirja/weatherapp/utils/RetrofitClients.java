package com.example.mirja.weatherapp.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClients {
    public static Retrofit getRetrofitClinets(){
        return new Retrofit.Builder()
                .baseUrl("https://query.yahooapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

}
