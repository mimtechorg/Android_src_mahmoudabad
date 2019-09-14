package com.example.day_4;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Sms extends AppCompatActivity {

    private Button mButton;
    private EditText mEditText;
    private EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        mButton = findViewById(R.id.button);
        mEditText = findViewById(R.id.editText);
        mEditText2 = findViewById(R.id.editText2);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Sms.this, new String[]{Manifest.permission.SEND_SMS},
                        1);
            }else {
              return;
            }
        }else {
            return;
        }


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SmsManager smsManage = SmsManager.getDefault();
                smsManage.sendTextMessage(mEditText.getText().toString(), null,  mEditText2.getText().toString() , null, null);

            }
        });



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(Sms.this, "Permission Granted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(Sms.this, "Permission denied to send sms", Toast.LENGTH_SHORT).show();
            finish();
        }
        return;
    }
}
