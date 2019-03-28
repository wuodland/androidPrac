package com.example.lab9119967;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServiceFactory {
    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://visutrb.localtunnerl.me")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    public static QuoteApiService createQuoteApiService()
    {
        return retrofit.create(QuoteApiService.class);
    }
}
