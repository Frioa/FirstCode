package com.example.q9163.firstcode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by q9163 on 11/09/2018.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "received in My BroadcastReceiver",Toast.LENGTH_SHORT).show();
//        abortBroadcast();
    }

}
