package com.example.day3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class broadcastrecever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equalsIgnoreCase(Intent.ACTION_BOOT_COMPLETED)){
            Toast.makeText(context, "broadcastrecever", Toast.LENGTH_SHORT).show();
            Log.e("my broadcast", "onReceive " );
        }
    }
}
