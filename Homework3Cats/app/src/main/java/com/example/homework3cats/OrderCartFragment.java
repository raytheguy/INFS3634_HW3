package com.example.homework3cats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class OrderCartFragment extends Fragment {

    TextView totalAmount;
    //layout manager
    RecyclerView.LayoutManager layoutManager2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v2 = inflater.inflate(R.layout.fragment_ordercart, container, false);
        totalAmount = v2.findViewById(R.id.totalAmountText);

        double amountSum = 0;
        for (int i = 0; i < Order.itemArrayTotal.size(); i++)
            amountSum += Order.itemArrayTotal.get(i);

        //purposes of rounding
        double roundTotal = round(amountSum, 2);
        totalAmount.setText("$" + String.valueOf(roundTotal));

        RecyclerView recyclerViewC = v2.findViewById(R.id.orderRecycle);
        layoutManager2 = new LinearLayoutManager(getActivity());
        OrderRecyclerViewAdapter adapterOrder = new OrderRecyclerViewAdapter(getActivity());
        recyclerViewC.setAdapter(adapterOrder);
        recyclerViewC.setLayoutManager(layoutManager2);
//        System.out.println("OnCreateView for Order Cart Fragment is Called");
        return v2;
    }

    //rounding utility
    //z5161354
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}
