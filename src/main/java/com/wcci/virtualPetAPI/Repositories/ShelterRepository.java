package com.wcci.virtualPetAPI.Repositories;

import com.wcci.virtualPetAPI.Models.Shelter;
import org.springframework.data.repository.CrudRepository;


public interface ShelterRepository extends CrudRepository<Shelter, Long> {
}