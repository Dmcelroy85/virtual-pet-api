package com.example.virtual_pet_api.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.virtual_pet_api.Models.RoboticCat;

public interface RoboticCatRepo extends JpaRepository<RoboticCat, Long>{
    List<RoboticCat> findByName(String name);
    List<RoboticCat> findByIsOiled(boolean isOiled);
    List<RoboticCat> findByDescription(String description);
}
