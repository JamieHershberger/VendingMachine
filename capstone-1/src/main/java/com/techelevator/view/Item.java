package com.techelevator.view;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class Item {
    private String item;
    private double price;
    final int maxItems = 5;

    public int getMaxItems() {
        return maxItems;
    }

    public Item(String item, double price) {
        this.item = item;
        this.price = price;
    }

//Returns Item name
    public String getItem() {
        return item;
    }
//Returns Item Price
    public double getPrice() {
        return price;
    }
//Abstract method that allos us to call any sound to an Item is extended to
    public abstract String getSound();
}
