package com.example.crypsis.send;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
    List<MessageInfoModel> cinfo = new ArrayList<>();
    MyMessageAdapter myMessageAdapter;
    RecyclerView recyclerView;
    EditText message;Long currentId;
    private Socket mySocket;String newMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView=(RecyclerView)findViewById(R.id.my_recyclerView);

        try {
            mySocket = IO.socket("http://192.168.0.135:3000/");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        mySocket.connect();
        mySocket.on("requested_user", NewMessage);
        mySocket.on("New_Message",updateAdminMessage);
//        String[] myString1 = getResources().getStringArray(R.array.myjson);
//        Gson gson = new Gson();
//        for (String e : myString1) {
//            MessageInfoModel messageInfoModel = gson.fromJson(e, MessageInfoModel.class);
//            cinfo.add(messageInfoModel);
//
//        }
//        myMessageAdapter=new MyMessageAdapter(cinfo);
//recyclerView.setAdapter(myMessageAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
    private  Emitter.Listener updateAdminMessage= new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
      ChatActivity.this.runOnUiThread(new Runnable() {
          @Override
          public void run() {

              JSONObject jsonArray=(JSONObject)args[0];

                  try {
//                      JSONObject m = jsonArray.getJSONObject(args[0]);
                      MessageInfoModel messageInfoModel=new MessageInfoModel();
                      messageInfoModel.gender=jsonArray.getString("gender");
                      messageInfoModel.last_name=jsonArray.getString("last_name");
                      messageInfoModel.first_name=jsonArray.getString("first_name");
                      messageInfoModel.message=jsonArray.getString("message");
                      messageInfoModel.locale=jsonArray.getString("locale");
                      messageInfoModel.profile_pic=jsonArray.getString("profile_pic");

                      messageInfoModel.isSender=jsonArray.getBoolean("isSender");


                      cinfo.add(messageInfoModel);

                  } catch (JSONException e) {
                      e.printStackTrace();
                  }

              myMessageAdapter.notifyItemInserted(cinfo.size()-1);

              recyclerView.scrollToPosition(cinfo.size()-1);
          }

      });
        }
    };

    private Emitter.Listener NewMessage= new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            ChatActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    JSONArray jsonArray=(JSONArray)args[0];
                    for(int i=0;i<jsonArray.length();i++) {
                        try {
                            JSONObject m = jsonArray.getJSONObject(i);
                            MessageInfoModel messageInfoModel=new MessageInfoModel();
                            messageInfoModel.gender=m.getString("gender");
                         messageInfoModel.last_name=m.getString("last_name");
                            messageInfoModel.first_name=m.getString("first_name");
                          messageInfoModel.message=m.getString("message");
                            newMessage=m.getString("message");
                            messageInfoModel.locale=m.getString("locale");
                            messageInfoModel.profile_pic=m.getString("profile_pic");

                            messageInfoModel.isSender=m.getBoolean("isSender");
                            currentId=m.getLong("fbid");
                            cinfo.add(messageInfoModel);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    } myMessageAdapter=new MyMessageAdapter(cinfo);
recyclerView.setAdapter(myMessageAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ChatActivity.this));
                    recyclerView.scrollToPosition(cinfo.size()-1);
                    Intent intent=new Intent();

                    intent.putExtra("msg",newMessage);
                    setResult(RESULT_OK, intent);

                }
            });

        }
    };
    public void newMessage(View view)
    {        message=(EditText)findViewById(R.id.editText14);
        Gson gson=new Gson();
        NewMessageObject newMessageObject=new NewMessageObject();
        newMessageObject.message=message.getText().toString();
        newMessageObject.fbid=currentId;
        String json=gson.toJson(newMessageObject);
        String str=message.getText().toString();
        message.setText("");
        if(str.length()>0)
        { mySocket.emit("admin", json);

        Intent intent=new Intent();
        intent.putExtra("id",currentId);
        intent.putExtra("msg",str);
        setResult(RESULT_OK,intent);}
        
//        MessageInfoModel messageInfoModel=new MessageInfoModel();
//        messageInfoModel.message=message.getText().toString();
//        messageInfoModel.isSender=false;
//        cinfo.add(messageInfoModel);
//        myMessageAdapter.notifyItemInserted(cinfo.size()-1);
//
//        recyclerView.scrollToPosition(cinfo.size()-1);


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
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//
//        mySocket.disconnect();
//        mySocket.off("requested_user", NewMessage);
//    }
}