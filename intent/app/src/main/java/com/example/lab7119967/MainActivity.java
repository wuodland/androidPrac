package com.example.lab7119967;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText ed1;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private EditText ed2;
    private EditText ed3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.ed1);
        btn1 = findViewById(R.id.btn1);

        ed2 = findViewById(R.id.ed2);
        btn2 = findViewById(R.id.btn2);

        ed3 = findViewById(R.id.ed3);
        btn3 = findViewById(R.id.btn3);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String input;
        Uri uri;
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn1:
                input = ed1.getText().toString();

                if (!input.startsWith("http")) {
                    Toast.makeText(this, "Malformed URL", Toast.LENGTH_SHORT).show();
                    return;
                }

                uri = Uri.parse(input);
                break;
            case R.id.btn2:
                input = ed2.getText().toString();
                uri = Uri.parse("tel:" + input);
                break;
            case R.id.btn3:
                input = ed3.getText().toString();
                uri = Uri.parse("geo:0,0q=" + input);
                break;
            default:
                return;
        }
        try {
            intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(uri);
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "Cannot find corrent activity to show content.", Toast.LENGTH_SHORT).show();
        }
    }
}
