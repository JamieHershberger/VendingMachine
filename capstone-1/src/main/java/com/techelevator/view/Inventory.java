package com.techelevator.view;

import com.techelevator.view.source.Candy;
import com.techelevator.view.source.Chips;
import com.techelevator.view.source.Drinks;
import com.techelevator.view.source.Gum;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Inventory {
    private String location;
    private String item;
    private double price;
    private int maxItems = 5;

    TreeMap<String, Item> display = new TreeMap<>();
    TreeMap<String, Integer> fullStock = new TreeMap<>();

    public int getMaxItems() {
        return maxItems;
    }

    public Inventory(String location, String item, double price) throws IOException {
        this.location = location;
        this.item = item;
        this.price = price;
    }

    public Inventory() throws IOException {
    }

    List<String> itemList = new ArrayList<>();
    Path filePath = Path.of("vendingmachine.csv");
    String file = Files.readString(filePath);

    //Method that reads csv into item list
    public List<String> displayInventory() {
        try (Scanner fileInput = new Scanner(file)) {
    //Had trouble with returning null, changed to space
            while (fileInput.hasNextLine()) {
                itemList.add(fileInput.nextLine());
            }

        }
        return itemList;
    }

    //Method that breaks up csv information into usable array elements
    public TreeMap<String, Item> stockDisplay() throws IOException {
        if (!display.isEmpty()) return display;
        for (String s : displayInventory()) {
            String[] csv = s.split("\\|");
            if (csv[3].equalsIgnoreCase("Chip")) {
                Item chip = new Chips(csv[1], Double.parseDouble(csv[2]));
                display.put(csv[0], chip);
            } else if (csv[3].equalsIgnoreCase("Candy")) {
                Item candy = new Candy(csv[1], Double.parseDouble(csv[2]));
                display.put(csv[0], candy);
            } else if (csv[3].equalsIgnoreCase("Drink")) {
                Item drink = new Drinks(csv[1], Double.parseDouble(csv[2]));
                display.put(csv[0], drink);
            } else if (csv[3].equalsIgnoreCase("Gum")) {
                Item gum = new Gum(csv[1], Double.parseDouble(csv[2]));
                display.put(csv[0], gum);
            }

        }
        return display;
    }


    //Made seperate method to keep track of stock
    public TreeMap<String, Integer> maxInventory() throws IOException {
        if (!fullStock.isEmpty()) return fullStock;

        for (Map.Entry<String, Item> s : stockDisplay().entrySet()) {
            fullStock.put(String.valueOf(s.getKey()), getMaxItems());
        }


        return fullStock;
    }


    //Methods that decreases inventory from fullStock
    public void decreaseInventory(String item) throws IOException {
        fullStock.put(item, fullStock.get(item) - 1);

    }


}
