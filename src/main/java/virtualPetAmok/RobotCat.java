package virtualPetAmok;

import java.util.concurrent.ThreadLocalRandom;

public class RobotCat extends VirtualPet {
	protected int lube = ThreadLocalRandom.current().nextInt(5, 11);
	protected int rust = ThreadLocalRandom.current().nextInt(5, 11);

	public RobotCat(String name, String description) {
		this.name = name;
		this.description = description;
		health = (lube - rust) + mood;
	}

	public RobotCat(String name, String description, int mood, int lube, int rust) {
		this.name = name;
		this.description = description;
		this.mood = mood;
		this.lube = lube;
		this.rust = rust;
		this.health = (this.lube - this.rust) + this.mood;
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
}
