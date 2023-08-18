package com.wcci.virtualPetAPI.Models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrganicDogTest {

    @Test
    public void testAddOrganicDogReturnsId() {
        OrganicDog organicDog = new OrganicDog("Fido");
        organicDog.setId(1);
        assertEquals(1, organicDog.getId());
    }

    @Test
    public void testConstructAndReturnName() {
        OrganicDog organicDog = new OrganicDog("Fido");
        assertEquals("Fido", organicDog.getName());
    }

    @Test
    public void testSetAndGetHunger() {
        OrganicDog organicDog = new OrganicDog("Fido");
        organicDog.setHunger(1);
        assertEquals(1, organicDog.getHunger());
    }

    @Test
    public void testFeedReducerHunger() {
        OrganicDog organicDog = new OrganicDog("Fido");
        organicDog.setHunger(10);
        organicDog.feed();
        assertEquals(6, organicDog.getHunger());
    }

    @Test
    public void testTick() {
        OrganicDog organicDog = new OrganicDog("Fido");
        organicDog.tick();
        assertEquals(7, organicDog.getHunger());
    }
}