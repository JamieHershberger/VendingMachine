package com.techelevator.view;

import com.techelevator.view.source.Candy;
import com.techelevator.view.source.Gum;
import org.junit.Test;

import static org.junit.Assert.*;

public class GumTest {
    @Test
    public void shouldReturnGumSound(){
        var test = new Gum("UChew", 0.75);
        assertEquals("Chew Chew, Yum!", test.getSound());
    }

    @Test
    public void shouldReturnGumName() {
        var test = new Candy("UChew", 0.75);
        assertEquals("UChew", test.getItem());
    }

    @Test
    public void shouldReturnGumPrice() {
        var test = new Candy("UChew", 0.75);
        assertEquals(0.75, test.getPrice(), 0.75);
    }



}
