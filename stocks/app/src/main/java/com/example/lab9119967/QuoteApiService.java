package com.example.lab9119967;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuoteApiService {
    @GET("/quotes")
    Call<QuoteCollectionDto> getQuotes();

}
