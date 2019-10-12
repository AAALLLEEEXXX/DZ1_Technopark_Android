package com.example.alexeydz1;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements PushItem {

    public FirstFragmentGrid firstFragment;
    public SecondFragmentItem secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstFragment = (FirstFragmentGrid) getSupportFragmentManager().findFragmentByTag(FirstFragmentGrid.TAG);
        secondFragment = (SecondFragmentItem) getSupportFragmentManager().findFragmentByTag(SecondFragmentItem.TAG);

        if (firstFragment == null) {
            firstFragment = new FirstFragmentGrid();
        }

        if (secondFragment == null) {
            secondFragment = new SecondFragmentItem();
        }

        showItemFragment();
    }

    public void onItemPush(int num, int color) {
        showOneItemFragment(num, color);
    }

    private void showOneItemFragment(int number, int color) {
        secondFragment.setNumber(number, color);

        if (getSupportFragmentManager().findFragmentByTag(SecondFragmentItem.TAG) != null) {
            Log.e(MainActivity.class.toString(), "");
            return;
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, secondFragment, SecondFragmentItem.TAG);
        transaction.addToBackStack(SecondFragmentItem.TAG);
        transaction.commit();
    }

    private void showItemFragment() {
        if (getSupportFragmentManager().findFragmentByTag(FirstFragmentGrid.TAG) != null) {
            return;
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.content, firstFragment, FirstFragmentGrid.TAG);
        transaction.commit();
    }
}
