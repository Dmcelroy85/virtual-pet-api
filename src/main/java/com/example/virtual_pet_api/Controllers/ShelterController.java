package com.example.virtual_pet_api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.virtual_pet_api.Models.Shelter;
import com.example.virtual_pet_api.Repositories.ShelterRepo;

@RestController
@RequestMapping("/shelter")
public class ShelterController {
    
    @Autowired
    private ShelterRepo shelterRepo;


    @GetMapping("/{id}")
    public Shelter getShelterById(@PathVariable long id) {
        return shelterRepo.findById(id).orElse(null);
    }

    @GetMapping("/name/{name}")
    public List<Shelter> getShelterByName(@PathVariable String name) {
        return shelterRepo.findByName(name);
    }


}
