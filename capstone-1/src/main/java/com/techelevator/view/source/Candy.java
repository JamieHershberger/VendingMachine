package com.techelevator.view.source;

import com.techelevator.view.Item;

public class Candy extends Item {

    public Candy(String item, double price) {
        super(item, price);
    }

    public String getSound() {

//Sounds return when purchase made
        return "Munch Munch, Yum!";
    }


}
