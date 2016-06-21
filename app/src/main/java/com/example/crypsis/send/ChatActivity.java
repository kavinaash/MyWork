package com.example.crypsis.send;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.google.gson.Gson;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String[] myString1 = getResources().getStringArray(R.array.myjson);
        Gson gson = new Gson();
        for (String e : myString1) {
            MessageInfoModel messageInfoModel = new MessageInfoModel();
//            MessageModel m=new MessageModel();
            messageInfoModel = gson.fromJson(e, MessageInfoModel.class);


//cinfo.add(c);
        }

    }

    private class MyReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String name = intent.getStringExtra("res1");
            String time = intent.getStringExtra("res2");
            String msg = intent.getStringExtra("res3");

            TextView t1 = (TextView) findViewById(R.id.textView34);
            t1.setText(name);
            TextView t2 = (TextView) findViewById(R.id.textView35);
            t2.setText(name);
            TextView t3 = (TextView) findViewById(R.id.textView33);
            t3.setText(name);

        }
    }
}
