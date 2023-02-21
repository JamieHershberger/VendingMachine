package com.techelevator.view;

import com.techelevator.view.source.Candy;
import com.techelevator.view.source.Drinks;
import org.junit.Test;

import static org.junit.Assert.*;

public class DrinksTest {
    @Test
    public void shouldReturnDrinkSound() {
        var test = new Drinks("Fantasy Fizz", 1.00);
        assertEquals("Glug Glug, Yum!", test.getSound());
    }
    @Test
    public void shouldReturnDrinkName() {
        var test = new Candy("Fantasy Fizz", 1.00);
        assertEquals("Fantasy Fizz", test.getItem());
    }

    @Test
    public void shouldReturnDrinkPrice() {
        var test = new Candy("Fantasy Fizz", 1.00);
        assertEquals(1.00, test.getPrice(), 1.00);
    }



}
