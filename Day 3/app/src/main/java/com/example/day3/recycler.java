package com.example.day3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class recycler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        RecyclerView recyclerView=findViewById(R.id.recycler);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext() , 3);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext()) ;

        recyclerView.setLayoutManager(layoutManager);

        String[] colorlist={"Red", "Blue" , "Black" , "Green","white","yellow"};
        recycler_adaptor adaptor=new recycler_adaptor(getApplicationContext() , colorlist);
        recyclerView.setAdapter(adaptor);
    }
}
