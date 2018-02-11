package virtualPetAmok;

import java.util.Iterator;
import java.util.Scanner;

public class VirtualPetShelterApp {
	public static void main(String[] args) {

		OrganicCat creature1 = new OrganicCat("Phil", "Organic Cat");
		OrganicDog creature2 = new OrganicDog("Bill", "Organic Dog");
		RobotCat creature3 = new RobotCat("Robo Phil", "Robot Cat");
		RobotDog creature4 = new RobotDog("Robo Bill", "Robot Dog");

		VirtualPetShelter shelter = new VirtualPetShelter();
		shelter.addCreature(creature1);
		shelter.addCreature(creature2);
		shelter.addCreature(creature3);
		shelter.addCreature(creature4);

		Scanner input = new Scanner(System.in);

		while (true) {

			Iterator<VirtualPet> toRemove = shelter.petObjectValues().iterator();
			while (toRemove.hasNext()) {
				VirtualPet value = toRemove.next();
				if (value.getCatness() >= 12) {
					System.out.println(
							"Update:\n" + value.getName() + " is full-on cat and has been moved to the cat playpen.");
					toRemove.remove();
				} else if (value.getDogness() >= 12) {
					System.out.println(
							"Update:\n" + value.getName() + " is full-on dog and has been moved to the dog playpen.");
					toRemove.remove();
				} else if (value.getDogness() <= 0) {
					System.out.println("Update:\n" + value.getName()
							+ " has no dogness remaining and has been moved to the \'mostly cat\' playpen.");
					toRemove.remove();
				} else if (value.getCatness() <= 0) {
					System.out.println("Update:\n" + value.getName()
							+ " has no catness remaining and has been moved to the \'mostly dog\' playpen.");
					toRemove.remove();
				} else if (value.getHatred() >= 15) {
					System.out.println(
							"Update:\n" + value.getName() + " has mutinied.  Its rebellion was quelled accordingly.");
					toRemove.remove();
				} else if (value.getHatred() <= 0) {
					System.out.println("Update:\n" + value.getName()
							+ " feels no hatred.  It has moved to a commune in the country.");
					toRemove.remove();
					;
				} else if (value.getUnrelentingLove() >= 15) {
					System.out.println("Update:\n" + value.getName()
							+ " has felt true bliss and ascended into the fifth-dimension.");
					toRemove.remove();
				} else if (value.getUnrelentingLove() <= 0) {
					System.out.println("Update:\n" + value.getName()
							+ " feels no love and is now soul journeying in the Nevada desert.");
					toRemove.remove();
				}
			}

			shelter.tickAllCreatures();
			System.out.println("\nList of creatures in the playpen and their attributes:\n");
			String format = String.format("%-17s%-35s%-17s%-17s%-17s%-17s", "Name", "Description", "Hatred", "Love",
					"Catness", "Dogness");
			System.out.println(format);
			System.out.println(
					"______________________________________________________________________________________________________________");
			for (VirtualPet creature : shelter.petObjectValues()) {
				System.out.println(creature);
			}
			System.out.println("\nPlease type in the number or the first word from the commands below:");
			System.out.println();
			System.out.println("1: Hug all creatures");
			System.out.println("2: Jab all creatures");
			System.out.println("3: Cat all creatures");
			System.out.println("4: Dog all creatures");
			System.out.println("5: Play with a single creature");
			System.out.println("6: Add your own pet to the playpen");
			System.out.println("7: Take a pet from the playpen");
			System.out.println("8: Leave this place.");
			String option = input.nextLine();
			if (option.equals("1") || option.equalsIgnoreCase("hug")) {
				shelter.hugAllCreatures();
				System.out.println("\nYou hug all the animals. They hug you back.\n(Press any key)");
				input.nextLine();
				continue;
			} else if (option.equals("2") || option.equalsIgnoreCase("jab")) {
				shelter.pokeAllCreatures();
				System.out.println("\nYou jab all creatures. Each one kicks you in the stomach.\n(Press any key)");
				input.nextLine();
				continue;
			} else if (option.equals("3") || option.equalsIgnoreCase("cat")) {
				shelter.catAllCreatures();
				System.out.println(
						"\nYou sprinkle Cat Cog Powder on all the creatures. Their tails are longer and ears pointer.\n(Press any key)");
				input.nextLine();
				continue;
			} else if (option.equals("4") || option.equalsIgnoreCase("dog")) {
				shelter.dogAllCreatures();
				System.out.println(
						"\nYou sprinkle Dog Cog Powder on all the creatures. Their ears are floppier and faces snoutier.\n(Press any key)");
				input.nextLine();
				continue;
			} else if (option.equals("5") || option.equalsIgnoreCase("play")) {
				System.out.println("\nWhich creature plays?");
				String name = input.nextLine();
				shelter.play(name);
				System.out.println(name + " plays with hurricane force power.\n(Press any key)");
				input.nextLine();
				continue;
			} else if (option.equals("6") || option.equalsIgnoreCase("add")) {
				System.out.println("What is this creature's name?");
				String name = input.nextLine();
				System.out.println("Describe this creature");
				String description = input.nextLine();
				VirtualPet intakeCreature = new VirtualPet(name, description);
				shelter.addCreature(intakeCreature);
				System.out.println(name + " realizes that time is precious.\n(Press any key)");
				input.nextLine();
				continue;
			} else if (option.equals("7") || option.equalsIgnoreCase("take")) {
				System.out.println("Which animal would you like to take home?");
				String name = input.nextLine();
				VirtualPet creatureAdopted = shelter.getName(name);
				shelter.adoptCreature(creatureAdopted);
				System.out.println(name + " looks forward to life on the outside.\n(Press any key)");
				input.nextLine();
				continue;
			} else if (option.equals("8") || option.equalsIgnoreCase("leave")) {
				System.out.println("You leave this place for good.");
				System.exit(0);
			} else {
				System.out.println("Nope, not a thing.");
			}

		}
	}
}