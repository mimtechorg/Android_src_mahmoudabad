package com.example.day_4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.day_4.fragment.fragment_1;
import com.example.day_4.fragment.fragment_2;

public class Fragment extends AppCompatActivity {

    private FrameLayout mFrameLayout;
    private Button mBtnFragment1;
    private Button mBtnFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        mFrameLayout = findViewById(R.id.frame_layout);
        mBtnFragment1 = findViewById(R.id.btn_fragment_1);
        mBtnFragment2 = findViewById(R.id.btn_fragment_2);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction= fragmentManager.beginTransaction();
        transaction.add(R.id.frame_layout, new fragment_1());
        transaction.commit();

        mBtnFragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction= fragmentManager.beginTransaction();
                transaction.add(R.id.frame_layout, new fragment_1());
                transaction.commit();
            }
        });

        mBtnFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction= fragmentManager.beginTransaction();
                transaction.add(R.id.frame_layout, new fragment_2());
                transaction.commit();
            }
        });



    }
}
