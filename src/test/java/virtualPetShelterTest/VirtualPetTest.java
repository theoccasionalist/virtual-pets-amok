package virtualPetShelterTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import virtualPetShelter.VirtualPet;

public class VirtualPetTest {

	@Test
	public void shouldGetNameCreature() {
		VirtualPet underTest = new VirtualPet("Dog", "Not Cat");
		String check = underTest.getName();
		String check2 = underTest.getDescription();
		assertEquals("Dog", check);
		assertEquals("Not Cat", check2);
	}

	@Test
	public void shouldPokeCreature() {
		VirtualPet underTest = new VirtualPet("", "", 1, 1, 1, 1);
		underTest.pokeCreature();
		int check = underTest.getHatred();
		int check2 = underTest.getUnrelentingLove();
		assertEquals(4, check);
		assertEquals(-2, check2);
	}

	@Test
	public void shouldHugCreature() {
		VirtualPet underTest = new VirtualPet("", "", 1, 1, 1, 1);
		underTest.hugCreature();
		int check = underTest.getUnrelentingLove();
		int check2 = underTest.getHatred();
		assertEquals(4, check);
		assertEquals(-2, check2);
	}

	@Test
	public void shouldCatCreature() {
		VirtualPet underTest = new VirtualPet("", "", 1, 1, 1, 1);
		underTest.catCreature();
		int check = underTest.getCatness();
		int check2 = underTest.getDogness();
		assertEquals(2, check);
		assertEquals(0, check2);
	}

	@Test
	public void shouldDogCreature() {
		VirtualPet underTest = new VirtualPet("", "", 1, 1, 1, 1);
		underTest.dogCreature();
		int check = underTest.getDogness();
		int check2 = underTest.getCatness();
		assertEquals(2, check);
		assertEquals(0, check2);
	}

	@Test
	public void shouldTickCreature() {
		VirtualPet underTest = new VirtualPet("", "", 1, 1, 1, 1);
		underTest.tickCreature();
		int check = underTest.getHatred();
		int check2 = underTest.getUnrelentingLove();
		assertEquals(2, check);
		assertEquals(0, check2);
	}
}