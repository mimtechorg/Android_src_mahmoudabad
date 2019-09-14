package com.example.day2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MyActivity extends AppCompatActivity {
    Button btn;
    TextView textView;
    Button btn2;
    final static String TAG = "MyActivity ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

          //*************************
          //        init
          //*************************

        btn = findViewById(R.id.my_btn);

        textView = findViewById(R.id.textView);

        btn2=findViewById(R.id.button2);

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Bye");
            }
        });
        final Intent i=new Intent(MyActivity.this,MainActivity.class);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i);
                finish();
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();

        Log.e(TAG, " onStart: " );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();

        Log.e(TAG, " onResume: " );
    }


    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();

        Log.e(TAG, " onPause: " );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();

        Log.e(TAG, " onStop: " );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();

        Log.e(TAG, " Destroy: " );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();

        Log.e(TAG, " onRestart: " );
    }
}
