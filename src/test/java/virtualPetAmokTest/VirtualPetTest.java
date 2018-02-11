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

public class VirtualPetTest {

	OrganicCat phil = new OrganicCat("Phil", "", 1, 1, 1, 1, 1, 1);
	OrganicDog bill = new OrganicDog("Bill", "", 1, 1, 1, 1, 1, 1);
	RobotCat dill = new RobotCat("Dill", "", 1, 1, 1);
	RobotDog pill = new RobotDog("Pill", "", 1, 1, 1);

	@Test
	public void shouldReturnOrganicHealth() {
		int organicCatHealth = phil.getHealth();
		int organicDogHealth = bill.getHealth();
		assertEquals(organicCatHealth, 2);
		assertEquals(organicDogHealth, 2);
	}

	@Test
	public void shouldReturnRobotHealth() {
		int robotCatHealth = dill.getHealth();
		int robotDogHealth = pill.getHealth();
		assertEquals(robotCatHealth, 1);
		assertEquals(robotDogHealth, 1);
	}

	@Test
	public void organicCatShouldDrink() {
		phil.drink();
		int drinkCheck = phil.getThirst();
		int peeCheck = phil.getPee();
		assertEquals(drinkCheck, 0);
		assertEquals(peeCheck, 2);
	}

	@Test
	public void organicDogShouldDrink() {
		bill.drink();
		int drinkCheck = bill.getThirst();
		int peeCheck = bill.getPee();
		assertEquals(drinkCheck, 0);
		assertEquals(peeCheck, 2);
	}

	@Test
	public void organicCatShouldEat() {
		phil.eat();
		int hungerCheck = phil.getHunger();
		int poopCheck = phil.getPoop();
		assertEquals(hungerCheck, 0);
		assertEquals(poopCheck, 2);
	}

	@Test
	public void organicDogShouldEat() {
		bill.eat();
		int hungerCheck = bill.getHunger();
		int poopCheck = bill.getPoop();
		assertEquals(hungerCheck, 0);
		assertEquals(poopCheck, 2);
	}

	@Test
	public void organicCatShouldPee() {
		phil.pee();
		int peeCheck = phil.getPee();
		int thirstCheck = phil.getThirst();
		assertEquals(peeCheck, 0);
		assertEquals(thirstCheck, 2);
	}

	@Test
	public void organicDogShouldPee() {
		bill.pee();
		int peeCheck = bill.getPee();
		int thirstCheck = bill.getThirst();
		assertEquals(peeCheck, 0);
		assertEquals(thirstCheck, 2);
	}

	@Test
	public void organicCatShouldPoop() {
		phil.poop();
		int hungerCheck = phil.getHunger();
		int poopCheck = phil.getPoop();
		assertEquals(hungerCheck, 2);
		assertEquals(poopCheck, 0);
	}

	@Test
	public void organicCatShouldPlay() {
		phil.play();
		int moodCheck = phil.getMood();
		assertEquals(moodCheck, 2);
	}

	@Test
	public void organicDogShouldPlay() {
		bill.play();
		int moodCheck = bill.getMood();
		assertEquals(moodCheck, 2);
	}

	@Test
	public void shouldTickOrganicCat() {
		phil.tick();
		int moodCheck = phil.getMood();
		int hungerCheck = phil.getHunger();
		int peeCheck = phil.getPee();
		int poopCheck = phil.getPoop();
		int thirstCheck = phil.getThirst();
		assertThat(moodCheck, is(allOf(greaterThan(-3), lessThan(5))));
		assertEquals(hungerCheck, 2);
		assertEquals(peeCheck, 2);
		assertEquals(poopCheck, 2);
		assertEquals(thirstCheck, 2);
	}

	@Test
	public void shouldTickOrganicDog() {
		bill.tick();
		int moodCheck = bill.getMood();
		int hungerCheck = bill.getHunger();
		int peeCheck = bill.getPee();
		int poopCheck = bill.getPoop();
		int thirstCheck = bill.getThirst();
		assertThat(moodCheck, is(allOf(greaterThan(-3), lessThan(5))));
		assertEquals(hungerCheck, 2);
		assertEquals(peeCheck, 2);
		assertEquals(poopCheck, 2);
		assertEquals(thirstCheck, 2);
	}

	@Test
	public void shouldWalkOrganicDog() {
		bill.walk();
		int fitnessCheck = bill.getFitness();
		int hungerCheck = bill.getHunger();
		int moodCheck = bill.getMood();
		int poopCheck = bill.getPoop();
		int peeCheck = bill.getPee();
		int thirstCheck = bill.getThirst();
		assertEquals(fitnessCheck, 2);
		assertEquals(hungerCheck, 2);
		assertEquals(moodCheck, 2);
		assertEquals(poopCheck, 0);
		assertEquals(peeCheck, 0);
		assertEquals(thirstCheck, 2);
	}

	@Test
	public void shouldOilRobotCat() {
		dill.oil();
		int lubeCheck = dill.getLube();
		int rustCheck = dill.getRust();
		assertEquals(lubeCheck, 2);
		assertEquals(rustCheck, 0);
	}

	@Test
	public void shouldOilRobotDog() {
		pill.oil();
		int lubeCheck = pill.getLube();
		int rustCheck = pill.getRust();
		assertEquals(lubeCheck, 2);
		assertEquals(rustCheck, 0);
	}

	@Test
	public void robotCatShouldPlay() {
		dill.play();
		int moodCheck = dill.getMood();
		assertEquals(moodCheck, 2);
	}

	@Test
	public void robotDogShouldPlay() {
		pill.play();
		int moodCheck = pill.getMood();
		assertEquals(moodCheck, 2);
	}

	@Test
	public void shouldTickRobotCat() {
		dill.tick();
		int moodCheck = dill.getMood();
		int lubeCheck = dill.getLube();
		int rustCheck = dill.getRust();
		assertThat(moodCheck, is(allOf(greaterThan(-3), lessThan(5))));
		assertEquals(lubeCheck, 0);
		assertEquals(rustCheck, 2);
	}

	@Test
	public void shouldTickRobotDog() {
		pill.tick();
		int moodCheck = pill.getMood();
		int lubeCheck = pill.getLube();
		int rustCheck = pill.getRust();
		assertThat(moodCheck, is(allOf(greaterThan(-3), lessThan(5))));
		assertEquals(lubeCheck, 0);
		assertEquals(rustCheck, 2);
	}
}