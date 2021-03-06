package com.example.calaenderdesign;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private  List<Integer> mData;

    String items;
    private final LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    int row_index=-1;

    MyRecyclerViewAdapter(Context context, List<Integer> data,String item) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.items = item;
    }

    @NonNull
    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.ViewHolder holder, int position) {
        Integer dates= mData.get(position);


        holder.myTextView.setText(dates.toString());
        holder.tv_month.setText(items);



        // holder.month.setText(months);
        holder.linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                row_index=position;
                notifyDataSetChanged();
            }
        });
        if (row_index == position){
             holder.linearlayout.setBackgroundColor(Color.CYAN);
        }else
        {
            holder.linearlayout.setBackgroundColor(Color.WHITE);
        }
    }
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView,tv_month;

        LinearLayout linearlayout;
        RecyclerView rv2;
        ViewHolder(View itemView ) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvAnimalName);
            tv_month=itemView.findViewById(R.id.tv_month);
            linearlayout=itemView.findViewById(R.id.linearlayout);
            rv2=itemView.findViewById(R.id.recycler_view);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    Integer getItem(int id) {
        return mData.get(id) ;
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
