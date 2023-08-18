package com.wcci.virtualPetAPI.Controllers;

import com.wcci.virtualPetAPI.Models.RoboticDog;
import com.wcci.virtualPetAPI.Repositories.NamedPetRepository;
import com.wcci.virtualPetAPI.Repositories.RoboticDogRepository;
import com.wcci.virtualPetAPI.Repositories.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoboticDogController {
    final ShelterRepository shelterRepository;
    final NamedPetRepository namedPetRepository;

    final RoboticDogRepository roboticDogRepository;

    public RoboticDogController(@Autowired ShelterRepository shelterRepository,
                                NamedPetRepository namedPetRepository,
                                RoboticDogRepository roboticDogRepository) {
        this.shelterRepository = shelterRepository;
        this.namedPetRepository = namedPetRepository;
        this.roboticDogRepository = roboticDogRepository;
    }

    //    curl -s -X POST http://localhost:8080/api/shelters/1/roboticDogs -H 'Content-Type: application/json' -d '{"name": "testRobotDog"}'
    @PostMapping("/api/shelters/{shelter_id}/roboticDogs")
    public RoboticDog addRoboticPet(@RequestBody RoboticDog roboticDog, final @PathVariable Long shelter_id) {
        roboticDog.setShelter(shelterRepository.findById(shelter_id).get());
        namedPetRepository.save(roboticDog);
        return roboticDog;
    }

    @PutMapping("/api/roboticDog/{roboticDog_id}")
    public void oilRoboticDog(@PathVariable Long roboticDog_id) {
        roboticDogRepository.findById(roboticDog_id).get().giveOil();
        roboticDogRepository.save(roboticDogRepository.findById(roboticDog_id).get());
    }

    //curl -X DELETE http://localhost:8080/api/roboticDog/1 -H 'Content-Type: application/json'
    @DeleteMapping("/api/roboticDog/{roboticDog_id}")
    public void deleteRoboticDog(@PathVariable final long roboticDog_id) {
        roboticDogRepository.delete(roboticDogRepository.findById(roboticDog_id).get());
    }
}