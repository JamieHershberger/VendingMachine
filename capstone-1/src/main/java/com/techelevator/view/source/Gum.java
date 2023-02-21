package com.techelevator.view.source;

import com.techelevator.view.Item;

import java.sql.SQLOutput;

public class Gum extends Item {
    //Required sound to return upon purchase
    public Gum(String item, double price) {
        super(item, price);
    }
    @Override
    public String getSound() {
        return "Chew Chew, Yum!";
    }

}
