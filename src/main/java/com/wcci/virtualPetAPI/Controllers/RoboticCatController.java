package com.wcci.virtualPetAPI.Controllers;

import com.wcci.virtualPetAPI.Models.NamedPet;
import com.wcci.virtualPetAPI.Repositories.NamedPetRepository;
import com.wcci.virtualPetAPI.Repositories.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

public class PetsController {
    final ShelterRepository shelterRepository;
    final NamedPetRepository namedPetRepository;

    public PetsController(@Autowired ShelterRepository shelterRepository,
        NamedPetRepository namedPetRepository) {
        this.shelterRepository = shelterRepository;
        this.namedPetRepository = namedPetRepository;
    }

    //    curl -X GET http://localhost:8080/api/shelters/1/pets -H 'Content-Type: application/json'
    @GetMapping("/api/shelters/{shelter_id}/pets")
    public Collection<NamedPet> getShelters(@PathVariable final long shelter_id) {
        return shelterRepository.findById(shelter_id).get().getAllPets();
    }

    @PostMapping("/api/pets")
    public NamedPet addPet(@RequestBody NamedPet namedPet) {
        return namedPetRepository.save(namedPet);
    }
}