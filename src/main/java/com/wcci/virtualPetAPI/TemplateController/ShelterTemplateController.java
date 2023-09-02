package com.wcci.virtualPetAPI.TemplateController;

import com.wcci.virtualPetAPI.Models.*;
import com.wcci.virtualPetAPI.Repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ShelterTemplateController {
    private ShelterRepository shelterRepository;
    private OrganicDogRepository organicDogRepository;
    private OrganicCatRepository organicCatRepository;
    private RoboticDogRepository roboticDogRepository;
    private RoboticCatRepository roboticCatRepository;
    
    public ShelterTemplateController(@Autowired ShelterRepository shelterRepository, OrganicDogRepository organicDogRepository, OrganicCatRepository organicCatRepository, RoboticDogRepository roboticDogRepository, RoboticCatRepository roboticCatRepository) {
        this.shelterRepository = shelterRepository;
        this.organicDogRepository = organicDogRepository;
        this.organicCatRepository = organicCatRepository;
        this.roboticDogRepository = roboticDogRepository;
        this.roboticCatRepository = roboticCatRepository;
    }

    @GetMapping("/index")
    public String getIndex() {
        return "index.html";
    }

    @GetMapping("/shelters")
    public String getShelters(Model model) {
        model.addAttribute("shelters", shelterRepository.findAll());
        return "shelters.html";
    }

    @GetMapping("/shelters/{shelter_id}/specificShelter.js")
    public String getJavaScript(Model model, @PathVariable long shelter_id) {
        Shelter shelter = shelterRepository.findById(shelter_id).orElse(null);
        if (shelter != null) {
            model.addAttribute("shelter", shelter);
            model.addAttribute("pets", shelter.getAllPets());
        }
        return "specificShelter.js";
    }

    @GetMapping("/shelters/{shelter_id}")
    public String getShelter(Model model, @PathVariable long shelter_id) {
        Shelter shelter = shelterRepository.findById(shelter_id).orElse(null);
        if (shelter != null) {
            model.addAttribute("shelter", shelter);
            model.addAttribute("pets", shelter.getAllPets());
        }
        return "specificShelter.html";
    }

    @PostMapping("/shelters")
    public String postShelters(final Shelter shelter) {
        shelterRepository.save(shelter);
        return "shelters";
    }

    @PostMapping("/shelters/{shelter_id}/organicDog")
    public String addOrganicDog(@RequestParam String name, @PathVariable Long shelter_id) {
        Shelter shelter = shelterRepository.findById(shelter_id).orElse(null);
        if (shelter != null) {
            OrganicDog organicDog = new OrganicDog(name);
            organicDog.setShelter(shelter);
            organicDogRepository.save(organicDog);
        }
        return "shelters/" + shelter_id;
    }

    @PostMapping("/shelters/{shelter_id}/organicCat")
    public String addOrganicCat(@RequestParam String name, @PathVariable Long shelter_id) {
        Shelter shelter = shelterRepository.findById(shelter_id).orElse(null);
        if (shelter != null) {
            OrganicCat organicCat = new OrganicCat(name, 0, 0, 0, 0, shelter);
            organicCat.setShelter(shelter);
            organicCatRepository.save(organicCat);
        }
        return "shelters/" + shelter_id;
    }

    @PostMapping("/shelters/{shelter_id}/roboticDog")
    public String addRoboticDog(@RequestParam String name, @PathVariable Long shelter_id) {
        Shelter shelter = shelterRepository.findById(shelter_id).orElse(null);
        if (shelter != null) {
            RoboticDog roboticDog = new RoboticDog(name);
            roboticDog.setShelter(shelter);
            roboticDogRepository.save(roboticDog);
        }
        return "shelters/" + shelter_id;
    }

    @PostMapping("/shelters/{shelter_id}/roboticCat")
    public String addRoboticCat(@RequestParam String name, @PathVariable Long shelter_id) {
        Shelter shelter = shelterRepository.findById(shelter_id).orElse(null);
        if (shelter != null) {
            RoboticCat roboticCat = new RoboticCat(name);
            roboticCat.setShelter(shelter);
            roboticCatRepository.save(roboticCat);
        }
        return "shelters/" + shelter_id;
    }

}