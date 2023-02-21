package com.techelevator.view.source;


import com.techelevator.view.Item;

public class Drinks extends Item {

    public Drinks(String item, double price) {
        super(item, price);
    }
//Required sound to return upon purchase
@Override
    public String getSound() {


        return "Glug Glug, Yum!";
    }


}
