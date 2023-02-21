package com.techelevator.view;

import com.techelevator.view.source.Candy;
import org.junit.Test;

        import static org.junit.Assert.*;

public class CandyTest {
    @Test
    public void shouldReturnCandySound() {
        var test = new Candy("Lollipop", .15);
        assertEquals("Munch Munch, Yum!", test.getSound());
    }

    @Test
    public void shouldReturnCandyName() {
        var test = new Candy("Lollipop", .15);
        assertEquals("Lollipop", test.getItem());
    }

    @Test
    public void shouldReturnCandyPrice() {
        var test = new Candy("Lollipop", .15);
        assertEquals(0.15, test.getPrice(), 0.15);
    }

}