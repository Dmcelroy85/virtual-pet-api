package com.wcci.virtualPetAPI.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Shelter {
    private String name;
    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy = "shelter")
    @JsonIgnore
    private Collection<OrganicDog> organicDogs;

    @OneToMany(mappedBy = "shelter")
    @JsonIgnore
    private Collection<OrganicCat> organicCats;

    @OneToMany(mappedBy = "shelter")
    @JsonIgnore
    private Collection<RoboticDog> roboticDogs;

    @OneToMany(mappedBy = "shelter")
    @JsonIgnore
    private Collection<RoboticCat> roboticCats;

    public Shelter(String name) {
        this.name = name;
    }

    public Shelter() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<OrganicDog> getOrganicDogs() {
        return organicDogs;
    }

    public Collection<OrganicCat> getOrganicCats() {
        return organicCats;
    }

    public Collection<RoboticDog> getRoboticDogs() {
        return roboticDogs;
    }

    public Collection<RoboticCat> getRoboticCats() {
        return roboticCats;
    }

}