package com.wcci.virtualPetAPI.Models;

import javax.persistence.Entity;

import static com.wcci.virtualPetAPI.Models.NamedPet.PET_TYPE.ROBOTIC_CAT;

@Entity
public class RoboticCat extends NamedPet {

    private int oil = 6;
    private final PET_TYPE type = ROBOTIC_CAT;

    public PET_TYPE getType() {
        return type;
    }


    public RoboticCat(String name) {
        super(name);
    }

    public RoboticCat() {
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
}