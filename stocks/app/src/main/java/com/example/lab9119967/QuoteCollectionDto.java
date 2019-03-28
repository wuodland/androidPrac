package com.example.lab9119967;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuoteCollectionDto {


    @SerializedName("count")
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    @SerializedName("quotes")
    private List<Quote> quotes;




}
