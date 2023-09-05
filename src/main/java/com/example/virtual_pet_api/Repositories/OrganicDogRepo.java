package com.example.virtual_pet_api.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.virtual_pet_api.Models.OrganicDog;

public interface OrganicDogRepo extends JpaRepository<OrganicDog, Long>{
    List<OrganicDog> findByName(String name);
    List<OrganicDog> findByIsWalked(boolean isWalked);
    List<OrganicDog> findByIsFed(boolean isFed);
    List<OrganicDog> findByIsWatered(boolean isWatered);
    List<OrganicDog> findByIsCleanCage(boolean isCleanCage);
    List<OrganicDog> findByHunger(int hunger);
    List<OrganicDog> findByDescription(String description);
}
