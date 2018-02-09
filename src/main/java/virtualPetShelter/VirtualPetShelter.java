package virtualPetShelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	private Map<String, VirtualPet> nameToPet = new HashMap<>();

	public Collection<VirtualPet> petObjectValues() {
		return nameToPet.values();
	}

	public void addCreature(VirtualPet creature) {
		nameToPet.put(creature.getName(), creature);
	}

	public VirtualPet getName(String petName) {
		for (VirtualPet name : nameToPet.values()) {
			if (name.getName().equals(petName)) {
				return name;
			}
		}
		return null;
	}

	public void adoptCreature(VirtualPet creature) {
		nameToPet.remove(creature.getName(), creature);
	}

	public void hugAllCreatures() {
		for (VirtualPet name : nameToPet.values()) {
			name.hugCreature();
		}
	}

	public void pokeAllCreatures() {
		for (VirtualPet name : nameToPet.values()) {
			name.pokeCreature();
		}
	}

	public void catAllCreatures() {
		for (VirtualPet name : nameToPet.values()) {
			name.catCreature();
		}
	}

	public void dogAllCreatures() {
		for (VirtualPet name : nameToPet.values()) {
			name.dogCreature();
		}
	}

	public void play(String petName) {
		for (VirtualPet name : nameToPet.values()) {
			if (name.getName().equals(petName)) {
				name.hugCreature();
			}
		}
	}

	public void tickAllCreatures() {
		for (VirtualPet name : nameToPet.values()) {
			name.tickCreature();
		}
	}

	public boolean contains(String petName) {
		for (VirtualPet name : nameToPet.values()) {
			if (name.getName().equals(petName)) {
				return true;
			}
		}
		return false;
	}
}