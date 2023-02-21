package com.techelevator.view;

import java.io.IOException;
import java.util.Scanner;

//Here is where all our money related math goes
public class Cash {
    private double balance;
    private double change;
    Inventory inventory;
    Scanner scanner = new Scanner(System.in);

    public Cash(Inventory inventory) {
        this.inventory = inventory;
    }

    public double feedMoney() {
        System.out.println("Accepting $1, $2, $5, or $10");
//To make sure customer enters only allowable amounts
        while (true) {
            try {
                double money = scanner.nextInt();

                if (money == 1 || money == 2 || money == 5 || money == 10) {

                    balance += money;
                    System.out.println("Current Money Provided: " + "$" + balance);
                    System.out.println("Feed more money? Y/N");
                    scanner.nextLine();
                    String yesNo = scanner.nextLine();
                    //Decides if more money should be added or not
                    if (yesNo.equalsIgnoreCase("Y")) {
                        System.out.println("Feed money");
                        Log.log("FEED MONEY: " + String.valueOf(balance));
                    } else if (yesNo.equalsIgnoreCase("N")) {
                        System.out.println("Make your selection:");
                        //currently logs only once
                        Log.log("FEED MONEY: " + String.valueOf(balance));
                        break;
                    } else {
                        System.out.println("Invalid Input");
                    }
                } else {
                    System.out.println("Invalid input");
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
                break;
            }
        }
        return balance;
    }

    //Method that does the money math
    public double transaction() {
        if (balance == 0) {
            System.out.println("Please insert money!");
        } else {
            try {
                System.out.println("Please enter snack item location");
                String item = scanner.nextLine();
                //Makes sure stock doesnt go into negatives
                if (inventory.maxInventory().get(item) == 0) {
                    System.out.println("Out of stock");
                } else {
                    //"&& balance > inventory" added to catch error of not enough money entered
                    if (inventory.stockDisplay().containsKey(item) && balance > inventory.stockDisplay().get(item).getPrice()) {
                        System.out.println(inventory.stockDisplay().get(item).getItem() + " " + inventory.stockDisplay().get(item).getPrice()
                                + " \n" + inventory.stockDisplay().get(item).getSound());
                        //Calculates change. Math.round is important to make sure we get 2 decimal places.
                        change = balance - inventory.stockDisplay().get(item).getPrice();
                        change = Math.round(change * 100.00) / 100.00;
                        System.out.println("Funds Remaining: " + change);
                        //Decreases inventory
                        inventory.decreaseInventory(item);
                        //Logs the transaction
                        Log.log(inventory.stockDisplay().get(item).getItem() + balance + change);
                        balance = change;
                    } else if (!(balance > inventory.stockDisplay().get(item).getPrice())) {
                        System.out.println("Insufficient funds!!!");
                    } else if (!inventory.stockDisplay().containsKey(item)) {
                        System.out.println("Item does not exist. Please try again.");

                    }
                }
            } catch (Exception e) {
                // e.printStackTrace();
                System.out.println("Item does not exist. Please try again.");
            }
        }
        return balance;
    }

    //Returns change and resets balance to zero
    public double Change() {
        double reset = change * 0;
        Log.log("GIVE CHANGE: " + "$" + String.valueOf(change) + " " + "$" + reset);
        return change;

    }

    public String coins() {
        //Casted change into an int and multiplied by 100 to process in while loop
        int newChange = (int) (change * 100);
        int amountOfQuarters = 0;
        int amountOfDimes = 0;
        int amountOfNickels = 0;

        int quarter = 25;
        int dime = 10;
        int nickel = 5;

        while (newChange > 0) {
            if (newChange >= quarter) {
                amountOfQuarters++;
                newChange -= quarter;
            } else if (newChange >= dime) {
                amountOfDimes++;
                newChange -= dime;
            } else if (newChange >= nickel) {
                amountOfNickels++;
                newChange -= nickel;
            }
        }
        String changeStatement = "Dispensing: " + amountOfQuarters + " quarters, " + amountOfDimes + " dimes, " + amountOfNickels + " nickels";

        return changeStatement;
    }


}
