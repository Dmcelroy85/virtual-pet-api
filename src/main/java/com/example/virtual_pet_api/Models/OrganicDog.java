package com.example.virtual_pet_api.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrganicDog extends VirtualPet{
    @ManyToOne
    @JoinColumn(name = "shelter_id")
    private Shelter shelter;

    private boolean isWalked;
    private boolean isFed;
    private boolean isWatered;
    private boolean isCleanCage;
    private int hunger;

    public OrganicDog() {
    }

    public OrganicDog(int happiness, String name, String description, boolean isWalked, boolean isFed, boolean isWatered, boolean isCleanCage, int hunger) {
        super(happiness, name, description);
        this.isWalked = isWalked;
        this.isFed = isFed;
        this.isWatered = isWatered;
        this.isCleanCage = isCleanCage;
        this.hunger = hunger;
    }

    public Shelter getShelter() {
        return this.shelter;
    }

    public void setShelter(Shelter shelter) {
        this.shelter = shelter;
    }

    public boolean isIsWalked() {
        return this.isWalked;
    }

    public boolean getIsWalked() {
        return this.isWalked;
    }

    public void setIsWalked(boolean isWalked) {
        this.isWalked = isWalked;
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

    public boolean isIsCleanCage() {
        return this.isCleanCage;
    }

    public boolean getIsCleanCage() {
        return this.isCleanCage;
    }

    public void setIsCleanCage(boolean isCleanCage) {
        this.isCleanCage = isCleanCage;
    }

    public int getHunger() {
        return this.hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

}
