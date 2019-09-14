package com.example.day_4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class BroadCastSms extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {

        final Bundle bundle = intent.getExtras();

        try {

            if (bundle != null) {

                final Object[] pdusObj = (Object[]) bundle.get("pdus");

                for (Object o : pdusObj) {

                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) o);
                    String senderNum = currentMessage.getDisplayOriginatingAddress();

                    String message = currentMessage.getDisplayMessageBody();

                    Log.i("SmsReceiver", "senderNum: " + senderNum + "; message: " + message);

                    Toast toast = Toast.makeText(context,
                            "senderNum: " + senderNum + ", message: " + message,  Toast.LENGTH_LONG);
                    toast.show();
                }
            }

        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception smsReceiver" +e);

        }
    }     }

