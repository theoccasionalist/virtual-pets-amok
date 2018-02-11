package virtualPetAmok;

public class OrganicDog extends OrganicCat implements Dog {

	public OrganicDog(String name, String description) {
		super(name, description);
	}

	public OrganicDog(String name, String description, int mood, int fitness, int hunger, int pee, int poop,
			int thirst) {
		super(name, description, mood, fitness, hunger, pee, poop, thirst);
	}

	@Override
	public void walk() {
		fitness++;
		hunger++;
		mood++;
		poop--;
		pee--;
		thirst++;
	}

}
