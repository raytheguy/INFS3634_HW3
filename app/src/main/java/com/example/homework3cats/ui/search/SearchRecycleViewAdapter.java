package com.example.homework3cats.ui.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homework3cats.R;

public class SearchRecycleViewAdapter extends RecyclerView.Adapter<SearchRecycleViewAdapter.ViewHolder> {

    public Context mContext;

    public SearchRecycleViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    //inflate the view; same as any recycle adapter, just need to change the id
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_catlist, parent, false);
        ViewHolder holder = new ViewHolder(myView);
        return holder;
    }

    //changes based on layout
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {


    }

    @Override
    public int getItemCount() {
        //get the amount of article Ids that exists
        return 1;
    }

    //purpose: holds widgets in memory
    public class ViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout layoutMain;
        TextView catTextView;

        public ViewHolder(@NonNull View v){
            super(v);

            //attach to TextView and constraint layout to be clickable
            layoutMain = v.findViewById(R.id.layoutMain);
            catTextView = v.findViewById(R.id.catNameTextView);
        }

    }
}
