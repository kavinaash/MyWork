package com.example.crypsis.send;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by crypsis on 20/6/16.
 */
public class MyMessageAdapter extends RecyclerView.Adapter {

   private List<MessageInfoModel> myList;
    RelativeLayout itemSelector;
    Context context;
    public MyMessageAdapter(List<MessageInfoModel> messageInfoModels)
    {
        this.myList=messageInfoModels;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType==1)
        {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.leftmessage, parent, false);
context=parent.getContext();
            itemSelector = (RelativeLayout) parent.findViewById(R.id.chatId);
            return new leftMessage(itemView);
        }
      else
        { View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rightmessage, parent, false);
            itemSelector = (RelativeLayout) parent.findViewById(R.id.chatId);
            context=parent.getContext();
            return new rightMessage(itemView);
        }
    }
//    @Override
//    public rightMessage onCreateViewHolder(ViewGroup parent, int viewType) {
//        return null;
//    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder.getItemViewType()==2)
        {right((rightMessage)holder,position);}
        else
        {
            left((leftMessage)holder,position);
        }
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }
    private void right(final rightMessage rightMessage,int position)
    {
        MessageInfoModel m=myList.get(position);
        rightMessage.myName.setText(m.getFirst_name());
        rightMessage.myTimestamp.setText(m.getLocale());
        rightMessage.myMessage.setText(m.getMessage());
        Picasso.with(context).load(m.getProfile_pic()).into(rightMessage.circularImageView);

    }

    private void left(final leftMessage leftMessage,int position)
    {
        MessageInfoModel m=myList.get(position);
        leftMessage.senderName.setText(m.getFirst_name());
        leftMessage.senderTimestamp.setText(m.getLocale());
        leftMessage.senderMessage.setText(m.getMessage());
        Picasso.with(context).load(m.getProfile_pic()).into(leftMessage.circularImageView);
    }
    @Override
    public int getItemViewType(int position) {
//        return super.getItemViewType(position);
        MessageInfoModel m=myList.get(position);
        if(m.isSender())
            return 1;
        else
            return 2;
    }


    public class leftMessage extends RecyclerView.ViewHolder {
        protected CircularImageView senderPic;
        protected TextView senderName;
        protected TextView senderTimestamp;
        protected TextView senderMessage;
        RelativeLayout r;
        protected CircularImageView circularImageView;

        public leftMessage(View itemView) {
            super(itemView);
            senderPic=(CircularImageView)itemView.findViewById(R.id.view6);
            senderName=(TextView)itemView.findViewById(R.id.textView39);
            senderTimestamp=(TextView)itemView.findViewById(R.id.textView40);
            senderMessage=(TextView)itemView.findViewById(R.id.textView41);
            circularImageView=(CircularImageView)itemView.findViewById(R.id.view6);
r=(RelativeLayout)itemView.findViewById(R.id.chatId);
        }
    }

    public class rightMessage extends RecyclerView.ViewHolder {
        protected CircularImageView mypic;
        protected TextView myName;
        protected TextView myTimestamp;
        protected TextView myMessage;
        RelativeLayout r;
        protected CircularImageView circularImageView;


        public rightMessage(View itemView) {
            super(itemView);
            mypic=(CircularImageView)itemView.findViewById(R.id.view7);
            myName=(TextView)itemView.findViewById(R.id.textView42);
            myTimestamp=(TextView)itemView.findViewById(R.id.textView43);
            myMessage=(TextView)itemView.findViewById(R.id.textView44);
            r=(RelativeLayout)itemView.findViewById(R.id.chatId);
            circularImageView=(CircularImageView)itemView.findViewById(R.id.view7);
        }
    }
}
