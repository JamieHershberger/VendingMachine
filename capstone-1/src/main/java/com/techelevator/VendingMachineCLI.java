package com.techelevator;

import com.techelevator.view.Cash;
import com.techelevator.view.Inventory;
import com.techelevator.view.Item;
import com.techelevator.view.Menu;
import org.w3c.dom.ls.LSOutput;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.invoke.CallSite;
import java.util.*;

public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_EXIT};

    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_SELECT_OPTION = "Select Product";
    private static final String PURCHASE_MENU_EXIT = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_SELECT_OPTION, PURCHASE_MENU_EXIT};


    private Menu menu;
    private double balance = 0;

    private Inventory inventory;
    private Cash cash;


    public VendingMachineCLI(Menu menu, Inventory inventory) throws IOException {
        this.menu = menu;
        this.inventory = inventory;
        cash = new Cash(inventory);
        inventory.maxInventory();
    }


    public void run() throws IOException {

        while (true) {
            //Had trouble figuring out why the menu went to the first menu always
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
            //double balance = 0;
            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                /*
                Display vending machine items
                Utilizes the fact that stockDisplay and maxInventory share the same keys, but with different values
                to create the menu
                 */
                for (Map.Entry<String, Item> s : inventory.stockDisplay().entrySet()) {
                    String items = String.valueOf(inventory.maxInventory().get(s.getKey()));

                    System.out.printf(s.getKey() + "\t"+ "%-19s" + "\t" + "$%-7s" +"\t" + "Amount: %-5s", s.getValue().getItem(),s.getValue().getPrice(), items);
                    System.out.println();
                }


            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                // do purchase
                //Second menu has to run on while true
                while (true) {
                    String purchase = (String) menu.getChoiceFromPurchase(PURCHASE_MENU_OPTIONS);

                    if (purchase.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
                        cash.feedMoney();
                    } else if (purchase.equals(PURCHASE_MENU_SELECT_OPTION)) {
                        //Take balance and calculate change
                        cash.transaction();
                    } else if (purchase.equals(PURCHASE_MENU_EXIT)) {
                        //Display change
                        System.out.println("Your change is " + cash.Change());
                        //Turns change into coins
                        //Tough time figuring out coins. Had to convert inserted cash to pennies
                        System.out.println(cash.coins());
                        System.out.println("Thank you for your purchase!");
                        break;
                    } else {
                        System.out.println("Invalid Input");
                    }
                }
                //added a main menu exit
            } else if (choice.equals(MAIN_MENU_EXIT)) {
                break;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the Vending Machine!");
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu, new Inventory());
        cli.run();
    }
}
