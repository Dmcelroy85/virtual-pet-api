package com.example.virtual_pet_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.virtual_pet_api.Models.OrganicCat;
import com.example.virtual_pet_api.Models.OrganicDog;
import com.example.virtual_pet_api.Models.RoboticCat;
import com.example.virtual_pet_api.Models.RoboticDog;
import com.example.virtual_pet_api.Models.Shelter;
import com.example.virtual_pet_api.Models.Volunteer;
import com.example.virtual_pet_api.Repositories.OrganicCatRepo;
import com.example.virtual_pet_api.Repositories.OrganicDogRepo;
import com.example.virtual_pet_api.Repositories.RoboticCatRepo;
import com.example.virtual_pet_api.Repositories.RoboticDogRepo;
import com.example.virtual_pet_api.Repositories.ShelterRepo;
import com.example.virtual_pet_api.Repositories.VolunteerRepo;

@Component
public class Populator implements CommandLineRunner{

    @Autowired
    private ShelterRepo shelterRepo;

    @Autowired
    private VolunteerRepo volunteerRepo;

    @Autowired
    private RoboticDogRepo roboticDogRepo;

    @Autowired
    private RoboticCatRepo roboticCatRepo;

    @Autowired
    private OrganicDogRepo organicDogRepo;

    @Autowired
    private OrganicCatRepo organicCatRepo;

    @Override
    public void run(String... args) throws Exception {

        Shelter shelter1 = new Shelter("Pinky's Pets");
        shelterRepo.save(shelter1);

        Shelter shelter2 = new Shelter("Brain's Buddys");
        shelterRepo.save(shelter2);

        Volunteer volunteer1 = new Volunteer("Ferledon");
        volunteer1.getShelters().add(shelter1);
        volunteerRepo.save(volunteer1);

        Volunteer volunteer2 = new Volunteer("Scornakira");
        volunteer2.getShelters().add(shelter1);
        volunteer2.getShelters().add(shelter2);
        volunteerRepo.save(volunteer2);

        RoboticDog roboticDog1 = new RoboticDog(50, "Jamie", "Grey Dog", false);
        roboticDog1.setShelter(shelter1);
        roboticDogRepo.save(roboticDog1);

        RoboticDog roboticDog2 = new RoboticDog(72, "Jill", "Black Dog", true);
        roboticDog2.setShelter(shelter1);
        roboticDogRepo.save(roboticDog2);

        RoboticCat roboticCat1 = new RoboticCat(25, "Jack", "Tan Cat", true);
        roboticCat1.setShelter(shelter1);
        roboticCatRepo.save(roboticCat1);

        RoboticCat roboticCat2 = new RoboticCat(30, "Maribell", "Spotted Cat", true);
        roboticCat2.setShelter(shelter2);
        roboticCatRepo.save(roboticCat2);

        OrganicDog organicDog1 = new OrganicDog(86, "Fido", "Spotted Dog", false, true, true, true, 76);
        organicDog1.setShelter(shelter1);
        organicDogRepo.save(organicDog1);

        OrganicCat organicCat1 = new OrganicCat(90, "Jinx", "Black Cat", true, true, false, 37);
        organicCat1.setShelter(shelter2);
        organicCatRepo.save(organicCat1);

    }
}
