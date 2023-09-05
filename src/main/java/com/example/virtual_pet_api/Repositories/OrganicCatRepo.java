package com.example.virtual_pet_api.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.virtual_pet_api.Models.OrganicCat;

public interface OrganicCatRepo extends JpaRepository<OrganicCat, Long>{
    List<OrganicCat> findByName(String name);
    List<OrganicCat> findByIsFed(boolean isFed);
    List<OrganicCat> findByIsWatered(boolean isWatered);
    List<OrganicCat> findByIsCleanLitterBox(boolean isCleanLitterBox);
    List<OrganicCat> findByHunger(int hunger);
    List<OrganicCat> findByDescription(String description);
}
