package com.techelevator.view.source;

import com.techelevator.view.Item;

public class Chips extends Item {

    public Chips(String item, double price) {
        super(item, price);
    }

//Once again implementing requirement for assigned sound to return upon purchase.
    @Override
    public String getSound() {


        return "Crunch Crunch, Yum!";
    }



}
