package virtualPetAmok;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {
	int catLitter;
	int dogLitter;

	public Map<String, VirtualPet> shelter = new HashMap<>();

	public Collection<VirtualPet> individualPets() {
		return shelter.values();
	}

	public void addCreature(VirtualPet creature) {
		shelter.put(creature.getName(), creature);
	}

	public VirtualPet getName(String petName) {
		for (VirtualPet name : shelter.values()) {
			if (name.getName().equals(petName)) {
				return name;
			}
		}
		return null;
	}

	public void adoptCreature(VirtualPet creature) {
		shelter.remove(creature.getName(), creature);
	}

	public void feedOrganicCats() {
		for (VirtualPet name : shelter.values()) {
			if (name instanceof OrganicCat && !(name instanceof OrganicDog)) {
				((OrganicCat) name).eat();
			}
		}
	}

	public void feedOrganicDogs() {
		for (VirtualPet name : shelter.values()) {
			if (name instanceof OrganicDog) {
				((OrganicDog) name).eat();
			}
		}
	}

	public void waterOrganicCats() {
		for (VirtualPet name : shelter.values()) {
			if (name instanceof OrganicCat && !(name instanceof OrganicDog)) {
				((OrganicCat) name).drink();
			}
		}
	}

	public void waterOrganicDogs() {
		for (VirtualPet name : shelter.values()) {
			if (name instanceof OrganicDog) {
				((OrganicDog) name).drink();
			}
		}
	}

	public void oilRobotCats() {
		for (VirtualPet name : shelter.values()) {
			if (name instanceof RobotCat && !(name instanceof RobotDog)) {
				((RobotCat) name).oil();
			}
		}
	}

	public void oilRobotDogs() {
		for (VirtualPet name : shelter.values()) {
			if (name instanceof RobotDog) {
				((RobotDog) name).oil();
			}
		}
	}

	public void walkDogs() {
		for (VirtualPet name : shelter.values()) {
			if (name instanceof Dog) {
				((Dog) name).walk();
			}
		}
	}

	public void play(String petName) {
		for (VirtualPet name : shelter.values()) {
			if (name.getName().equals(petName)) {
				name.play();
			}
		}
	}

	public void tickAllCreatures() {
		for (VirtualPet name : shelter.values()) {
			name.tick();
			if (name instanceof OrganicCat && !(name instanceof OrganicDog)) {
				catLitter += (int) ((((OrganicCat) name).getPee() + ((OrganicCat) name).getPoop()) / 10);
			} else if (name instanceof OrganicDog) {
				dogLitter += (int) ((((OrganicDog) name).getPee() + ((OrganicDog) name).getPoop()) / 10);
			}
		}
	}

	public void cleanCatLitterBox() {
		catLitter = 0;
	}

	public void cleanDogLitterBox() {
		dogLitter = 0;
	}

	public int getCatLitter() {
		return catLitter;
	}

	public int getDogLitter() {
		return dogLitter;
	}

	public boolean contains(String petName) {
		for (VirtualPet name : shelter.values()) {
			if (name.getName().equals(petName)) {
				return true;
			}
		}
		return false;
	}
}