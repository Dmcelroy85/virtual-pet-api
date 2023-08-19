package com.wcci.virtualPetAPI.Controllers;

import com.wcci.virtualPetAPI.Models.RoboticCat;
import com.wcci.virtualPetAPI.Repositories.NamedPetRepository;
import com.wcci.virtualPetAPI.Repositories.RoboticCatRepository;
import com.wcci.virtualPetAPI.Repositories.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoboticCatController {
    final ShelterRepository shelterRepository;
    final NamedPetRepository namedPetRepository;

    final RoboticCatRepository roboticCatRepository;

    public RoboticCatController(@Autowired ShelterRepository shelterRepository,
            NamedPetRepository namedPetRepository,
            RoboticCatRepository roboticCatRepository) {
        this.shelterRepository = shelterRepository;
        this.namedPetRepository = namedPetRepository;
        this.roboticCatRepository = roboticCatRepository;
    }

    @PostMapping("/api/shelters/{shelter_id}/roboticCats")
    public RoboticCat addRoboticPet(@RequestBody RoboticCat roboticCat, final @PathVariable Long shelter_id) {
        roboticCat.setShelter(shelterRepository.findById(shelter_id).get());
        namedPetRepository.save(roboticCat);
        return roboticCat;
    }

    @PutMapping("/api/roboticCat/{roboticCat_id}")
    public void oilRoboticCat(@PathVariable Long roboticCat_id) {
        roboticCatRepository.findById(roboticCat_id).get().giveOil();
        roboticCatRepository.save(roboticCatRepository.findById(roboticCat_id).get());
    }

    @DeleteMapping("/api/roboticCat/{roboticCat_id}")
    public void deleteRoboticCat(@PathVariable final long roboticCat_id) {
        roboticCatRepository.delete(roboticCatRepository.findById(roboticCat_id).get());
    }
}