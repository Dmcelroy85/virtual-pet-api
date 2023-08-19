package com.wcci.virtualPetAPI.Models;

import javax.persistence.Entity;

import static com.wcci.virtualPetAPI.Models.NamedPet.PET_TYPE.ROBOTIC_DOG;

@Entity
public class RoboticDog extends NamedPet {

    private int oil = 6;
    private PET_TYPE type = ROBOTIC_DOG;

    public PET_TYPE getType() {
        return type;
    }


    public RoboticDog(String name) {
        super(name);
    }

    public RoboticDog() {
        super();
    }

    public int getOil() {
        return oil;
    }

    public void setOil(int oil) {
        this.oil = oil;
    }

    public void giveOil() {
        oil = oil - 4;
    }

    @Override
    public void tick() {
        oil++;
    }


    public Object status() {
        return null;
    }


    public String showPet() {
        return null;
    }
}