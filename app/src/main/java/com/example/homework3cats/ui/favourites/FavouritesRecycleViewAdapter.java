package com.example.homework3cats.ui.favourites;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.homework3cats.Cat;
import com.example.homework3cats.DetailFragment;
import com.example.homework3cats.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;


public class FavouritesRecycleViewAdapter extends RecyclerView.Adapter<FavouritesRecycleViewAdapter.ViewHolder> {

    public Context mContext;
    public List<Cat> arrayToPut;

    public int counter;

    //constructor
    public FavouritesRecycleViewAdapter(Context mContext, List<Cat> arrayToPut) {
        this.mContext = mContext;
        this.arrayToPut = arrayToPut;
    }

    @NonNull
    @Override
    //inflate the view; same as any recycle adapter, just need to change the id
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //favourites uses the same layout as the catList
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_catlist, parent, false);
        ViewHolder holder = new FavouritesRecycleViewAdapter.ViewHolder(myView);
        if (arrayToPut.size() == 0){
            System.out.println("Is this even called?");
        Snackbar.make(myView, "Please add something to favourites!", Snackbar.LENGTH_SHORT).show();
        }
        return holder;
    }

    //changes based on layout
    @Override
    public void onBindViewHolder(@NonNull FavouritesRecycleViewAdapter.ViewHolder holder, final int position) {

        holder.catTextView.setText(arrayToPut.get(position).getName());

        //onClick Listener when the 'holder' or constraintLayout is clicked
        holder.layoutMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View myView) {

                //get the cat id to pass over
                String catId = arrayToPut.get(position).getId();
                DetailFragment myFragment = new DetailFragment();
                Bundle bundle = new Bundle();
                bundle.putString("catId", arrayToPut.get(position).getId());
                bundle.putSerializable("catThings", arrayToPut.get(position));
                myFragment.setArguments(bundle);
                AppCompatActivity activity = (AppCompatActivity) mContext;
                //check if it is the right container
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_cont_main, myFragment).addToBackStack(null).commit();

            }
        });
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

    @Override
    public int getItemCount() {
        //get the amount of article Ids that exists
        System.out.println("Counter is called" + counter);
        return arrayToPut.size();

    }

}
