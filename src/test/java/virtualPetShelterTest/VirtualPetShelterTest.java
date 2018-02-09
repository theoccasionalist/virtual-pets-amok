package virtualPetShelterTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import virtualPetShelter.VirtualPet;
import virtualPetShelter.VirtualPetShelter;

public class VirtualPetShelterTest {

	@Test
	public void shouldAddDefaultAnimal() {
		VirtualPetShelter testShelter = new VirtualPetShelter();
		VirtualPet testAnimal = new VirtualPet("Bill", "");
		testShelter.addCreature(testAnimal);
		boolean check = testShelter.contains("Bill");
		assertEquals(true, check);
	}

	@Test
	public void shouldShowDefaultAnimalName() {
		VirtualPetShelter testShelter = new VirtualPetShelter();
		VirtualPet testAnimal = new VirtualPet("Animal", "");
		testShelter.addCreature(testAnimal);
		VirtualPet check = testShelter.getName("Animal");
		String check2 = check.getName();
		assertEquals("Animal", check2);
	}

	@Test
	public void shouldAdoptCreature() {
		VirtualPetShelter testShelter = new VirtualPetShelter();
		VirtualPet testAnimal = new VirtualPet("Bill", "");
		testShelter.adoptCreature(testAnimal);
		boolean check = testShelter.contains("Bill");
		assertEquals(false, check);
	}

	@Test
	public void shouldHugAllCreatures() {
		VirtualPetShelter testShelter = new VirtualPetShelter();
		VirtualPet testAnimal = new VirtualPet("Bill", "", 1, 1, 1, 1);
		VirtualPet testAnimal2 = new VirtualPet("Phil", "", 1, 1, 1, 1);
		testShelter.addCreature(testAnimal);
		testShelter.addCreature(testAnimal2);
		testShelter.hugAllCreatures();
		int check = testShelter.getName("Bill").getHatred();
		int check2 = testShelter.getName("Phil").getHatred();
		int check3 = testShelter.getName("Bill").getUnrelentingLove();
		int check4 = testShelter.getName("Phil").getUnrelentingLove();
		assertEquals(-2, check);
		assertEquals(-2, check2);
		assertEquals(4, check3);
		assertEquals(4, check4);
	}

	@Test
	public void shouldPokeAllAnimals() {
		VirtualPetShelter testShelter = new VirtualPetShelter();
		VirtualPet testAnimal = new VirtualPet("Bill", "", 1, 1, 1, 1);
		VirtualPet testAnimal2 = new VirtualPet("Phil", "", 1, 1, 1, 1);
		testShelter.addCreature(testAnimal);
		testShelter.addCreature(testAnimal2);
		testShelter.pokeAllCreatures();
		int check = testShelter.getName("Bill").getHatred();
		int check2 = testShelter.getName("Phil").getHatred();
		int check3 = testShelter.getName("Bill").getUnrelentingLove();
		int check4 = testShelter.getName("Phil").getUnrelentingLove();
		assertEquals(4, check);
		assertEquals(4, check2);
		assertEquals(-2, check3);
		assertEquals(-2, check4);
	}

	@Test
	public void shouldCatAllAnimals() {
		VirtualPetShelter testShelter = new VirtualPetShelter();
		VirtualPet testAnimal = new VirtualPet("Bill", "", 1, 1, 1, 1);
		VirtualPet testAnimal2 = new VirtualPet("Phil", "", 1, 1, 1, 1);
		testShelter.addCreature(testAnimal);
		testShelter.addCreature(testAnimal2);
		testShelter.catAllCreatures();
		int check = testShelter.getName("Bill").getCatness();
		int check2 = testShelter.getName("Phil").getCatness();
		int check3 = testShelter.getName("Bill").getDogness();
		int check4 = testShelter.getName("Phil").getDogness();
		assertEquals(2, check);
		assertEquals(2, check2);
		assertEquals(0, check3);
		assertEquals(0, check4);
	}

	@Test
	public void shouldDogAllAnimals() {
		VirtualPetShelter testShelter = new VirtualPetShelter();
		VirtualPet testAnimal = new VirtualPet("Bill", "", 1, 1, 1, 1);
		VirtualPet testAnimal2 = new VirtualPet("Phil", "", 1, 1, 1, 1);
		testShelter.addCreature(testAnimal);
		testShelter.addCreature(testAnimal2);
		testShelter.dogAllCreatures();
		int check = testShelter.getName("Bill").getCatness();
		int check2 = testShelter.getName("Phil").getCatness();
		int check3 = testShelter.getName("Bill").getDogness();
		int check4 = testShelter.getName("Phil").getDogness();
		assertEquals(0, check);
		assertEquals(0, check2);
		assertEquals(2, check3);
		assertEquals(2, check4);
	}

	@Test
	public void shouldPlayWithAnimal() {
		VirtualPetShelter testShelter = new VirtualPetShelter();
		VirtualPet testAnimal = new VirtualPet("Bill", "", 1, 1, 1, 1);
		testShelter.addCreature(testAnimal);
		testShelter.play("Bill");
		int check = testShelter.getName("Bill").getHatred();
		int check2 = testShelter.getName("Bill").getUnrelentingLove();
		assertEquals(-2, check);
		assertEquals(4, check2);
	}

	@Test
	public void shouldTickAllAnimals() {
		VirtualPetShelter testShelter = new VirtualPetShelter();
		VirtualPet testAnimal = new VirtualPet("Bill", "", 1, 1, 1, 1);
		VirtualPet testAnimal2 = new VirtualPet("Phil", "", 1, 1, 1, 1);
		testShelter.addCreature(testAnimal);
		testShelter.addCreature(testAnimal2);
		testShelter.tickAllCreatures();
		int check = testShelter.getName("Bill").getHatred();
		int check2 = testShelter.getName("Phil").getHatred();
		int check3 = testShelter.getName("Bill").getUnrelentingLove();
		int check4 = testShelter.getName("Phil").getUnrelentingLove();
		assertEquals(2, check);
		assertEquals(2, check2);
		assertEquals(0, check3);
		assertEquals(0, check4);
	}
}