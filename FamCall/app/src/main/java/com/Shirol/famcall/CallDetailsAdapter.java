package com.Shirol.famcall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CallDetailsAdapter extends RecyclerView.Adapter<CallDetailsAdapter.CallViewHolder>{

    List<CallDetails> callDetailsList;
    Context context;


    public CallDetailsAdapter(List<CallDetails> callDetailsList){
        this.callDetailsList = callDetailsList;
    }
    @Override
    public CallDetailsAdapter.CallViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View iteView = inflater.inflate(R.layout.card_item, parent, false);
        CallViewHolder viewHolder = new CallViewHolder(iteView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CallDetailsAdapter.CallViewHolder holder, int position) {
        CallDetails callDetails = callDetailsList.get(position);
        holder.tvName.setText(callDetails.getCallname());
        holder.tvDuration.setText(callDetails.getCallDuration());
        holder.tvDate.setText(callDetails.getDate());

        switch(holder.tvName.getText().toString()){
            case "Shashank":
                holder.ivPerson.setImageResource(R.drawable.shannu);
                break;
            case "Shruti":
                holder.ivPerson.setImageResource(R.drawable.shruti);
                break;
            case "Dad":
                holder.ivPerson.setImageResource(R.drawable.papa);
                break;
            case "Mom":
                holder.ivPerson.setImageResource(R.drawable.mom);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return callDetailsList.size();
    }

    public class CallViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvDuration, tvDate;
        ImageView ivPerson;
        public CallViewHolder(View item){
            super(item);
            tvName = item.findViewById(R.id.tv_name);
            tvDuration = item.findViewById(R.id.tv_callDuration);
            tvDate = item.findViewById(R.id.tv_Date);
            ivPerson = item.findViewById(R.id.card_iv);
        }
    }
}