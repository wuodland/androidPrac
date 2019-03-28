package com.example.lab9119967;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

public class QuoteView extends FrameLayout {

    private TextView symbolTV;
    private TextView changeTV;
    private TextView valueTV;
    private TextView descriptionTV;

    public QuoteView(Context context) {
        super(context);
        initViews();
    }

    private void initViews() {
        inflate(getContext(),R.layout.view_quote,this);
        symbolTV = findViewById(R.id.tv_symbol);
        changeTV = findViewById(R.id.tv_change);
        valueTV = findViewById(R.id.tv_value);
        descriptionTV = findViewById(R.id.tv_description);
    }

    public void setQuote(Quote quote) {

        String symbol = quote.getSymbol();
        String description = quote.getDescription();
        String change = String.valueOf(quote.getChange());
        String value = String.valueOf(quote.getValue());



        symbolTV.setText(symbol);
        descriptionTV.setText(description);
        changeTV.setText(change);
        valueTV.setText(value);

        if(change.startsWith("-"))
        {
            changeTV.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
        }
        else {
            changeTV.setTextColor(getResources().getColor(android.R.color.holo_green_dark));



        }




    }

}
