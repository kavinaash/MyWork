package com.example.crypsis.send;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

/**
 * Created by crypsis on 20/6/16.
 */
public class MyMessageAdapter extends RecyclerView.Adapter {

   private List<MessageInfoModel> myList;
    public MyMessageAdapter(List<MessageInfoModel> messageInfoModels)
    {
        this.myList=messageInfoModels;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_layout, parent, false);
        if (viewType==1)
        {


            itemSelector = (RelativeLayout) parent.findViewById(R.id.message);
            return new leftMessage(itemView);
        }
      else
            return new rightMessage(it)
    }
//    @Override
//    public rightMessage onCreateViewHolder(ViewGroup parent, int viewType) {
//        return null;
//    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
//        return super.getItemViewType(position);
        MessageInfoModel m=myList.get(position);
        if(m.getProfile().getId()==Sender)
            return 1;
    }

    public class leftMessage extends RecyclerView.ViewHolder {
        protected CircularImageView senderPic;
        protected TextView senderName;
        protected TextView senderTimestamp;
        protected TextView senderMessage;

        public leftMessage(View itemView) {
            super(itemView);
            senderPic=(CircularImageView)itemView.findViewById(R.id.view6);
            senderName=(TextView)itemView.findViewById(R.id.textView39);
            senderTimestamp=(TextView)itemView.findViewById(R.id.textView40);
            senderMessage=(TextView)itemView.findViewById(R.id.textView41);

        }
    }

    public class rightMessage extends RecyclerView.ViewHolder {
        protected CircularImageView mypic;
        protected TextView myName;
        protected TextView myTimestamp;
        protected TextView myMessage;


        public rightMessage(View itemView) {
            super(itemView);
            mypic=(CircularImageView)itemView.findViewById(R.id.view7);
            myName=(TextView)itemView.findViewById(R.id.textView42);
            myTimestamp=(TextView)itemView.findViewById(R.id.textView43);
            myMessage=(TextView)itemView.findViewById(R.id.textView44);
        }
    }
}
