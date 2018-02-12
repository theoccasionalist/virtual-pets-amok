package virtualPetAmok;

public class RobotDog extends RobotCat implements Dog {
	public RobotDog(String name, String description) {
		super(name, description);
		health = (int) (6 * (.5 * lube - .3 * rust) + 7 * (.5 * mood));
	}

	public RobotDog(String name, String description, int mood, int lube, int rust) {
		super(name, description, mood, lube, rust);
		this.health = (int) (6 * (.5 * this.lube - .3 * this.rust) + 7 * (.5 * this.mood));
	}

	@Override
	public void walk() {
		mood++;
		rust++;
	}

}
