package com.example.homework3cats.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
import com.example.homework3cats.CatResults;
import com.example.homework3cats.R;
import com.google.gson.Gson;

import java.util.ArrayList;

public class SearchFragment extends Fragment {
    //create new arrayList to hold cat objects
    public ArrayList<Cat> catToPut = new ArrayList<>();
    //new layout manager
    RecyclerView.LayoutManager layoutManager;
    //String to receive the JSON
    String getBackFromApi;
    //RecyclerView to be used by all classes
    public RecyclerView recyclerView;
    //search button
    public Button search;
    //search textbox
    public EditText searchText;

    //default constructor
    public SearchFragment() {

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //create the recycling things
        //new instance of layout manager and setting layout manager
        final View v2 = inflater.inflate(R.layout.fragment_search, container, false);
        recyclerView = v2.findViewById(R.id.recycleCats);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        //attach button to search layout
        search = v2.findViewById(R.id.searchButton);
        searchText = v2.findViewById(R.id.searchBox);

        //onClick listener for when the user clicks search
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View myView) {
                //to obtain what the user has entered
                String userSearchText = searchText.getText().toString();
                System.out.println("The user has entered: " + userSearchText);
                doSearch(userSearchText);
            }
        });

        return v2;

    }

    //when onclick of search is clicked, do the method below:
    public void doSearch(String userSearchText) {
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("Your response has succeeded");
                //place response to a String of Jsons
                getBackFromApi = response;
                System.out.println(getBackFromApi);
                Gson gson = new Gson();
                CatResults jsonCat = gson.fromJson(getBackFromApi, CatResults.class);
//                catToPut = jsonCat.getCats();
                System.out.println("The cat from position 1 is " );

            }

        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("There was error" + error.toString());
            }
    };

        //API Url
        String url = "https://api.thecatapi.com/v1/breeds/search?q="+userSearchText;
        //Request Queue
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        //String Request
        StringRequest myStringRequest = new StringRequest(Request.Method.GET, url, responseListener, errorListener);
        //Add String Request to Queue
        requestQueue.add(myStringRequest);

}}