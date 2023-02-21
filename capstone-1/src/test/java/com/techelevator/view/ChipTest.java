package com.techelevator.view;
import com.techelevator.view.source.Candy;
import com.techelevator.view.source.Chips;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChipTest {
    @Test
    public void shouldReturnChipSound() {
        var test = new Chips("Ridges", 3.05);
        assertEquals("Crunch Crunch, Yum!", test.getSound());
    }

    @Test
    public void shouldReturnChipName() {
        var test = new Candy("Ridges", 3.05);
        assertEquals("Ridges", test.getItem());
    }

    @Test
    public void shouldReturnChipPrice() {
        var test = new Candy("Ridges", 3.05);
        assertEquals(3.05, test.getPrice(), 3.05);
    }




}