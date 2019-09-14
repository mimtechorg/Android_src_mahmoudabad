package com.example.day_4;

import android.animation.Animator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Animated extends AppCompatActivity {

    private Button mBtnAnimate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animated);
        mBtnAnimate = findViewById(R.id.btn_animate);
        mBtnAnimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBtnAnimate.animate().rotation(180).scaleX(2f).setDuration(3000).setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        mBtnAnimate.animate().rotation(0).setDuration(3000);
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });            }
        });
    }
}
