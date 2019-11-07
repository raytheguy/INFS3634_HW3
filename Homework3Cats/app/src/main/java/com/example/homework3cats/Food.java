package com.example.homework3cats;

public class Food {

    protected int itemId;
    protected String itemName;
    protected String description;
    protected double price;
    protected int redundantId;
    protected int imageId;

    public Food(int itemId, String itemName, String description, double price, int imageId) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.imageId = imageId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRedundantId() {
        return redundantId;
    }

    public void setRedundantId(int redundantId) {
        this.redundantId = redundantId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
