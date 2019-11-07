package com.example.homework3cats;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {
    TextView foodName;
    TextView foodPrice;
    TextView foodDesc;
    int foodId;
    Button addBtn;
    String selectedItem = "default";
    ImageView foodImgDetail;
    int selectedAmt;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        //Link to Resource Ids
        foodName = rootView.findViewById(R.id.foodNameDetail);
        foodPrice = rootView.findViewById(R.id.foodPriceDetail);
        foodDesc = rootView.findViewById(R.id.foodDescDetail);
        addBtn = rootView.findViewById(R.id.addButtonDetail);
        foodImgDetail = rootView.findViewById(R.id.foodImgDetail);
        //look here: https://stackoverflow.com/questions/34892929/attempt-to-invoke-virtual-method-void-android-widget-textview-settextjava-lang

        // Inflate the layout for this fragment
        Bundle bundle = getArguments();
        if (bundle != null) {
//            System.out.println("Id that has passed is: " + bundle.getInt("itemid"));
            foodId = bundle.getInt("itemId");
            //set food name, price and description
            foodName.setText(FoodDatabase.getFoodById(foodId).getItemName());
            foodPrice.setText("$" + String.valueOf(FoodDatabase.getFoodById(foodId).getPrice()));
            foodDesc.setText(FoodDatabase.getFoodById(foodId).getDescription());
            foodImgDetail.setImageResource(FoodDatabase.getFoodById(foodId).getImageId());

        }

        //create the spinner for when you select number of items
        final Spinner amountSpinner = rootView.findViewById(R.id.spinnerDetail);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.amount_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        amountSpinner.setAdapter(adapter);

        //z5161354
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View myView) {
                selectedItem = amountSpinner.getSelectedItem().toString();

                //convert to integer first for calculations
                selectedAmt = Integer.parseInt(selectedItem);
                //tester
//                System.out.println("Selected amount is " + selectedAmt);

                //add amount to database alongside item id and price
                //tell use what they ordered
                Snackbar.make(myView, "Your selected item is " + selectedAmt + " of " +
                        FoodDatabase.getFoodById(foodId).getItemName(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                //add amount to Order (with item, price and amount)
                Order.itemId.add(foodId);
                Order.itemPrice.add(FoodDatabase.getFoodById(foodId).getPrice());
                Order.itemAmount.add(selectedAmt);
                //get the total as the price times by the quantity
                Order.itemArrayTotal.add(FoodDatabase.getFoodById(foodId).getPrice()*selectedAmt);
                //add on to the item location of an integer array
                //since the food items start from 1 but the array starts from 0, we must minus 1
                //i.e. food item 5 should actually be in the 4th index of the array
                System.out.println("The amount before adding is + " + Order.numberOfItems[foodId-1]);
                Order.numberOfItems[foodId-1] = Order.numberOfItems[foodId-1]+selectedAmt;
                System.out.println("The amount after adding is + " + Order.numberOfItems[foodId-1]);

            }
        });

        return rootView;
    }



}
