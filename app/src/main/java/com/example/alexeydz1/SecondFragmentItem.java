package com.example.alexeydz1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragmentItem extends Fragment {

    public static final String TAG = "SecondFragmentItem";

    private int number;
    private int color = Color.BLACK;
    private TextView itemView;

    public void setNumber(int number, @ColorInt int color) {
        Bundle bundle = new Bundle();
        bundle.putInt("number", number);
        bundle.putInt("color", color);
        setArguments(bundle);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle == null) {
            return;
        }

        this.number = bundle.getInt("number");
        this.color = bundle.getInt("color");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_item_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        itemView = view.findViewById(R.id.items);
        itemView.setText(String.valueOf(this.number));
        itemView.setTextColor(this.color);
    }

}
