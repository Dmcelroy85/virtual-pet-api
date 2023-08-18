package com.wcci.virtualPetAPI.Repositories;

import com.wcci.virtualPetAPI.Models.NamedPet;
import org.springframework.data.repository.CrudRepository;

public interface NamedPetRepository extends CrudRepository<NamedPet, Long> {
}