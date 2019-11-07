package com.example.homework3cats;

import java.util.ArrayList;

//class is to record the orders into an Array
public class Order {

static protected ArrayList<Integer> itemId = new ArrayList<Integer>();
static protected ArrayList<Double> itemPrice = new ArrayList<Double>();
static protected ArrayList<Integer> itemAmount = new ArrayList<Integer>();
static protected ArrayList<Double> itemArrayTotal = new ArrayList<Double>();
    //create an array to hold the number of items ordered
    //this is used to calculate the number of items ordered
    //each item has its own location (-1)
static protected int[] numberOfItems = new int[FoodDatabase.getAllFood().size()];

    public Order() {
    }

    public static ArrayList<Integer> getItemId() {
        return itemId;
    }

    public static void setItemId(ArrayList<Integer> itemId) {
        Order.itemId = itemId;
    }

    public static ArrayList<Double> getItemPrice() {
        return itemPrice;
    }

    public static void setItemPrice(ArrayList<Double> itemPrice) {
        Order.itemPrice = itemPrice;
    }

    public static ArrayList<Integer> getItemAmount() {
        return itemAmount;
    }

    public static void setItemAmount(ArrayList<Integer> itemAmount) {
        Order.itemAmount = itemAmount;
    }

    public static ArrayList<Double> getItemArrayTotal() {
        return itemArrayTotal;
    }

    public static void setItemArrayTotal(ArrayList<Double> itemArrayTotal) {
        Order.itemArrayTotal = itemArrayTotal;
    }

    public static int[] getNumberOfItems() {
        return numberOfItems;
    }

    public static void setNumberOfItems(int[] numberOfItems) {
        Order.numberOfItems = numberOfItems;
    }
}
