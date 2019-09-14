package com.example.day3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button recycler_btn ;
    Button gps_btn ;
    Button sh_btn;
Button http_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences=getSharedPreferences("DataName",MODE_PRIVATE);
        sharedPreferences.edit().putString("Key","value").apply();




        recycler_btn=findViewById(R.id.btn_rec);
        recycler_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),recycler.class));
            }
        });
        gps_btn=findViewById(R.id.btn_gps);
        gps_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Gps.class));
            }
        });
        sh_btn=findViewById(R.id.btn_sh);
        sh_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),sharedpreferences.class));
            }
        });
        http_btn=findViewById(R.id.btn_http);
        http_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),internet_get.class));
            }
        });
    }
}
