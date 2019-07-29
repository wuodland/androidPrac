package ait.com.krb.lab11;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.pavelfarhan.sharedpreference.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText ed1;
    Button btn1;
    Button btn2;
    TextView tv;

    SharedPreferences sharePreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         sharePreferences = getSharedPreferences("user_data_input", Context.MODE_PRIVATE);

        ed1 = findViewById(R.id.ed1);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        tv = findViewById(R.id.tv);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

    }

    private  void saveData(){
        String data = ed1.getText().toString();
        sharePreferences.edit()
                .putString("data",data)
                .apply();
    }

    private void loadData(){
        String data = sharePreferences.getString("data","No data found");
        tv.setText(data);

    }
    //q1 onpause()
    //q1 onstart()

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                saveData();
                break;
            case R.id.btn2:
                loadData();
                break;
                default:
                    break;
        }

    }
}
