package com.example.q9163.firstcode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class BroadcastTest extends AppCompatActivity {
    private IntentFilter intentFilter;

    private NetworkChangeReceiver networkChangeReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_test);
        intentFilter = new IntentFilter();
//        接受系统发出Action "android.net.conn.CONNECTIVITY_CHANGE"
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver, intentFilter);// 注册动态广播
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        动态广播取消注册
        unregisterReceiver(networkChangeReceiver);
    }

    class NetworkChangeReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
//            监听网络变化
            Toast.makeText(context, "network changes",Toast.LENGTH_SHORT).show();
        }
    }
}
