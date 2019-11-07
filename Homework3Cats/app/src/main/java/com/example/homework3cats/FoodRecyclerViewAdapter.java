package com.example.homework3cats;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class FoodRecyclerViewAdapter extends RecyclerView.Adapter<FoodRecyclerViewAdapter.ViewHolder> {

    public Context mContext;

    //image view temporarily removed
    public FoodRecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    //inflate the view; same as any recycle adapter, just need to change the id
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
        ViewHolder holder = new ViewHolder(myView);
        System.out.println("onCreateViewHolder is called");
        return holder;
    }

    //changes based on layout
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        //set the item name, price and image
        //image not yet available
        //add 1 to position as food ids start from 1
        holder.nameTextView.setText(FoodDatabase.getFoodById(position + 1).getItemName());
        holder.priceTextView.setText(String.valueOf(FoodDatabase.getFoodById(position + 1).getPrice()));
        holder.itemImageView.setImageResource(FoodDatabase.getFoodById(position + 1).getImageId());

//this has been deleted whoops
        //Change to another fragment
        holder.layoutMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View myView) {
                DetailFragment myFragment = new DetailFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("itemId", FoodDatabase.getFoodById(position + 1).getItemId());
                myFragment.setArguments(bundle);
                AppCompatActivity activity = (AppCompatActivity) mContext;
                //check if it is the right container
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_cont_main, myFragment).addToBackStack(null).commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        //get the amount of article Ids that exists
        return FoodDatabase.getAllFood().size();
    }

    //purpose: holds widgets in memory
    public class ViewHolder extends RecyclerView.ViewHolder {

        //declare everything the ViewHolder holds here (imageview, text, price)
        ConstraintLayout layoutMain;
        ImageView itemImageView;
        TextView nameTextView;
        TextView priceTextView;


        public ViewHolder(@NonNull View v) {
            //super to inherit the View class
            super(v);

            //attach the items to the id
            layoutMain = v.findViewById(R.id.layoutMain);
            itemImageView = v.findViewById(R.id.foodImage);
            nameTextView = v.findViewById(R.id.foodName);
            priceTextView = v.findViewById(R.id.price);
//Raymond z5161354

        }
    }

}
