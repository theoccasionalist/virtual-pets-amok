package virtualPetAmokTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import virtualPetAmok.OrganicCat;
import virtualPetAmok.OrganicDog;
import virtualPetAmok.RobotCat;
import virtualPetAmok.RobotDog;
import virtualPetAmok.VirtualPetShelter;

public class VirtualPetShelterTest {

	OrganicCat phil = new OrganicCat("Phil", "", 1, 1, 1, 1, 1, 1);
	RobotCat bill = new RobotCat("Bill", "", 1, 1, 1);
	OrganicDog dill = new OrganicDog("Dill", "", 1, 1, 1, 1, 1, 1);
	RobotDog pill = new RobotDog("Pill", "", 1, 1, 1);

	VirtualPetShelter testShelter = new VirtualPetShelter();
	private Object OrganicCat;

	public void addCreatures() {
		testShelter.addCreature(phil);
		testShelter.adoptCreature(bill);
		testShelter.addCreature(dill);
		testShelter.adoptCreature(pill);
	}

	@Test
	public void shouldAdopt() {
		testShelter.adoptCreature(phil);
		boolean check = testShelter.contains("Phil");
		assertEquals(false, check);
	}

	@Test
	public void shouldFeedOrganicCatsNotDogs() {
		testShelter.feedOrganicCats();
		int CatHungerCheck = phil.getHunger();
		int DogHungerCheck = dill.getHunger();
		int CatPoopCheck = phil.getPoop();
		int DogPoopCheck = dill.getPoop();
		assertEquals(CatHungerCheck, 1);
		assertEquals(DogHungerCheck, 1);
		assertEquals(CatPoopCheck, 1);
		assertEquals(DogPoopCheck, 1);
	}
}