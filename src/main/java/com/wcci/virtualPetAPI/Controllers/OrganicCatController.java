package com.wcci.virtualPetAPI.Controllers;

import com.wcci.virtualPetAPI.Repositories.OrganicCatRepository;
import com.wcci.virtualPetAPI.Models.OrganicCat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrganicCatController {

    private OrganicCatRepository organicCatRepo;

    public OrganicCatController(OrganicCatRepository organicCatRepo) {
        this.organicCatRepo = organicCatRepo;
    }

    @GetMapping("/organicCats")
    public Iterable<OrganicCat> getAllOrganicCats() {
        return organicCatRepo.findAll();
    }

    @GetMapping("/organicCats/{id}")
    public OrganicCat getSingleCat(@PathVariable long id) {
        return organicCatRepo.findById(id).get();
    }

    @PutMapping("/organicCats/{id}/feedCat")
    public OrganicCat feed(@PathVariable long id) {
        OrganicCat cat = organicCatRepo.findById(id).get();
        cat.feed();
        cat.tick();
        organicCatRepo.save(cat);
        return organicCatRepo.findById(id).get();
        }

    @PutMapping("/organicCats/{id}/giveCatDrink")
    public OrganicCat drink(@PathVariable long id) {
        OrganicCat cat = organicCatRepo.findById(id).get();
        cat.drink();
        cat.tick();
        organicCatRepo.save(cat);
        return organicCatRepo.findById(id).get();
    }
    @PutMapping("/organicCats/{id}/play")
    public OrganicCat play(@PathVariable long id) {
        OrganicCat cat = organicCatRepo.findById(id).get();
        cat.play();
        cat.tick();
        organicCatRepo.save(cat);
        return organicCatRepo.findById(id).get();
    }
    @PutMapping("/organicCats/{id}/tick")
    public OrganicCat tick(@PathVariable long id) {
        OrganicCat cat = organicCatRepo.findById(id).get();
        cat.tick();
        organicCatRepo.save(cat);
        return organicCatRepo.findById(id).get();
    }

    @PutMapping("/organicCats/{id}/cleanLitter")
    public OrganicCat cleanArea(@PathVariable long id) {
        OrganicCat cat = organicCatRepo.findById(id).get();
        cat.cleanArea();
        cat.tick();
        organicCatRepo.save(cat);
        return organicCatRepo.findById(id).get();
    }

    @GetMapping("/organicCats/{id}/showStatus")
    public String showStatus(@PathVariable long id) {
        OrganicCat cat = organicCatRepo.findById(id).get();
        return cat.showPet();
    }

    }