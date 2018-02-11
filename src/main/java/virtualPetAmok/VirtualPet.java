package virtualPetAmok;

import java.util.concurrent.ThreadLocalRandom;

public abstract class VirtualPet {
	protected String description;
	protected String name;

	protected int health = ThreadLocalRandom.current().nextInt(5, 11);
	protected int mood = ThreadLocalRandom.current().nextInt(5, 11);
	protected int evenOdd = ThreadLocalRandom.current().nextInt(1, 3);

	abstract void tick();

	public void play() {
		health++;
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

	@Override
	public String toString() {
		return String.format("%-17s%-35s%", name, description);

	}
}