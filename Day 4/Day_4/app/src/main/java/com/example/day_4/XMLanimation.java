package com.example.day_4;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class XMLanimation extends AppCompatActivity {

    private Button mAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xmlanimation);


        mAnimation = findViewById(R.id.animation);
        mAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation);
                view.startAnimation(animation);
            }
        });
    }
}
