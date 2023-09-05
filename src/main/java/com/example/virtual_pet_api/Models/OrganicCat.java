package com.example.virtual_pet_api.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrganicCat extends VirtualPet{
    @ManyToOne
    @JoinColumn(name = "shelter_id")
    private Shelter shelter;

    private boolean isFed;
    private boolean isWatered;
    private boolean isCleanLitterBox;
    private int hunger;

    public OrganicCat() {
    }

    public OrganicCat(int happiness, String name, String description, boolean isFed, boolean isWatered, boolean isCleanLitterBox, int hunger) {
        super(happiness, name, description);
        this.isFed = isFed;
        this.isWatered = isWatered;
        this.isCleanLitterBox = isCleanLitterBox;
        this.hunger = hunger;
    }

    public Shelter getShelter() {
        return this.shelter;
    }

    public void setShelter(Shelter shelter) {
        this.shelter = shelter;
    }

    public boolean isIsFed() {
        return this.isFed;
    }

    public boolean getIsFed() {
        return this.isFed;
    }

    public void setIsFed(boolean isFed) {
        this.isFed = isFed;
    }

    public boolean isIsWatered() {
        return this.isWatered;
    }

    public boolean getIsWatered() {
        return this.isWatered;
    }

    public void setIsWatered(boolean isWatered) {
        this.isWatered = isWatered;
    }

    public boolean isIsCleanLitterBox() {
        return this.isCleanLitterBox;
    }

    public boolean getIsCleanLitterBox() {
        return this.isCleanLitterBox;
    }

    public void setIsCleanLitterBox(boolean isCleanLitterBox) {
        this.isCleanLitterBox = isCleanLitterBox;
    }

    public int getHunger() {
        return this.hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

}
