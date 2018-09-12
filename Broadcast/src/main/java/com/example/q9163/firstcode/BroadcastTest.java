package com.example.q9163.firstcode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

//        自定义广播
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.broadcasttest.MY_BROADCASE");
                sendBroadcast(intent);
                // sendOrderedBroadcast(intent,null);

            }
        });
    }

    @Override
    protected void onDestroy() {// Back键生效
        super.onDestroy();
//        动态广播取消注册
        unregisterReceiver(networkChangeReceiver);
    }

    class NetworkChangeReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
//            监听网络变化
//            获得系统服务类
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(context.CONNECTIVITY_SERVICE);
//            判断是否有网络链接 getActiveNetworkInfo()
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo!=null && networkInfo.isAvailable()){
                Toast.makeText(context, "network Available",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context, "network unAvailable",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
