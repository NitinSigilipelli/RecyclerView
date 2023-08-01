package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    //4 - Handling the click events
    private static  ItemClickListener clickListener;

    // 1- Data Source
    private VacinesModel[] listData;
    public MyAdapter(VacinesModel[] listData) {
        this.listData = listData;
    }
    // intialize above click listener
    public  void setClickListener(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }
    //2-View Holder Classes:
    public  static  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        public ImageView imageView;
        public TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageView);
            this.textView = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(this);
        }
        //onClick purpose
        @Override
        public void onClick(View v) {
            if (clickListener != null){
                clickListener.onClick(v,getAdapterPosition());
            }
        }
    }
    // 3- implementing the methods

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.recyclerview_item,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final VacinesModel myListData = listData[position];
        holder.textView.setText(listData[position].getTitle());
        holder.imageView.setImageResource(listData[position].getImage());

    }

    @Override
    public int getItemCount() {
        return listData.length;
    }

}
