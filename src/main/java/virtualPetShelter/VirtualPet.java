package virtualPetShelter;

import java.util.concurrent.ThreadLocalRandom;

public class VirtualPet {
	private String name;
	private String description;
	private int hatred;
	private int unrelentingLove;
	private int catness;
	private int dogness;

	public VirtualPet(String name, String description) {
		this.name = name;
		this.description = description;
		this.hatred = ThreadLocalRandom.current().nextInt(5, 9);
		this.unrelentingLove = ThreadLocalRandom.current().nextInt(5, 9);
		this.catness = ThreadLocalRandom.current().nextInt(5, 9);
		this.dogness = ThreadLocalRandom.current().nextInt(5, 9);
	}

	public VirtualPet(String name, String description, int hatred, int unrelentingLove, int catness, int dogness) {
		this.name = name;
		this.description = description;
		this.hatred = hatred;
		this.unrelentingLove = unrelentingLove;
		this.catness = catness;
		this.dogness = dogness;
	}

	public void pokeCreature() { // meant to replace feeding pet
		hatred = hatred + 3;
		unrelentingLove = unrelentingLove - 3;
	}

	public void hugCreature() { // meant to replace watering pet
		hatred = hatred - 3;
		unrelentingLove = unrelentingLove + 3;
	}

	public void catCreature() {
		catness++;
		dogness--;
	}

	public void dogCreature() {
		catness--;
		dogness++;
	}

	public void tickCreature() {
		hatred++;
		unrelentingLove--;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getHatred() {
		return hatred;
	}

	public int getUnrelentingLove() {
		return unrelentingLove;
	}

	public int getCatness() {
		return catness;
	}

	public int getDogness() {
		return dogness;
	}

	@Override
	public String toString() {
		return String.format("%-17s%-35s%-17s%-17s%-17s%-17s", name, description, hatred, unrelentingLove, catness,
				dogness);
	}

}
