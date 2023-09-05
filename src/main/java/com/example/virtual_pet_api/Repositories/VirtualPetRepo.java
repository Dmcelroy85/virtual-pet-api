package com.example.virtual_pet_api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.virtual_pet_api.Models.VirtualPet;

public interface VirtualPetRepo extends JpaRepository<VirtualPet, Long>{
    
}
