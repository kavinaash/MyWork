package com.example.crypsis.send;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by crypsis on 17/6/16.
 */
public class MyService extends Service {
    final static String MY_ACTION = "MY_ACTION";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
        Intent i = new Intent();
        String s = intent.getStringExtra("v1");
        //Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
        String s1 = intent.getStringExtra("v2");
        i.putExtra("value1", s);
        i.putExtra("value2", s1);
        i.setAction(MY_ACTION);

        sendBroadcast(i);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service1 Destroyed", Toast.LENGTH_SHORT).show();

    }
}
