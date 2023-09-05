package com.example.virtual_pet_api.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RoboticDog extends VirtualPet{
    @ManyToOne
    @JoinColumn(name = "shelter_id")
    private Shelter shelter;

    private boolean isOiled;

    public RoboticDog() {
    }

    public RoboticDog(int happiness, String name, String description, boolean isOiled) {
        super(happiness, name, description);
        this.isOiled = isOiled;
    }

    public Shelter getShelter() {
        return this.shelter;
    }

    public void setShelter(Shelter shelter) {
        this.shelter = shelter;
    }

    public boolean isIsOiled() {
        return this.isOiled;
    }

    public boolean getIsOiled() {
        return this.isOiled;
    }

    public void setIsOiled(boolean isOiled) {
        this.isOiled = isOiled;
    }

}
