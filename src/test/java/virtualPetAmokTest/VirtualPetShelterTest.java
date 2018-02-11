package virtualPetAmokTest;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import virtualPetAmok.OrganicCat;
import virtualPetAmok.OrganicDog;
import virtualPetAmok.RobotCat;
import virtualPetAmok.RobotDog;
import virtualPetAmok.VirtualPetShelter;

public class VirtualPetShelterTest {

	OrganicCat phil = new OrganicCat("Phil", "", 1, 1, 1, 1, 1, 1);
	OrganicDog bill = new OrganicDog("Bill", "", 1, 1, 1, 1, 1, 1);
	RobotCat dill = new RobotCat("Dill", "", 1, 1, 1);
	RobotDog pill = new RobotDog("Pill", "", 1, 1, 1);

	VirtualPetShelter testShelter = new VirtualPetShelter();

	@Test
	public void shouldContain() {
		testShelter.addCreature(phil);
		boolean check = testShelter.contains("Phil");
		assertEquals(check, true);
	}

	@Test
	public void shouldAdopt() {
		testShelter.addCreature(phil);
		testShelter.adoptCreature(phil);
		boolean check = testShelter.contains("Phil");
		assertEquals(check, false);
	}

	@Test
	public void shouldPlayWithOneAnimalNotOther() {
		testShelter.addCreature(phil);
		testShelter.addCreature(pill);
		testShelter.play("Pill");
		int playMoodCheckNoPlay = phil.getMood();
		int playMoodCheckPlay = pill.getMood();
		assertEquals(playMoodCheckNoPlay, 1);
		assertEquals(playMoodCheckPlay, 2);
	}

	@Test
	public void shouldFeedOrganicCatsNotDogs() {
		testShelter.addCreature(phil);
		testShelter.addCreature(bill);
		testShelter.feedOrganicCats();
		int CatHungerCheck = phil.getHunger();
		int DogHungerCheck = bill.getHunger();
		int CatPoopCheck = phil.getPoop();
		int DogPoopCheck = bill.getPoop();
		assertEquals(CatHungerCheck, 0);
		assertEquals(DogHungerCheck, 1);
		assertEquals(CatPoopCheck, 2);
		assertEquals(DogPoopCheck, 1);
	}

	@Test
	public void shouldFeedOrganicDogsNotCats() {
		testShelter.addCreature(phil);
		testShelter.addCreature(bill);
		testShelter.feedOrganicDogs();
		int CatHungerCheck = phil.getHunger();
		int DogHungerCheck = bill.getHunger();
		int CatPoopCheck = phil.getPoop();
		int DogPoopCheck = bill.getPoop();
		assertEquals(CatHungerCheck, 1);
		assertEquals(DogHungerCheck, 0);
		assertEquals(CatPoopCheck, 1);
		assertEquals(DogPoopCheck, 2);
	}

	@Test
	public void shouldOilRobotCatsNotDogs() {
		testShelter.addCreature(dill);
		testShelter.addCreature(pill);
		testShelter.oilRobotCats();
		int catLubeCheck = dill.getLube();
		int dogLubeCheck = pill.getLube();
		int catRustCheck = dill.getRust();
		int dogRustCheck = pill.getRust();
		assertEquals(catLubeCheck, 2);
		assertEquals(dogLubeCheck, 1);
		assertEquals(catRustCheck, 0);
		assertEquals(dogRustCheck, 1);
	}

	@Test
	public void shouldOilRobotDogsNotCats() {
		testShelter.addCreature(dill);
		testShelter.addCreature(pill);
		testShelter.oilRobotDogs();
		int catLubeCheck = dill.getLube();
		int dogLubeCheck = pill.getLube();
		int catRustCheck = dill.getRust();
		int dogRustCheck = pill.getRust();
		assertEquals(catLubeCheck, 1);
		assertEquals(dogLubeCheck, 2);
		assertEquals(catRustCheck, 1);
		assertEquals(dogRustCheck, 0);
	}

	@Test
	public void shouldTickAllAndAddWaste() {
		testShelter.addCreature(phil);
		testShelter.addCreature(bill);
		testShelter.addCreature(dill);
		testShelter.addCreature(pill);
		testShelter.tickAllCreaturesPlusWaste();
		int philMoodCheck = phil.getMood();
		int philHungerCheck = phil.getHunger();
		int philPeeCheck = phil.getPee();
		int philPoopCheck = phil.getPoop();
		int philThirstCheck = phil.getThirst();
		int billMoodCheck = bill.getMood();
		int billHungerCheck = bill.getHunger();
		int billPeeCheck = bill.getPee();
		int billPoopCheck = bill.getPoop();
		int billThirstCheck = bill.getThirst();
		int dillMoodCheck = dill.getMood();
		int dillLubeCheck = dill.getLube();
		int dillRustCheck = dill.getRust();
		int pillMoodCheck = pill.getMood();
		int pillLubeCheck = pill.getLube();
		int pillRustCheck = pill.getRust();
		int catLitterCheck = testShelter.getCatLitter();
		int dogLitterCheck = testShelter.getDogLitter();
		assertThat(philMoodCheck, is(allOf(greaterThan(-3), lessThan(5))));
		assertEquals(philHungerCheck, 2);
		assertEquals(philPeeCheck, 2);
		assertEquals(philPoopCheck, 2);
		assertEquals(philThirstCheck, 2);
		assertThat(billMoodCheck, is(allOf(greaterThan(-3), lessThan(5))));
		assertEquals(billHungerCheck, 2);
		assertEquals(billPeeCheck, 2);
		assertEquals(billPoopCheck, 2);
		assertEquals(billThirstCheck, 2);
		assertThat(dillMoodCheck, is(allOf(greaterThan(-3), lessThan(5))));
		assertEquals(dillLubeCheck, 0);
		assertEquals(dillRustCheck, 2);
		assertThat(pillMoodCheck, is(allOf(greaterThan(-3), lessThan(5))));
		assertEquals(pillLubeCheck, 0);
		assertEquals(pillRustCheck, 2);
		assertEquals(catLitterCheck, 2);
		assertEquals(dogLitterCheck, 2);
	}
}