package com.example.homework3cats.ui.favourites;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.homework3cats.Cat;
import com.example.homework3cats.Favourites;
import com.example.homework3cats.R;
import com.example.homework3cats.ui.search.SearchRecycleViewAdapter;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class FavouritesFragment extends Fragment {
    //RecyclerView to be used by all classes
    public RecyclerView recyclerViewFav;
    //new layout manager
    RecyclerView.LayoutManager layoutManagerFav;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_favourites, container, false);

        recyclerViewFav = root.findViewById(R.id.favRecycler);
        layoutManagerFav = new LinearLayoutManager(getActivity());
        recyclerViewFav.setLayoutManager(layoutManagerFav);

        //use doSearch method to search from Api z5161354
        FavouritesRecycleViewAdapter adapterSearch = new FavouritesRecycleViewAdapter(getActivity(), Favourites.favCats);
        recyclerViewFav.setAdapter(adapterSearch);

        return root;
    }


}