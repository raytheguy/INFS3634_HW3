package com.example.homework3cats;

import java.io.Serializable;
import java.util.ArrayList;

//model for cats
public class Cat implements Serializable {

    //based upon assignment criteria and Json Model
    //only dog friend is an integer
    String id;
    String name;
    String description;
    String weight_imperial;
    String temperament;
    String origin;
    String life_span;
    String wikipedia_url;
    int dog_friendly;

    //no images here

//    private ArrayList<Cat> cats;

    public Cat() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWeight_imperial() {
        return weight_imperial;
    }

    public void setWeight_imperial(String weight_imperial) {
        this.weight_imperial = weight_imperial;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getLife_span() {
        return life_span;
    }

    public void setLife_span(String life_span) {
        this.life_span = life_span;
    }

    public String getWikipedia_url() {
        return wikipedia_url;
    }

    public void setWikipedia_url(String wikipedia_url) {
        this.wikipedia_url = wikipedia_url;
    }

    public int getDog_friendly() {
        return dog_friendly;
    }

    public void setDog_friendly(int dog_friendly) {
        this.dog_friendly = dog_friendly;
    }

}
