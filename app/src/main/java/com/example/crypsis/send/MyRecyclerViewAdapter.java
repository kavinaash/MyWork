package com.example.crypsis.send;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.CustomerViewHolder> {

    private List<MessageModel> customerInfoList;
    Context context;
    CallBack callBack;
    RelativeLayout itemSelector;

    public MyRecyclerViewAdapter( List<MessageModel> hl,CallBack callBack) {

        this.customerInfoList = hl;
        this.callBack=callBack;
    }

    @Override
    public CustomerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_layout, parent, false);
        context = parent.getContext();
        itemSelector=(RelativeLayout)parent.findViewById(R.id.message);
        return new CustomerViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(final CustomerViewHolder holder, int position) {
        MessageModel customerInfo = customerInfoList.get(position);
        holder.name.setText(customerInfo.UserName);
        holder.message.setText(customerInfo.Message);
        holder.timestamp.setText(customerInfo.TimeStamp);
        if(holder.relativeLayout!=null&& callBack!=null)
        {
            holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callBack.onItemClick(holder.getAdapterPosition());
                }
            });
        }

    }


    @Override
    public int getItemCount() {
        return customerInfoList.size();
    }

    public class CustomerViewHolder extends RecyclerView.ViewHolder {
        protected TextView name;
        protected TextView timestamp;
        protected TextView message;
        RelativeLayout relativeLayout;


        public CustomerViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.textView19);
            timestamp = (TextView) itemView.findViewById(R.id.textView32);
            message = (TextView) itemView.findViewById(R.id.textView31);
relativeLayout=(RelativeLayout)itemView.findViewById(R.id.message);
        }
    }
}
interface CallBack{
     void onItemClick(int position);

}