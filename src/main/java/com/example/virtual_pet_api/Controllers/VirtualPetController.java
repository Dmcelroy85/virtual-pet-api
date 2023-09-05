package com.example.virtual_pet_api.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.virtual_pet_api.Models.VirtualPet;
import com.example.virtual_pet_api.Repositories.VirtualPetRepo;

@RestController
@RequestMapping("/virtualpet")
public class VirtualPetController {
    
    @Autowired
    private VirtualPetRepo virtualPetRepo;

    @GetMapping("/{id}")
    public VirtualPet getVirtualPetById(@PathVariable long id) {
        return virtualPetRepo.findById(id).orElse(null);
    }
}
