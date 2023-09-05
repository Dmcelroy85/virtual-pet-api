package com.example.virtual_pet_api.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.virtual_pet_api.Models.RoboticDog;

public interface RoboticDogRepo extends JpaRepository<RoboticDog, Long>{
    List<RoboticDog> findByName(String name);
    List<RoboticDog> findByIsOiled(boolean isOiled);
    List<RoboticDog> findByDescription(String description);
}
