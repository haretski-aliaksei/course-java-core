package com.rakovets.course.java.core.practice.oop_classes_and_objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AtmTest {
    Atm atm = new Atm(0, 0, 0);

    @Test
    public void testGetBanknotes() {
        Assertions.assertEquals(0, atm.getNumberBanknotes20());
        Assertions.assertEquals(0, atm.getNumberBanknotes50());
        Assertions.assertEquals(0, atm.getNumberBanknotes100());
    }

    @Test
    public void testAddBanknotes() {
        atm.addBanknotes20(1);
        atm.addBanknotes50(2);
        atm.addBanknotes100(3);

        Assertions.assertEquals(1, atm.getNumberBanknotes20());
        Assertions.assertEquals(2, atm.getNumberBanknotes50());
        Assertions.assertEquals(3, atm.getNumberBanknotes100());
    }
}
