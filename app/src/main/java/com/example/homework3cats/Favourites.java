package com.example.homework3cats;

import java.util.ArrayList;
import java.util.HashSet;

//class for favourites
public class Favourites {
    //arrayList to hold favourites, static
    //contains arrayList of the Ids of animals that are favourites
    public static ArrayList<String> favIdArray = new ArrayList<>();

    //hashSet to hold favourites (beta)
    public static HashSet<String> favIdSet = new HashSet<>();

    //arrayList of Cats
    public static  ArrayList<Cat> favCats = new ArrayList<>();

    public static ArrayList<String> getFavIdArray() {
        return favIdArray;
    }

    public static void setFavIdArray(ArrayList<String> favIdArray) {
        Favourites.favIdArray = favIdArray;
    }

    public static HashSet<String> getFavIdSet() {
        return favIdSet;
    }

    public static void setFavIdSet(HashSet<String> favIdSet) {
        Favourites.favIdSet = favIdSet;
    }
}
