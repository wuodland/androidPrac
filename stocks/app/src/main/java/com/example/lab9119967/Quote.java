package com.example.lab9119967;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Quote {
    @SerializedName("symbol")
    private String symbol;

    @SerializedName("description")
    private String description;

    @SerializedName("change")
    private Float change;

    @SerializedName("value")
    private Float value;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getChange() {
        return change;
    }

    public void setChange(Float change) {
        this.change = change;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }



    public static class QuoteAdapter extends BaseAdapter {

        private List<Quote> quotes;

        public QuoteAdapter() {

        }


        @Override
        public int getCount() {
            if (quotes==null)
            {
                return 0;
            } else {
                return quotes.size();
            }



        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Quote quote = quotes.get(position);
            QuoteView quoteView;

            if(convertView == null){
                quoteView = new QuoteView(parent.getContext());
            } else {
                quoteView = (QuoteView) convertView;
            }
            quoteView.setQuote(quote);
            return quoteView;
        }


        public void setQuotes(List<Quote> quotesList) {
            this.quotes = quotes;
            notifyDataSetChanged();
        }
    }
}
