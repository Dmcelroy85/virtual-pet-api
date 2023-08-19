package com.wcci.virtualPetAPI.Controllers;

import com.wcci.virtualPetAPI.Models.OrganicDog;
import com.wcci.virtualPetAPI.Repositories.NamedPetRepository;
import com.wcci.virtualPetAPI.Repositories.OrganicDogRepository;
import com.wcci.virtualPetAPI.Repositories.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrganicDogController {
    final ShelterRepository shelterRepository;
    final NamedPetRepository namedPetRepository;
    final OrganicDogRepository organicDogRepository;

    public OrganicDogController(@Autowired ShelterRepository shelterRepository,
            NamedPetRepository namedPetRepository,
            OrganicDogRepository organicDogRepository) {
        this.shelterRepository = shelterRepository;
        this.namedPetRepository = namedPetRepository;
        this.organicDogRepository = organicDogRepository;
    }


    @PostMapping("/api/shelters/{shelter_id}/organicDog")
    public OrganicDog addPet(@RequestBody OrganicDog organicDog, final @PathVariable Long shelter_id) {
        organicDog.setShelter(shelterRepository.findById(shelter_id).get());
        namedPetRepository.save(organicDog);
        return organicDog;
    }

    @PutMapping("/api/shelters/{shelter_id}/organicDog/{organicDog_id}")
    public void updatePet(@PathVariable Long organicDog_id, final @PathVariable Long shelter_id, @RequestBody OrganicDog organicDog) throws Exception {
        if (organicDog.getId() != organicDog_id) {
            throw new Exception("Style body has id " + organicDog.getId() + " but url had id " + organicDog_id);
        }
        organicDogRepository.save(organicDog);
    }

    @PutMapping("/api/organicDog/{organicDog_id}")
    public void feedPet(@PathVariable Long organicDog_id) {
        organicDogRepository.findById(organicDog_id).get().feed();
        organicDogRepository.save(organicDogRepository.findById(organicDog_id).get());
    }

    @DeleteMapping("/api/organicDog/{organicDog_id}")
    public void deleteOrganicDog(@PathVariable final long organicDog_id) {
        organicDogRepository.delete(organicDogRepository.findById(organicDog_id).get());
    }


}