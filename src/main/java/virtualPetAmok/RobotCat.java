package virtualPetAmok;

import java.util.concurrent.ThreadLocalRandom;

public class RobotCat extends VirtualPet {
	protected int lube = ThreadLocalRandom.current().nextInt(5, 11);
	protected int rust = ThreadLocalRandom.current().nextInt(5, 11);

	public RobotCat(String name, String description) {
		this.name = name;
		this.description = description;
		health = (int) (6 * (.5 * lube - .3 * rust) + 7 * (.5 * mood));
	}

	public RobotCat(String name, String description, int mood, int lube, int rust) {
		this.name = name;
		this.description = description;
		this.mood = mood;
		this.lube = lube;
		this.rust = rust;
		this.health = (int) (6 * (.5 * this.lube - .3 * this.rust) + 7 * (.5 * this.mood));
	}

	public void oil() {
		lube++;
		rust--;
	}

	public int getLube() {
		return lube;
	}

	public int getRust() {
		return rust;
	}

	@Override
	public void tick() {
		if (evenOdd == 1) {
			mood += ThreadLocalRandom.current().nextInt(1, 4);
		} else {
			mood -= ThreadLocalRandom.current().nextInt(1, 4);
		}
		lube--;
		rust++;
	}

	@Override
	public String toString() {
		return String.format("%-15s%-20s%-15s%-15s%-15s%-15s", name, description, mood, lube, rust, health);
	}
}
