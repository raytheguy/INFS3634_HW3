package com.example.homework3cats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    public ConstraintLayout top;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //save layout when rotated
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_cont_main,
                    new FoodListFragment()).commit();
        }

        //make an instance of a bottom navigation bar
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        System.out.println("On Create is called");

        //set int array as all 0 as the quantity is 0 until you start adding
        for (int i = 0; i < Order.numberOfItems.length ;i++){
            Order.numberOfItems[i] = 0;
        }
        //test array size
        System.out.println("The size of the array is " + Order.numberOfItems.length);

    }
//raymond wang z5161354

    //creates the cases to switch between fragments
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_food:
                            selectedFragment = new FoodListFragment();
                            System.out.println("Selected food list fragment");
                            break;
                        case R.id.nav_shopcart:
                            selectedFragment = new OrderCartFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_cont_main,
                            selectedFragment).commit();

                    return true;
                }
            };

}
