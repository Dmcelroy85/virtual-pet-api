package com.example.virtual_pet_api.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.virtual_pet_api.Models.Volunteer;

public interface VolunteerRepo extends JpaRepository<Volunteer, Long>{
    List<Volunteer> findByName(String name);
}
