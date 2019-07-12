package com.example.ha8i8eh.wordcounter_hassanabadi.Data;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServiceInjector {
    private static ApiService apiService;

    public static ApiService getInstance(){

        if(apiService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.myjson.com/bins/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

            apiService = retrofit.create(ApiService.class);
        }
        return apiService;
    }
}
