package com.example.day_4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button mBtnChart;
    private Button mBtnFragment;
    private Button mBtnSms;
    private Button mBtnSqlite;
    private Button mBtnXanimation;
    private Button mBtnAnimated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mBtnChart = findViewById(R.id.btn_chart);
        mBtnFragment = findViewById(R.id.btn_Fragment);
        mBtnSms = findViewById(R.id.btn_sms);
        mBtnSqlite = findViewById(R.id.btn_sqlite);
        mBtnXanimation = findViewById(R.id.btn_xanimation);
        mBtnAnimated = findViewById(R.id.btn_animated);

        mBtnChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Chart.class));
            }
        });

        mBtnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Fragment.class));
            }
        });

        mBtnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Sms.class));

            }
        });

        mBtnSqlite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SQLite.class));
            }
        });

        mBtnXanimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, XMLanimation.class));

            }
        });

        mBtnAnimated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Animated.class));
            }
        });

    }
}
