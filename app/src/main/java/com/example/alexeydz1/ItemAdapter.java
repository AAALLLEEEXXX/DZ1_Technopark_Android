package com.example.alexeydz1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    public PushItem receiver;
    public int maxItem;

    public ItemAdapter(int maxItem, PushItem receiver) {
        this.receiver = receiver;
        this.maxItem = maxItem;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_button_with_items, parent, false);
        return new ItemViewHolder(view, receiver);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.connect(position + 1);
    }

    public int getMaxItem() {
        return maxItem;
    }

    public void setMaxItem(int maxNumber) {
        this.maxItem = maxNumber;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return maxItem;
    }
}
