package com.example.crypsis.send;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
    List<MessageInfoModel> cinfo = new ArrayList<>();
    MyMessageAdapter myMessageAdapter;
    RecyclerView recyclerView;
    EditText message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView=(RecyclerView)findViewById(R.id.my_recyclerView);
        message=(EditText)findViewById(R.id.editText14);
//        SocketIOClient.connect(AsyncHttpClient.getDefaultInstance(), "http://192.168.0.150:3000/test", new ConnectCallback() {
//            @Override
//            public void onConnectCompleted(Exception ex, SocketIOClient client) {
//                if (ex != null) {
//                    ex.printStackTrace();
//                    return;
//                }
//                client.setStringCallback(new StringCallback() {
//                    @Override
//                    public void onString(String string, Acknowledge acknowledge) {
//                        System.out.println(string);
//                    }
//                });
//                client.on("New Message", new EventCallback() {
//                    @Override
//                    public void onEvent(JSONArray argument, Acknowledge acknowledge) {
//                        System.out.println("args: " + argument.toString());
//                        Toast.makeText(ChatActivity.this, "data received", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                client.setJSONCallback(new JSONCallback() {
//                    @Override
//                    public void onJSON(JSONObject json, Acknowledge acknowledge) {
//                        System.out.println("json:" + json.toString());
//                    }
//                });
//            }
//        });

        String[] myString1 = getResources().getStringArray(R.array.myjson);
        Gson gson = new Gson();
        for (String e : myString1) {
            MessageInfoModel messageInfoModel = gson.fromJson(e, MessageInfoModel.class);
            cinfo.add(messageInfoModel);

        }
        myMessageAdapter=new MyMessageAdapter(cinfo);
recyclerView.setAdapter(myMessageAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
    public void newMessage(View view)
    {
//        message.getText().toString();
        Toast.makeText(ChatActivity.this,"new message",Toast.LENGTH_SHORT).show();

    }

//    private class MyReceiver extends BroadcastReceiver {
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            String name = intent.getStringExtra("res1");
//            String time = intent.getStringExtra("res2");
//            String msg = intent.getStringExtra("res3");
//
//            TextView t1 = (TextView) findViewById(R.id.textView34);
//            t1.setText(name);
//            TextView t2 = (TextView) findViewById(R.id.textView35);
//            t2.setText(name);
//            TextView t3 = (TextView) findViewById(R.id.textView33);
//            t3.setText(name);
//
//        }
//    }
}