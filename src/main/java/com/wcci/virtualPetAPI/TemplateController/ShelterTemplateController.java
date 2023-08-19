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

    public ShelterTemplateController(@Autowired ShelterRepository shelterRepository, NamedPetRepository namedPetRepository, OrganicDogRepository organicDogRepository, OrganicCatRepository organicCatRepository, RoboticDogRepository roboticDogRepository, RoboticCatRepository roboticCatRepository) {
        this.shelterRepository = shelterRepository;
        this.organicDogRepository = organicDogRepository;
        this.organicCatRepository = organicCatRepository;
        this.roboticDogRepository = roboticDogRepository;
        this.roboticCatRepository = roboticCatRepository;
        this.namedPetRepository = namedPetRepository;
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
        model.addAttribute("shelter", shelterRepository.findById(shelter_id).get());
        model.addAttribute("pets", shelterRepository.findById(shelter_id).get().getAllPets());
        return "specificShelter.js";
    }

    @GetMapping("/shelters/{shelter_id}")
    public String getShelter(Model model, @PathVariable long shelter_id) {
        model.addAttribute("shelter", shelterRepository.findById(shelter_id).get());
        model.addAttribute("pets", shelterRepository.findById(shelter_id).get().getAllPets());
        return "specificShelter.html";
    }

    @PostMapping("/shelters")
    public String postShelters(final Shelter shelter) {
        shelterRepository.save(shelter);
        return "redirect:/shelters";
    }

    @PostMapping("/shelters/{shelter_id}/organicDog")
    public String addOrganicDog(@RequestParam String name, @PathVariable Long shelter_id) {
        OrganicDog organicDog = new OrganicDog(name);
        organicDog.setShelter(shelterRepository.findById(shelter_id).get());
        organicDogRepository.save(organicDog);
        return "redirect:/shelters/" + shelter_id;
    }

    @PostMapping("/shelters/{shelter_id}/organicCat")
    public String addOrganicCat(@RequestParam String name, @PathVariable Long shelter_id) {
        OrganicCat organicCat = new OrganicCat(name);
        organicCat.setShelter(shelterRepository.findById(shelter_id).get());
        organicCatRepository.save(organicCat);
        return "redirect:/shelters/" + shelter_id;
    }

    @PostMapping("/shelters/{shelter_id}/roboticDog")
    public String addRoboticDog(@RequestParam String name, @PathVariable Long shelter_id) {
        RoboticDog roboticDog = new RoboticDog(name);
        roboticDog.setShelter(shelterRepository.findById(shelter_id).get());
        roboticDogRepository.save(roboticDog);
        return "redirect:/shelters/" + shelter_id;
    }

    @PostMapping("/shelters/{shelter_id}/roboticCat")
    public String addRoboticCat(@RequestParam String name, @PathVariable Long shelter_id) {
        RoboticCat roboticCat = new RoboticCat(name);
        roboticCat.setShelter(shelterRepository.findById(shelter_id).get());
        roboticCatRepository.save(roboticCat);
        return "redirect:/shelters/" + shelter_id;
    }

    @PutMapping("/shelters/{shelter_id}")
    public void tickAll(@PathVariable Long shelter_id) {
        shelterRepository.findById(shelter_id).get().tickAll();
        shelterRepository.save(shelterRepository.findById(shelter_id).get());
    }

}