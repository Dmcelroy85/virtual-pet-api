package com.example.virtual_pet_api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.virtual_pet_api.Controllers.OrganicCatController;
import com.example.virtual_pet_api.Controllers.OrganicDogController;
import com.example.virtual_pet_api.Controllers.RoboticCatController;
import com.example.virtual_pet_api.Controllers.RoboticDogController;
import com.example.virtual_pet_api.Controllers.ShelterController;
import com.example.virtual_pet_api.Controllers.VolunteerController;
import com.example.virtual_pet_api.Models.OrganicCat;
import com.example.virtual_pet_api.Models.OrganicDog;
import com.example.virtual_pet_api.Models.RoboticCat;
import com.example.virtual_pet_api.Models.RoboticDog;
import com.example.virtual_pet_api.Models.Shelter;
import com.example.virtual_pet_api.Models.Volunteer;

@SpringBootTest
class VirtualPetApiApplicationTests {

	@Autowired
	private OrganicCatController organicCatController;

	@Autowired
	private OrganicDogController organicDogController;

	@Autowired
	private RoboticCatController roboticCatController;

	@Autowired
	private RoboticDogController roboticDogController;

	@Autowired
	private ShelterController shelterController;

	@Autowired
	private VolunteerController volunteerController;

	@Test
	public void getShelterById() {
		Shelter result = shelterController.getShelterById(1L);
		assertEquals("Humane Society", result.getName(), "This is the Humane Society");
	}

	@Test
	public void getVolunteerById() {
		Volunteer result = volunteerController.getVolunteerById(1L);
		assertEquals("Abigail", result.getName(), "Should be Abigail");
	}

	@Test
	public void getRoboticDogById() {
		RoboticDog result = roboticDogController.getRoboticDogById(1L);
		assertEquals("Rosie", result.getName(), "Should be Rosie");
	}

	@Test
	public void getRoboticDog2ById() {
		RoboticDog result = roboticDogController.getRoboticDogById(2L);
		assertEquals("Princess", result.getName(), "Should be Princess");
	}

	@Test
	public void getRoboticCatById() {
		RoboticCat result = roboticCatController.getRoboticCatById(1L);
		assertEquals("Timmy", result.getName(), "Should be Timmy");
	}

	@Test
	public void getRoboticCat2ById() {
		RoboticCat result = roboticCatController.getRoboticCatById(2L);
		assertEquals("Marcel", result.getName(), "Should be Marcel");
	}

	@Test
	public void getOrganicDogById() {
		OrganicDog result = organicDogController.getOrganicDogById(1L);
		assertEquals("Spot", result.getName(), "Should be Spot");
	}

	@Test
	public void getOrganicCatById() {
		OrganicCat result = organicCatController.getOrganicCatById(1L);
		assertEquals("MeowMix", result.getName(), "Should be MeowMix");
	}

}
