package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestSILab2 {

    @Test
    void testEveryStatement() {
        // Test case 1
        RuntimeException ex1 = assertThrows(RuntimeException.class,
                () -> SILab2.checkCart(null, "5458521478569874"));
        assertEquals("allItems list can't be null!", ex1.getMessage());

        // Test case 2
        List<Item> nameNull = List.of(new Item(null, 1, 100, 0));
        RuntimeException ex2 = assertThrows(RuntimeException.class,
                () -> SILab2.checkCart(nameNull, "5458521478569874"));
        assertEquals("Invalid item!", ex2.getMessage());

        // Test case 3
        List<Item> discount = List.of(new Item("Milk", 2, 100, 0.2));
        assertEquals(130.0, SILab2.checkCart(discount, "5458521478569874"));

        // Test case 4
        List<Item> noDiscount = List.of(new Item("Milk", 2, 100, 0.0));
        RuntimeException ex3 = assertThrows(RuntimeException.class,
                () -> SILab2.checkCart(noDiscount, "5448D21478569874"));
        assertEquals("Invalid character in card number!", ex3.getMessage());

        // Test case 5
        RuntimeException ex4 = assertThrows(RuntimeException.class,
                () -> SILab2.checkCart(noDiscount, "544869874"));
        assertEquals("Invalid card number!", ex4.getMessage());


    }

    @Test
    void testMultipleCondition() {

        // T X X
        assertEquals(271.0, SILab2.checkCart(List.of(new Item("Milk", 1, 301, 0)), "5458521478569874"));

        // F T X
        assertEquals(69.0, SILab2.checkCart(List.of(new Item("Milk", 11, 10, 0.1)), "5458521478569874"));

        // F F T
        assertEquals(51.0, SILab2.checkCart(List.of(new Item("Milk", 10, 9, 0.1)), "5458521478569874"));

        // F F F
        assertEquals(500.0, SILab2.checkCart(List.of(new Item("Milk", 5, 100, 0)), "5458521478569874"));


    }
}
