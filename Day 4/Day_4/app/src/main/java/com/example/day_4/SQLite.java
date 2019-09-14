package com.example.day_4;

import android.app.Dialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SQLite extends AppCompatActivity {

    private EditText mEdtName;
    private EditText mEdtAge;
    private Button mBtnSave;
    private Button mButton2;
    private ListView mSqlList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        final SQLiteDatabase database = openOrCreateDatabase("DataBase", MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS CONTACT(ID INT(3) , NAME TEXT);");
        database.close();
        mEdtName = findViewById(R.id.edt_name);
        mEdtAge = findViewById(R.id.edt_age);
        mBtnSave = findViewById(R.id.btn_save);

        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mEdtName.getText().toString();
                int age = Integer.parseInt(mEdtAge.getText().toString());
                final SQLiteDatabase database = openOrCreateDatabase("DataBase", MODE_PRIVATE, null);
                database.execSQL("INSERT INTO CONTACT VALUES (" +age + ",'" + (name.isEmpty()?"a":name) + "');");
                database.close();
            }
        });
        mSqlList = findViewById(R.id.sql_list);

        mButton2 = findViewById(R.id.button2);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                     ArrayAdapter arrayAdapter = new ArrayAdapter(SQLite.this, android.R.layout.simple_expandable_list_item_1, get());
                    mSqlList.setAdapter(arrayAdapter);
                    mSqlList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                        @Override
                        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                            int id = Integer.parseInt(get().get(i).split("-")[0]);
                            final SQLiteDatabase database = openOrCreateDatabase("DataBase", MODE_PRIVATE, null);
                            database.execSQL("DELETE FROM CONTACT WHERE ID="+id);
                            database.close();
                            ArrayAdapter arrayAdapter2 = new ArrayAdapter(SQLite.this, android.R.layout.simple_expandable_list_item_1, get());
                            mSqlList.setAdapter(arrayAdapter2);
                            return false;
                        }
                    });

                    mSqlList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            final int id = Integer.parseInt(get().get(i).split("-")[0]);
                            final Dialog dialog = new Dialog(SQLite.this);
                            dialog.setContentView(R.layout.dialog_update_sql);
                            dialog.show();
                            final EditText text = dialog.findViewById(R.id.textupdate);
                            Button update = dialog.findViewById(R.id.btn_update);
                            update.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    final SQLiteDatabase database = openOrCreateDatabase("DataBase", MODE_PRIVATE, null);
                                    database.execSQL("UPDATE CONTACT SET NAME ='"+text.getText().toString()+"' WHERE ID="+id);
                                    database.close();
                                    ArrayAdapter arrayAdapter3 = new ArrayAdapter(SQLite.this, android.R.layout.simple_expandable_list_item_1, get());
                                    mSqlList.setAdapter(arrayAdapter3);
                                    dialog.dismiss();
                                }
                            });



                        }
                    });
                } catch (Exception e) {
                    Log.e("abc", "onClick: " + e.getMessage());
                }

            }
        });


    }

    public ArrayList<String> get(){
        final ArrayList<String> j = new ArrayList<>();
        final SQLiteDatabase database = openOrCreateDatabase("DataBase", MODE_PRIVATE, null);
        Cursor cursor = database.rawQuery("SELECT ID, NAME FROM CONTACT;", null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String name = cursor.getString(cursor.getColumnIndex("NAME"));
            j.add(id + "-" + name);
        }
        return j;
    }
}
