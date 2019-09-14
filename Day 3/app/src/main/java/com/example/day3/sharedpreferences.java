package com.example.day3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class sharedpreferences extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpreferences);
        SharedPreferences sharedPreferences=getSharedPreferences("DataName",MODE_PRIVATE);
        final String get = sharedPreferences.getString("Key","");
        Button button=findViewById(R.id.btn_getshdata);
        final TextView textView=findViewById(R.id.shtextView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(get);
            }
        });
    }
}
