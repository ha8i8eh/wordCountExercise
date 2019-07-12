package com.example.ha8i8eh.wordcounter_hassanabadi.Data;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {
    @GET("1e3b4e")
    Single<Text> tenthChar();

    @GET("1e3b4e")
    Single<Text> AllTenthChar();

    @GET("1e3b4e")
    Single<Text> wordCounter();
}
