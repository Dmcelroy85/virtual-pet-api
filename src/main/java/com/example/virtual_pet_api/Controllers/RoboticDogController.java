package com.example.virtual_pet_api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.virtual_pet_api.Models.RoboticDog;
import com.example.virtual_pet_api.Repositories.RoboticDogRepo;

@RestController
@RequestMapping("/roboticdog")
public class RoboticDogController {
    
    @Autowired
    private RoboticDogRepo roboticDogRepo;

    @GetMapping("/name/{name}")
    public List<RoboticDog> getRoboticDogByName(@PathVariable String name) {
        return roboticDogRepo.findByName(name);
    }

    @GetMapping("/description/{description}")
    public List<RoboticDog> getRoboticDogByDescription(@PathVariable String description) {
        return roboticDogRepo.findByDescription(description);
    }

    @GetMapping("/{id}")
    public RoboticDog getRoboticDogById(@PathVariable Long id) {
        return roboticDogRepo.findById(id).orElse(null);
    }

    @GetMapping("/isOiled/{isOiled}")
    public List<RoboticDog> getOilStatus(@PathVariable boolean isOiled) {
        return roboticDogRepo.findByIsOiled(isOiled);
    }
}
