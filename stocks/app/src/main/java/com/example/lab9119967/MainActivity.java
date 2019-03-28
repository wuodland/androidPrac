package com.example.lab9119967;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, Callback<QuoteCollectionDto> {

    private Quote.QuoteAdapter quoteAdapter;
    private ListView quoteListView;
    private QuoteApiService quoteApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteListView = findViewById(R.id.listView_quote);

        quoteAdapter = new Quote.QuoteAdapter();
        quoteListView.setAdapter(quoteAdapter);
        quoteListView.setOnItemClickListener(this);

        quoteApiService = ApiServiceFactory.createQuoteApiService();
        quoteApiService.getQuotes().enqueue(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("main activity","clicked item");
    }

    @Override
    public void onResponse(Call<QuoteCollectionDto> call, Response<QuoteCollectionDto> response) {
    QuoteCollectionDto dto= response.body();
        List<Quote> quotes = dto.getQuotes();
        quoteAdapter.setQuotes(quotes);
    }

    @Override
    public void onFailure(Call<QuoteCollectionDto> call, Throwable t) {

    }
}
