package com.example.recyclerview;

import android.content.Context;
import android.graphics.text.TextRunShaper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.ContentView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class event_RecyclerViewAdapter extends RecyclerView.Adapter<event_RecyclerViewAdapter.MyViewHolder>{

    ArrayList<event_model> event_models;
    Context context;
    public event_RecyclerViewAdapter(Context context, ArrayList<event_model> event_models){
        this.context = context;
        this.event_models = event_models;
    }

    @NonNull
    @Override
    public event_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.event_recycler_view,parent,false);

        return new event_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull event_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(event_models.get(position).getEventName());
        holder.tvDes.setText(event_models.get(position).getEventDescription());
        holder.tvDate.setText(event_models.get(position).getDate());
        holder.tvTime.setText(event_models.get(position).getTime());
        holder.tvLoc.setText(event_models.get(position).getLocation());

    }

    @Override
    public int getItemCount() {
        return event_models.size();
    }

    public static class  MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvName,tvDes,tvDate,tvTime,tvLoc;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.Name);
            tvDes = itemView.findViewById(R.id.description);
            tvDate = itemView.findViewById(R.id.Date);
            tvTime = itemView.findViewById(R.id.Time);
            tvLoc = itemView.findViewById(R.id.Location);

        }
    }
}
