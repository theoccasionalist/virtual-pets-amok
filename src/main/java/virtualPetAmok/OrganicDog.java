package virtualPetAmok;

public class OrganicDog extends OrganicCat implements Dog {

	public OrganicDog(String name, String description) {
		super(name, description);
		health = (int) (((fitness * .5) + (mood * .5) + ((hunger * thirst) / 4) + ((pee * poop) / 4)));
	}

	public OrganicDog(String name, String description, int mood, int fitness, int hunger, int pee, int poop,
			int thirst) {
		super(name, description, mood, fitness, hunger, pee, poop, thirst);
		this.health = (int) (((this.fitness * .5) + (this.mood * .3) + ((this.hunger * this.thirst) / 3)
				+ ((this.pee * this.poop) / 4)));
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
