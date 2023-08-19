package com.wcci.virtualPetAPI.Controllers;


import com.wcci.virtualPetAPI.Models.*;
import com.wcci.virtualPetAPI.Repositories.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ShelterController {
    private ShelterRepository shelterRepo;
    private RoboticCatRepository roboticCatRepo;
    private RoboticDogRepository roboticDogRepo;
    private OrganicCatRepository organicCatRepo;
    private OrganicDogRepository organicDogRepo;

    public ShelterController(ShelterRepository shelterRepo, RoboticCatRepository roboticCatRepo, RoboticDogRepository roboticDogRepo, OrganicCatRepository organicCatRepo, OrganicDogRepository organicDogRepo) {
        this.shelterRepo = shelterRepo;
        this.roboticCatRepo = roboticCatRepo;
        this.roboticDogRepo = roboticDogRepo;
        this.organicCatRepo = organicCatRepo;
        this.organicDogRepo = organicDogRepo;
    }

    @PostMapping("/shelter/{id}/admitOrganicDog")
    public void addOrganicDog(@RequestBody OrganicDog organicDog, @PathVariable long id){
        Optional<Shelter> existingShelter = shelterRepo.findById(id);
        organicDog.setShelter(existingShelter.get());
        organicDogRepo.save(organicDog);
    }

    @PostMapping("/shelter/{id}/admitOrganicCat")
    public void addOrganicCat(@RequestBody OrganicCat organicCat, @PathVariable long id){
        Optional<Shelter> existingShelter = shelterRepo.findById(id);
        organicCat.setShelter(existingShelter.get());
        organicCatRepo.save(organicCat);
    }

    @PostMapping("/shelter/{id}/admitRoboticDog")
        public void addRoboticDog(@RequestBody RoboticDog roboticDog, @PathVariable long id){
        Optional<Shelter> existingShelter = shelterRepo.findById(id);
        roboticDog.setShelter(existingShelter.get());
            roboticDogRepo.save(roboticDog);
    }

    @PostMapping("/shelter/{id}/admitRoboticCat")
    public void addRoboticCat(@RequestBody RoboticCat roboticCat, @PathVariable long id){
        Optional<Shelter> existingShelter = shelterRepo.findById(id);
        roboticCat.setShelter(existingShelter.get());
        roboticCatRepo.save(roboticCat);
    }

    @DeleteMapping("/shelter/adoptRoboticCat/{id}")
    public void adoptRoboticCat(@PathVariable long id){
        roboticCatRepo.deleteById(id);
    }

    @DeleteMapping("/shelter/adoptRoboticDog/{id}")
    public void adoptRoboticDog(@PathVariable long id){
        roboticDogRepo.deleteById(id);
    }

    @DeleteMapping("/shelter/adoptOrganicCat/{id}")
    public void adoptOrganicCat(@PathVariable long id){
        organicCatRepo.deleteById(id);
    }

    @DeleteMapping("/shelter/adoptOrganicDog/{id}")
    public void adoptOrganicDog(@PathVariable long id){
        organicDogRepo.deleteById(id);
    }

    @DeleteMapping("shelter/adoptAll")
    public void adoptAll(){
        roboticCatRepo.deleteAll();
        roboticDogRepo.deleteAll();
        organicDogRepo.deleteAll();
        organicCatRepo.deleteAll();
    }

    @GetMapping("shelter/allStatus")
    public Iterable<String> getAllStatus(){
        List<String> allStatuses = new ArrayList<>();
        Iterable<RoboticCat> allRoboticCats = roboticCatRepo.findAll();
        Iterable<RoboticDog> allRoboticDogs = roboticDogRepo.findAll();
        Iterable<OrganicCat> allOrganicCats = organicCatRepo.findAll();
        Iterable<OrganicDog> allOrganicDogs = organicDogRepo.findAll();
        for(RoboticCat roboticCat: allRoboticCats)
            allStatuses.add(roboticCat.status());
        for(RoboticDog roboticDog: allRoboticDogs)
            allStatuses.add(roboticDog.status());
        for(OrganicCat organicCat: allOrganicCats)
            allStatuses.add(organicCat.status());
        for(OrganicDog organicDog: allOrganicDogs)
            allStatuses.add(organicDog.status());
        return allStatuses;
    }

    @GetMapping("shelter/showAll")
    public Iterable<String> showAll(){
        List<String> pets = new ArrayList<>();
        Iterable<RoboticCat> allRoboticCats = roboticCatRepo.findAll();
        Iterable<RoboticDog> allRoboticDogs = roboticDogRepo.findAll();
        Iterable<OrganicCat> allOrganicCats = organicCatRepo.findAll();
        Iterable<OrganicDog> allOrganicDogs = organicDogRepo.findAll();
        for(RoboticCat roboticCat: allRoboticCats)
            pets.add(roboticCat.showPet());
        for(RoboticDog roboticDog: allRoboticDogs)
            pets.add(roboticDog.showPet());
        for(OrganicCat organicCat: allOrganicCats)
            pets.add(organicCat.showPet());
        for(OrganicDog organicDog: allOrganicDogs)
            pets.add(organicDog.showPet());
        return pets;
    }

    @GetMapping("shelter/showAllPets")
    public AllPetsResponseObject showAllPets(){
        AllPetsResponseObject pets = new AllPetsResponseObject();
        pets.setRoboticCats(roboticCatRepo.findAll());
        pets.setRoboticDogs(roboticDogRepo.findAll());
        pets.setOrganicCats(organicCatRepo.findAll());
        pets.setOrganicDogs(organicDogRepo.findAll());

        return pets;
    }

    @PutMapping("shelter/feedAll")
    public void feedAll(){
        Iterable<OrganicCat> organicCats = organicCatRepo.findAll();
        Iterable<OrganicDog> organicDogs = organicDogRepo.findAll();
        for (OrganicCat organicCat: organicCats){
            organicCat.feed();
            organicCat.tick();
            organicCatRepo.save(organicCat);
        }

        for (OrganicDog organicDog: organicDogs){
            organicDog.feed();
            organicDog.tick();
            organicDogRepo.save(organicDog);
        }

    }

    @PutMapping("shelter/waterAll")
    public void waterAll(){
        Iterable<OrganicCat> organicCats = organicCatRepo.findAll();
        Iterable<OrganicDog> organicDogs = organicDogRepo.findAll();
        for (OrganicCat organicCat: organicCats){
            organicCat.drink();
            organicCat.tick();
            organicCatRepo.save(organicCat);
        }

        for (OrganicDog organicDog: organicDogs){
            organicDog.drink();
            organicDog.tick();
            organicDogRepo.save(organicDog);
        }

    }

    @PutMapping("shelter/playWithAll")
    public void playWithAll(){
        Iterable<OrganicCat> organicCats = organicCatRepo.findAll();
        Iterable<OrganicDog> organicDogs = organicDogRepo.findAll();
        for (OrganicCat organicCat: organicCats){
            organicCat.play();
            organicCat.tick();
            organicCatRepo.save(organicCat);
        }

        for (OrganicDog organicDog: organicDogs){
            organicDog.play();
            organicDog.tick();
            organicDogRepo.save(organicDog);
        }

    }

    @PutMapping("shelter/cleanAll")
    public void cleanAll(){
        Iterable<OrganicCat> organicCats = organicCatRepo.findAll();
        Iterable<OrganicDog> organicDogs = organicDogRepo.findAll();
        for (OrganicCat organicCat: organicCats){
            organicCat.cleanArea();
            organicCat.tick();
            organicCatRepo.save(organicCat);
        }
        for (OrganicDog organicDog: organicDogs){
            organicDog.cleanCage();
            organicDog.tick();
            organicDogRepo.save(organicDog);
        }
    }

    @PutMapping("shelter/oilAll")
    public void oilAll(){
        Iterable<RoboticCat> roboticCats = roboticCatRepo.findAll();
        Iterable<RoboticDog> roboticDogs = roboticDogRepo.findAll();
        for (RoboticCat roboticCat: roboticCats){
            roboticCat.oil();
            roboticCat.tick();
            roboticCatRepo.save(roboticCat);
        }
        for (RoboticDog roboticDog: roboticDogs){
            roboticDog.oil();
            roboticDog.tick();
            roboticDogRepo.save(roboticDog);
        }
    }

    @PutMapping("shelter/maintainAll")
    public void maintainAll(){
        Iterable<RoboticCat> roboticCats = roboticCatRepo.findAll();
        Iterable<RoboticDog> roboticDogs = roboticDogRepo.findAll();
        for (RoboticCat roboticCat: roboticCats){
            roboticCat.maintain();
            roboticCat.tick();
            roboticCatRepo.save(roboticCat);
        }
        for (RoboticDog roboticDog: roboticDogs){
            roboticDog.maintenance();
            roboticDog.tick();
            roboticDogRepo.save(roboticDog);
        }
    }

    @PutMapping("shelter/walkAll")
    public void walkAll(){
        Iterable<OrganicDog> organicDogs = organicDogRepo.findAll();
        Iterable<RoboticDog> roboticDogs = roboticDogRepo.findAll();
        for (OrganicDog organicDog: organicDogs){
            organicDog.walk();
            organicDog.tick();
            organicDogRepo.save(organicDog);
        }
        for (RoboticDog roboticDog: roboticDogs){
            roboticDog.walkPet();
            roboticDog.tick();
            roboticDogRepo.save(roboticDog);
        }
    }

    @PutMapping("shelter/tickAll")
    public void tickAll(){
        Iterable<RoboticCat> allRoboticCats = roboticCatRepo.findAll();
        Iterable<RoboticDog> allRoboticDogs = roboticDogRepo.findAll();
        Iterable<OrganicCat> allOrganicCats = organicCatRepo.findAll();
        Iterable<OrganicDog> allOrganicDogs = organicDogRepo.findAll();
        for (RoboticCat roboticCat: allRoboticCats){
            roboticCat.tick();
            roboticCatRepo.save(roboticCat);
        }
        for (RoboticDog roboticDog: allRoboticDogs){
            roboticDog.tick();
            roboticDogRepo.save(roboticDog);
        }
        for (OrganicCat organicCat: allOrganicCats){
            organicCat.tick();
            organicCatRepo.save(organicCat);
        }
        for (OrganicDog organicDog: allOrganicDogs){
            organicDog.tick();
            organicDogRepo.save(organicDog);
        }
    }
}