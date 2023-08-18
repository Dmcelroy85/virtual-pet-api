package com.wcci.virtualPetAPI.Models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoboticCatTest {

    @Test
    public void testAddRoboticCatReturnsId() {
        RoboticCat roboticCat = new RoboticCat("Tom");
        roboticCat.setId(1);
        assertEquals(1, roboticCat.getId());
    }

    @Test
    public void testConstructAndReturnName() {
        RoboticCat roboticCat = new RoboticCat("Tom");
        assertEquals("Tom", roboticCat.getName());
    }

    @Test
    public void testSetAndGetOil() {
        RoboticCat roboticCat = new RoboticCat("Tom");
        roboticCat.setOil(1);
        assertEquals(1, roboticCat.getOil());
    }

    @Test
    public void testGiveOilSetsOilToZero() {
        RoboticCat roboticCat = new RoboticCat("Tom");
        roboticCat.setOil(10);
        roboticCat.giveOil();
        assertEquals(6, roboticCat.getOil());
    }
}