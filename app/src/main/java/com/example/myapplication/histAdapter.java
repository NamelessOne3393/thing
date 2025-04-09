package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class histAdapter extends RecyclerView.Adapter<histAdapter.MyViewHolder> {

    ArrayList<orderHistoryItem> list;
    Context context;
    public histAdapter(Context context, ArrayList<orderHistoryItem> list){
        this.list=list;
        this.context=context;
    }
    @NonNull
    @Override
    public histAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row,parent,false);
        return new histAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull histAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(list.get(position).getSeller());
        holder.tvDate.setText(list.get(position).getDay());
        holder.tvTotal.setText(list.get(position).getTotal());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvName,tvDate,tvTotal;
        public MyViewHolder(@NonNull View itemView) {


            super(itemView);
            tvName = itemView.findViewById(R.id.textName);
            tvDate = itemView.findViewById(R.id.textDate);
            tvTotal = itemView.findViewById(R.id.textTotal);

        }
    }
}
