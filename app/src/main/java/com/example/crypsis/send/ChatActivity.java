package com.example.crypsis.send;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }
private class MyReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        String name = intent.getStringExtra("res1");
        String time=intent.getStringExtra("res2");
        String msg=intent.getStringExtra("res3");

        TextView t1 = (TextView) findViewById(R.id.textView34);
        t1.setText(name);
        TextView t2 = (TextView) findViewById(R.id.textView35);
        t2.setText(name);
        TextView t3 = (TextView) findViewById(R.id.textView33);
        t3.setText(name);

    }
}
}
