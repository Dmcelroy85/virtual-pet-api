package com.wcci.virtualPetAPI.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Random;

@Entity
    public class OrganicCat {
        @Id
        @GeneratedValue
        private long id;
        private String name;
        private int hungerLevel;
        private int thirstLevel;
        private int boredomLevel;
        private int litterBoxCleanliness;
        @ManyToOne
        @JsonIgnore
        private Shelter shelter;

        public OrganicCat (String name, int hungerLevel, int thirstLevel, int boredomLevel, int litterBoxCleanliness, Shelter shelter) {
            this.name = name;
            this.hungerLevel = hungerLevel;
            this.thirstLevel = thirstLevel;
            this.boredomLevel = boredomLevel;
            this.litterBoxCleanliness = litterBoxCleanliness;
            this.shelter = shelter;
        }
        public OrganicCat() {

        }
        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getHungerLevel() {
            return hungerLevel;
        }

        public int getThirstLevel() {
            return thirstLevel;
        }

        public int getBoredomLevel() {
            return boredomLevel;
        }

        public int getLitterBoxCleanliness() {
            return litterBoxCleanliness;
        }

    public Shelter getShelter() {
        return shelter;
    }

    public void setShelter(Shelter shelter) {
        this.shelter = shelter;
    }

    public void feed() {

            this.hungerLevel -= 20;
        }
        public void drink() {

            this.thirstLevel -= 20;
        }
        public void play() {

            this.boredomLevel -= 20;
        }
        public void tick() {
            this.hungerLevel += 5;
            this.thirstLevel += 5;
            this.boredomLevel += 5;
            this.litterBoxCleanliness += 5;
            if (this.litterBoxCleanliness > 100) {
                this.litterBoxCleanliness = 100;
            }
            if (this.litterBoxCleanliness < 0) {
                this.litterBoxCleanliness = 0;
            }
            if (this.hungerLevel > 100) {
                this.hungerLevel = 100;
            }
            if (this.thirstLevel > 100) {
                this.thirstLevel = 100;
            }
            if (this.boredomLevel > 100) {
                this.boredomLevel = 100;
            }
            if (this.hungerLevel < 0) {
                this.hungerLevel = 0;
            }
            if (this.thirstLevel < 0) {
                this.thirstLevel = 0;
            }
            if (this.boredomLevel < 0) {
                this.boredomLevel = 0;
            }

        }
        public String status() {
            this.petBehavior();
            return this.name + "'s hunger level is " + this.hungerLevel +
            " their thirst level is " + this.thirstLevel +" their boredom level is "
            + this.boredomLevel + " and their litter box level is" + this.litterBoxCleanliness;
        }

        private void petBehavior() {
            Random random = new Random();
            int petChoice = random.nextInt(4 - 1) + 1;
            if (this.hungerLevel > 70 && petChoice == 1) {
                this.hungerLevel -= 10;
                System.out.println("I was very hungry so I found a snack");
            }
            if (this.thirstLevel > 70 && petChoice == 2) {
                this.thirstLevel -= 10;
                System.out.println("I was very thirsty so I got myself a drink");
            }
            if (this.boredomLevel > 70 && petChoice == 3) {
                this.boredomLevel -= 10;
                System.out.println("I was very bored so I played by myself");
            }
        }
                public String showPet() {
            if (this.hungerLevel >= 66 || this.thirstLevel >= 66 || this.boredomLevel >= 66 || this.litterBoxCleanliness >= 66) {
                return("Mad");
            }
            else if (this.hungerLevel >= 33 || this.thirstLevel >= 33 || this.boredomLevel >= 33 || this.litterBoxCleanliness >= 33) {
                return("Content");
            }
            else {
                return("Happy");
            }
        }

        public void cleanArea() {
            this.litterBoxCleanliness = 0;
        }
    }