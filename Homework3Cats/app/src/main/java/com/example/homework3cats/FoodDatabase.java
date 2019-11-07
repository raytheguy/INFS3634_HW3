package com.example.homework3cats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FoodDatabase {

    public static Food getFoodById(int itemId) {
        return foods.get(itemId);
    }

    public static ArrayList<Food> getAllFood() {
        return new ArrayList<Food>((List) Arrays.asList(foods.values().toArray()));
    }

    private static final HashMap<Integer, Food> foods = new HashMap<>();

    static {
        foods.put(1, new Food(
                1,
                "Vegetarian Burger",
                "Succulent Vegetarian Burger with Tomato, Lettuce and Bread",
                2.99,
                R.drawable.veg1
        ));
        foods.put(2, new Food(
                2,
                "Chicken Burger",
                "Flame Grilled Chicken with Avocado Sauce",
                4.99,
                R.drawable.chicken2
        ));

        foods.put(3, new Food(
                3,
                "Mix Burger",
                "Burger Mixed with Mystery Meats",
                5.99,
                R.drawable.mixburger3
        ));

        foods.put(4, new Food(
                4,
                "Fish Burger",
                "Burger made of juicy fish batter, thrown in with fresh lettuce",
                4.99,
                R.drawable.fishburg4
        ));

        foods.put(5, new Food(
                5,
                "Plain Burger",
                "Just the burger. Nothing Else",
                1.99,
                R.drawable.plainburger5
        ));

        foods.put(6, new Food(
                6,
                "French Fries",
                "Chips with chicken salt. Salty!",
                2.49,
                R.drawable.fries6
        ));

        foods.put(7, new Food(
                7,
                "Cheese Fries",
                "Fries made from real cheese, mixed with fries made from potatoes",
                2.99,
                R.drawable.cheesefries7
        ));

        foods.put(8, new Food(
                8,
                "Oat Fries",
                "Fries mixed with oak because why not?",
                2.99,
                R.drawable.oatfries8
        ));

        foods.put(9, new Food(
                9,
                "Potato and Gravy",
                "Classic potato and gravy using mashed potato and spices",
                3.49,
                R.drawable.gravy9
        ));

        foods.put(10, new Food(
                10,
                "Chicken Pie",
                "A pie made from chicken. What more do you want?",
                2.99,
                R.drawable.chickenpie10
        ));

        foods.put(11, new Food(
                11,
                "BBQ Chicken Wings",
                "3 Succulent chicken wings mixed with juicy bbq sauce",
                4.99,
                R.drawable.chickenwings11
        ));

        foods.put(12, new Food(
                12,
                "Garden Salad",
                "A salad suitable for vegetarians. It contains the usual salad stuff!",
                9.99,
                R.drawable.gardensalad12
        ));

        foods.put(13, new Food(
                13,
                "Cola",
                "Unbranded cola due to copyright issues",
                2.49,
                R.drawable.cola13
        ));

        foods.put(14, new Food(
                14,
                "Lemonade",
                "Unbranded lemonade due to copyright issues",
                2.49,
                R.drawable.lemonade14
        ));

        foods.put(15, new Food(
                15,
                "Orange Juice",
                "Freshly squeezed orange juice. Nothing else",
                4.99,
                R.drawable.orangejuice15
        ));

    }
}
