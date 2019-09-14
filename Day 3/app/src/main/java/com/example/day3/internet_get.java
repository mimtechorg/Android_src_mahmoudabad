package com.example.day3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.jetbrains.annotations.NotNull;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class internet_get extends AppCompatActivity {
    Button button;
    TextView textView;
    ProgressDialog progressDialog;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet_get);
        button = findViewById(R.id.h_btn);
        textView = findViewById(R.id.h_txt);
        editText = findViewById(R.id.editText);
        progressDialog  = new ProgressDialog(internet_get.this);
        progressDialog.setMessage("Get . . . ");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                if(editText.getText().toString().startsWith("http")){
                    try {
                        OkHttpClient client = new OkHttpClient();
                        Request request = new Request.Builder()
                                .url(editText.getText().toString())
                                .build();
                        client.newCall(request).enqueue(new Callback() {
                                                            @Override
                                                            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                                                                Log.e("res", "onResponse: "+e.getMessage() );
                                                                progressDialog.dismiss();
                                                            }

                                                            @Override
                                                            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                                                                final String s = response.body().string();
                                                                runOnUiThread(new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        textView.setText(s);
                                                                        progressDialog.dismiss();
                                                                    }
                                                                });
                                                            }
                                                        }
                        );
                    }catch (Exception e){
                        Log.e("error", "run: "+e.getMessage() );
                    }
                }else {
                    Toast.makeText(internet_get.this, "set http", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

}
