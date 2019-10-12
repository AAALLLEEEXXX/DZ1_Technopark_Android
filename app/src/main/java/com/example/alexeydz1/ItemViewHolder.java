package com.example.alexeydz1;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class ItemViewHolder extends RecyclerView.ViewHolder {

    private Button itemButton;
    private int item = 1;

    ItemViewHolder(@NonNull View itemView, final PushItem receiver) {
        super(itemView);
        itemButton = itemView.findViewById(R.id.numberButton);
        itemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                receiver.onItemPush(item, getColor(item));
            }
        });
    }

    @ColorInt
    private static int getColor(int num) {
        if (num % 2 == 0) {
            return Color.RED;
        }
        return Color.BLUE;
    }

    void connect(int num) {
        this.item = num;
        itemButton.setText(String.valueOf(item));
        itemButton.setTextColor(getColor(item));
    }
}
