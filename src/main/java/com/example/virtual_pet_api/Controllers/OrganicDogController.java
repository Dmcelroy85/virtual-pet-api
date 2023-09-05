package com.example.virtual_pet_api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.virtual_pet_api.Models.OrganicDog;
import com.example.virtual_pet_api.Repositories.OrganicDogRepo;

@RestController
@RequestMapping("/organicdog")
public class OrganicDogController {
    @Autowired
    private OrganicDogRepo organicDogRepo;

    @GetMapping("/name/{name}")
    public List<OrganicDog> getOrganicDogByName(@PathVariable String name) {
        return organicDogRepo.findByName(name);
    }

    @GetMapping("/description/{description}")
    public List<OrganicDog> getOrganicDogByDescription(@PathVariable String description) {
        return organicDogRepo.findByDescription(description);
    }

    @GetMapping("/{id}")
    public OrganicDog getOrganicDogById(@PathVariable Long id) {
        return organicDogRepo.findById(id).orElse(null);
    }

    @GetMapping("/isWalked/{isWalked}")
    public List<OrganicDog> getOrganicDogByIsWalked(@PathVariable boolean isWalked) {
        return organicDogRepo.findByIsWalked(isWalked);
    }

    @GetMapping("/isFed/{isFed}")
    public List<OrganicDog> getOrganicDogByIsFed(@PathVariable boolean isFed) {
        return organicDogRepo.findByIsFed(isFed);
    }

    @GetMapping("/isWatered/{isWatered}")
    public List<OrganicDog> getOrganicDogByIsWatered(@PathVariable boolean isWatered) {
        return organicDogRepo.findByIsWatered(isWatered);
    }

    @GetMapping("/isCleanCage/{isCleanCage}")
    public List<OrganicDog> getOrganicDogByIsCleanCage(@PathVariable boolean isCleanCage) {
        return organicDogRepo.findByIsCleanCage(isCleanCage);
    }

    @GetMapping("/hunger/{hunger}")
    public List<OrganicDog> getOrganicDogByHunger(@PathVariable int hunger) {
        return organicDogRepo.findByHunger(hunger);
    }
}
