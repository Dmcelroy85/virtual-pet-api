package com.wcci.virtualPetAPI.Models;

import javax.persistence.Entity;

import static com.wcci.virtualPetAPI.Models.NamedPet.PET_TYPE.ORGANIC_DOG;

@Entity
public class OrganicDog extends NamedPet {

    private int hunger = 6;
    private PET_TYPE type = ORGANIC_DOG;

    public PET_TYPE getType() {
        return type;
    }

    public OrganicDog(String name) {
        super(name);
    }

    public OrganicDog() {
        super();
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public void feed() {
        hunger = hunger - 4;
    }

    @Override
    public void tick() {
        hunger++;
    }

    public String status() {
        return null;
    }

    public String showPet() {
        return null;
    }

}