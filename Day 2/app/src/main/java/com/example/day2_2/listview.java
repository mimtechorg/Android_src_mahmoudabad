package com.example.day2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class listview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        ListView listView=findViewById(R.id.list_view);
        String[] brands = {"Benz" , "BMW" , "Toyota"};
        ArrayAdapter arrayAdapter= new ArrayAdapter(listview.this,
                android.R.layout.simple_expandable_list_item_1,brands);
        listView.setAdapter(arrayAdapter);

    }
}
