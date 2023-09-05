package com.example.virtual_pet_api.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    public Volunteer() {
        this.shelters = new ArrayList<>();
    }

    public Volunteer(String name) {
        this.name = name;
    }

    @ManyToMany
    @JoinTable(name = "shelter_volunteer", joinColumns = @JoinColumn(name = "volunteer_id"), inverseJoinColumns = @JoinColumn(name = "shelter_id"))
    private List<Shelter> shelters = new ArrayList<>();

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Shelter> getShelters() {
        return this.shelters;
    }

    public void setShelters(List<Shelter> shelters) {
        this.shelters = shelters;
    }

}
