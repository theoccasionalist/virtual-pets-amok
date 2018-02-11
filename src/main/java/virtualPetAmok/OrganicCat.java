package virtualPetAmok;

import java.util.concurrent.ThreadLocalRandom;

public class OrganicCat extends VirtualPet {

	protected int fitness = ThreadLocalRandom.current().nextInt(5, 11);;
	protected int hunger = ThreadLocalRandom.current().nextInt(5, 11);
	protected int pee = ThreadLocalRandom.current().nextInt(5, 11);
	protected int poop = ThreadLocalRandom.current().nextInt(5, 11);
	protected int thirst = ThreadLocalRandom.current().nextInt(5, 11);

	public OrganicCat(String name, String description) {
		this.name = name;
		this.description = description;
		health = fitness + mood;
	}

	public OrganicCat(String name, String description, int mood, int fitness, int hunger, int pee, int poop,
			int thirst) {
		this.name = name;
		this.description = description;
		this.mood = mood;
		this.fitness = fitness;
		this.hunger = hunger;
		this.pee = pee;
		this.poop = poop;
		this.thirst = thirst;
		this.health = this.fitness + this.mood;
	}

	public void drink() {
		pee++;
		thirst--;
	}

	public void eat() {
		hunger--;
		poop++;
	}

	public void pee() {
		pee--;
		thirst++;
	}

	public void poop() {
		hunger++;
		poop--;
	}

	public int getHunger() {
		return hunger;
	}

	public int getPee() {
		return pee;
	}

	public int getPoop() {
		return poop;
	}

	public int getThirst() {
		return thirst;
	}

	public int getFitness() {
		return fitness;
	}

	@Override
	public void tick() {
		if (evenOdd == 1) {
			mood += ThreadLocalRandom.current().nextInt(1, 4);
			fitness--;
		} else {
			mood -= ThreadLocalRandom.current().nextInt(1, 4);
			fitness++;
		}

		hunger++;
		pee++;
		poop++;
		thirst++;
	}

}
