package virtualPetAmok;

public class RobotDog extends RobotCat implements Dog {
	public RobotDog(String name, String description) {
		super(name, description);
	}

	public RobotDog(String name, String description, int mood, int lube, int rust) {
		super(name, description, mood, lube, rust);

	}

	@Override
	public void walk() {
		mood++;
	}

}
