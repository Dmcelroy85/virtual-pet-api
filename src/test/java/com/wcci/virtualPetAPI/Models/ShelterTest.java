package com.wcci.virtualPetAPI.Models;

import com.wcci.virtualPetAPI.Models.OrganicDog;
import com.wcci.virtualPetAPI.Models.RoboticDog;
import com.wcci.virtualPetAPI.Models.Shelter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShelterTest {

    @Test
    public void testGetShelter() {
        Shelter shelter = new Shelter("Shelter 1");
        assertEquals("Shelter 1", shelter.getName());

    }

    @Test
    public void addPetToShelter() {
        OrganicDog tester = new OrganicDog("tester");
        Shelter shelter = new Shelter("Shelter 1");
        shelter.addPet(tester);
        assertTrue(shelter.getAllPets().contains(tester));
    }

    @Test
    public void removePetFromShelter() {
        OrganicDog tester = new OrganicDog("tester");
        Shelter shelter = new Shelter("Shelter 1");
        shelter.addPet(tester);
        shelter.removePet(tester);
        assertNotEquals(tester, shelter.getAllPets().contains(tester));
    }

    @Test
    public void testReturnAllPetsFromAShelterWithOnePet() {
        OrganicDog tester1 = new OrganicDog("tester");
        Shelter shelter = new Shelter("Shelter 1");
        shelter.addPet(tester1);
        assertEquals(1, shelter.getAllPets().size());

    }

    @Test
    public void testReturnAllPetsFromAShelterWithTwoPet() {
        OrganicDog tester1 = new OrganicDog("tester1");
        RoboticDog tester2 = new RoboticDog("tester2");
        Shelter shelter = new Shelter("Shelter 1");
        shelter.addPet(tester1);
        shelter.addPet(tester2);
        assertEquals(2, shelter.getAllPets().size());

    }

    @Test
    public void tickAllPets() {
        OrganicDog tester1 = new OrganicDog("tester1");
        OrganicCat tester2 = new OrganicCat("tester2");
        RoboticDog tester3 = new RoboticDog("tester3");
        Shelter shelter = new Shelter("Shelter 1");
        shelter.addPet(tester1);
        shelter.addPet(tester2);
        shelter.addPet(tester3);
        shelter.tickAll();
        assertEquals(7, tester1.getHunger());
        assertEquals(7, tester2.getHunger());
        assertEquals(7, tester2.getHunger());

    }

}