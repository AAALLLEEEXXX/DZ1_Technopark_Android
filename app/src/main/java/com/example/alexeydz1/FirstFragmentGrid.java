package com.example.alexeydz1;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FirstFragmentGrid extends Fragment implements PushItem {

    public static String TAG = "FirstFragmentGrid";
    public int maxItem = 100;
    int itemOfColumns;
    private ItemAdapter adapter;
    private RecyclerView recyclerView;
    private Button addItem;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.grid_items_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            maxItem = savedInstanceState.getInt("max_number", 100);
        }

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        int orientation = view.getContext().getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            itemOfColumns = 4;
        } else {
            itemOfColumns = 3;
        }

        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), itemOfColumns));

        adapter = new ItemAdapter(maxItem, this);
        recyclerView.setAdapter(adapter);

        addItem = view.findViewById(R.id.addNumber);
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maxItem = adapter.getMaxItem() + 1;
                adapter.setMaxItem(maxItem);
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("max_number", maxItem);
    }

    @Override
    public void onItemPush(int num, int color) {
        if (getActivity() == null || !(getActivity() instanceof PushItem)) {
            return;
        }
        ((PushItem) getActivity()).onItemPush(num, color);
    }
}