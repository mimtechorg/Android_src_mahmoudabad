package com.example.day2_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog=new Dialog(MainActivity.this);
        dialog.setTitle("for test");
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialoglayout);
        Button button= dialog.findViewById(R.id.btn_dialog);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()== R.id.item1){
            Toast.makeText(this, "item1", Toast.LENGTH_SHORT).show();
        }else if (item.getItemId()== R.id.item2){
            dialog.show();
//            Toast.makeText(this, "item2", Toast.LENGTH_SHORT).show();
        }else if (item.getItemId()== R.id.item3){
            Intent intent=new Intent(getApplicationContext(),VideoActivity.class );
            startActivity(intent);
        }else if (item.getItemId()== R.id.item4){
            Intent intent=new Intent(getApplicationContext(),listview.class );
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
