package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class InventoryTest {

    private  Inventory inventory = new Inventory();

    public InventoryTest() throws IOException {
    }
    @Test
    public void findTheKeyValueTest() throws IOException {
        Assert.assertEquals( "A1", inventory.maxInventory().firstKey());
    }

    @Test
    public void findTheItem() throws IOException {
        String item = inventory.maxInventory().firstKey();
        Assert.assertEquals( "Potato Crisps", inventory.stockDisplay().get(item).getItem());
    }

    @Test
    public void findTheItemPrice() throws IOException {
        String item = inventory.maxInventory().firstKey();
        Assert.assertEquals( 3.05, inventory.stockDisplay().get(item).getPrice(), 3.05);
    }

    @Test
    public void findSecondTheItem() throws IOException {

        Assert.assertEquals( "Stackers", inventory.stockDisplay().get("A2").getItem());
    }

    @Test
    public void findSecondTheItemPrice() throws IOException {

        Assert.assertEquals( 1.45, inventory.stockDisplay().get("A2").getPrice(), 1.45);
    }

}
