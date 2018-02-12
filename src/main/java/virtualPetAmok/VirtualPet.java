package virtualPetAmok;

import java.util.concurrent.ThreadLocalRandom;

public abstract class VirtualPet {
	protected String description;
	protected String name;

	protected int health;
	protected int mood = ThreadLocalRandom.current().nextInt(5, 11);
	protected int evenOdd = ThreadLocalRandom.current().nextInt(1, 3);

	abstract void tick();

	public void play() {
		mood++;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public int getMood() {
		return mood;
	}
}