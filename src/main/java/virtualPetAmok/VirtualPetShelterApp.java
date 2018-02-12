package virtualPetAmok;

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

		System.out.println("Welcome to this virtual pet application.\nWe have fun and games...and robots.");

		Scanner input = new Scanner(System.in);
		input.nextLine();

		while (true) {
			shelter.tickAllCreatures();
			shelter.wasteMaker();
			System.out.println("\nOrganics:\n");
			String formatOrganics = String.format("%-15s%-20s%-15s%-15s%-15s%-15s%-15s%-15s%-15s", "Name", "Type",
					"Fitness", "Hunger", "Mood", "Pee", "Poop", "Thirst", "Total Health");
			System.out.println(formatOrganics);
			System.out.println(
					"_________________________________________________________________________________________________________________________________________");
			for (VirtualPet name : shelter.individualPets()) {
				if (name instanceof OrganicCat) {
					System.out.println(name);
				}
			}
			System.out.println("\n\t\t\t\t\t\tCat Litter Filth = " + shelter.getCatLitter());
			System.out.println("\t\t\t\t\t\tDog Pen Filth = " + shelter.getDogLitter());
			System.out.println("\nMechanics:\n");
			String formatMechanics = String.format("%-15s%-20s%-15s%-15s%-15s%-15s", "Name", "Type", "Mood", "Oil",
					"Rust", "Total Health");
			System.out.println(formatMechanics);
			System.out.println(
					"____________________________________________________________________________________________");
			for (VirtualPet name : shelter.individualPets()) {
				if (name instanceof RobotCat) {
					System.out.println(name);
				}
			}
			System.out.println("\nPlease type in the number or the first word from the commands below:");
			System.out.println();
			System.out.println("1: Feed organic creatures");
			System.out.println("2: Water organic creatures");
			System.out.println("3: Oil robot creatures");
			System.out.println("4: Walk organic and inorganic dogs");
			System.out.println("5: Scoop cat litters");
			System.out.println("6: Clean dog pens");
			System.out.println("7: Play with an individual animal");
			System.out.println("8: Leave an animal with us");
			System.out.println("9: Adopt an animal from us");
			System.out.println("10: Leave once and for all");
			String option = input.nextLine();

			if (option.equalsIgnoreCase("1") || option.equalsIgnoreCase("feed")) {
				System.out.println("Press 1 to feed the cats or press 2 to feed the dogs.");
				String suboption = input.nextLine();
				if (suboption.equalsIgnoreCase("1")) {
					shelter.feedOrganicCats();
					System.out.println("Organic cats fed.");
					input.nextLine();
					continue;
				} else if (suboption.equalsIgnoreCase("2")) {
					shelter.feedOrganicDogs();
					System.out.println("Organic dogs fed.");
					input.nextLine();
					continue;
				} else {
					System.out.println("Not an option.  You have wasted the pets' time. Shame.");
					input.nextLine();
					continue;
				}
			} else if (option.equalsIgnoreCase("2") || option.equalsIgnoreCase("water")) {
				System.out.println("Press 1 to water the cats or press 2 to water the dogs.");
				String suboption = input.nextLine();
				if (suboption.equalsIgnoreCase("1")) {
					shelter.waterOrganicCats();
					System.out.println("Organic cats watered.");
					input.nextLine();
					continue;
				} else if (suboption.equalsIgnoreCase("2")) {
					shelter.waterOrganicDogs();
					System.out.println("Organic dogs watered");
					input.nextLine();
				} else {
					System.out.println("Not an option.  You have wasted the pets' time. Shame.");
					input.nextLine();
					continue;
				}
			} else if (option.equalsIgnoreCase("3") || option.equalsIgnoreCase("lube")) {
				System.out.println("Press 1 to lube the cats or press 2 to lube the dogs.");
				String suboption = input.nextLine();
				if (suboption.equalsIgnoreCase("1")) {
					shelter.oilRobotCats();
					System.out.println("Robotic cats oiled.");
					input.nextLine();
					continue;
				} else if (suboption.equalsIgnoreCase("2")) {
					shelter.oilRobotDogs();
					System.out.println("Robotic dogs oiled.");
					input.nextLine();
				} else {
					System.out.println("Not an option.  You have wasted the pets' time. Shame.");
					input.nextLine();
					continue;
				}
			} else if (option.equalsIgnoreCase("4") || option.equalsIgnoreCase("walk")) {
				shelter.walkDogs();
				System.out.println("Organic and robotic dogs walked.");
				input.nextLine();
				continue;
			} else if (option.equalsIgnoreCase("5") || option.equalsIgnoreCase("scoop")) {
				shelter.cleanCatLitterBox();
				System.out.println("Cat litters scooped.");
				input.nextLine();
				continue;
			} else if (option.equalsIgnoreCase("6") || option.equalsIgnoreCase("clean")) {
				shelter.cleanDogLitterBox();
				System.out.println("Dog pens cleaned.");
				input.nextLine();
				continue;
			} else if (option.equalsIgnoreCase("7") || option.equalsIgnoreCase("play")) {
				System.out.println("What is the animal's name that you'd like to cuddle?");
				String name = input.nextLine();
				if (shelter.contains(name)) {
					shelter.play(name);
					System.out.println(name + " cuddled like a champ.");
					input.nextLine();
					continue;
				} else {
					System.out.println("Not an animal in shelter.  You have wasted the pets' time. Shame.");
					input.nextLine();
					continue;
				}
			} else if (option.equalsIgnoreCase("8") || option.equalsIgnoreCase("leave")) {
				System.out.println("What is the pet's name?");
				String name = input.nextLine();
				System.out.println("\nWhat is the pet's type? Enter the number from the options below:");
				System.out.println("1: Organic Cat\n2: Organic Dog\n3: Robotic Cat\n4: Robotic Dog\n5: Other");
				String type = input.nextLine();
				if (type.equalsIgnoreCase("1")) {
					OrganicCat organicCat = new OrganicCat(name, "Organic Cat");
					shelter.addCreature(organicCat);
					System.out.println("The organic cats welcome  " + name);
					input.nextLine();
					continue;
				} else if (type.equalsIgnoreCase("2")) {
					OrganicDog organicDog = new OrganicDog(name, "Organic Dog");
					shelter.addCreature(organicDog);
					System.out.println("The organic dogs welcome " + name);
					input.nextLine();
					continue;
				} else if (type.equalsIgnoreCase("3")) {
					RobotCat robotCat = new RobotCat(name, "Robot Cat");
					shelter.addCreature(robotCat);
					System.out.println("The robotic cats welcome " + name);
					input.nextLine();
					continue;
				} else if (type.equalsIgnoreCase("4")) {
					RobotDog robotDog = new RobotDog(name, "Robot Dog");
					shelter.addCreature(robotDog);
					System.out.println("The robotic dogs welcome " + name);
					input.nextLine();
					continue;
				} else if (type.equalsIgnoreCase("5")) {
					System.out.println("Option 5 is not an option.  You have wasted the pets' time. Shame.");
					input.nextLine();
					continue;
				} else {
					System.out.println("Not an option.  You have wasted the pets' time. Shame");
					input.nextLine();
					continue;
				}
			} else if (option.equalsIgnoreCase("9") || option.equalsIgnoreCase("adopt")) {
				System.out.println("What is the name of the animal you'd like to adopt?");
				String name = input.nextLine();
				if (shelter.contains(name)) {
					VirtualPet adopted = shelter.getName(name);
					System.out.println("You can now take " + name + " home with you.");
					shelter.adoptCreature(adopted);
					input.nextLine();
					continue;
				} else {
					System.out.println("No creature by that name. You have wasted the pets' time. Shame.");
					input.nextLine();
					continue;
				}
			} else if (option.equalsIgnoreCase("10") || option.equalsIgnoreCase("leave")) {
				System.out.println("Good riddance!");
				System.exit(0);
			} else {
				System.out.println("Not an option. You have wasted the pets' time. Shame");
				input.nextLine();
				continue;
			}
		}
	}
}
