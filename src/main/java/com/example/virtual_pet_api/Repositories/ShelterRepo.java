package com.example.virtual_pet_api.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.virtual_pet_api.Models.Shelter;

public interface ShelterRepo extends JpaRepository<Shelter, Long> {
    List<Shelter> findByName(String name);
}
