package com.example.virtual_pet_api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.virtual_pet_api.Models.RoboticCat;
import com.example.virtual_pet_api.Repositories.RoboticCatRepo;

@RestController
@RequestMapping("/roboticcat")
public class RoboticCatController {
    @Autowired
    private RoboticCatRepo roboticCatRepo;

    @GetMapping("/name/{name}")
    public List<RoboticCat> getRoboticCatByName(@PathVariable String name) {
        return roboticCatRepo.findByName(name);
    }

    @GetMapping("/description/{description}")
    public List<RoboticCat> getRoboticCatByDescription(@PathVariable String description) {
        return roboticCatRepo.findByDescription(description);
    }

    @GetMapping("/{id}")
    public RoboticCat getRoboticCatById(@PathVariable Long id) {
        return roboticCatRepo.findById(id).orElse(null);
    }

    @GetMapping("/isOiled/{isOiled}")
    public List<RoboticCat> getOilStatus(@PathVariable boolean isOiled) {
        return roboticCatRepo.findByIsOiled(isOiled);
    }
}
