package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
	private int capacity;
	private List<Pet> data;

	public Clinic(int capacity) {
		this.capacity = capacity;
		this.data = new ArrayList<>();
	}

	public void add(Pet Pet) {
		if (capacity > data.size()) {
			this.data.add(Pet);
		}
	}

	public boolean remove(String name) {
		return data.removeIf(x -> x.getName().equals(name));
	}

	public Pet getPet(String name, String owner) {
		for (Pet pet : data) {
			if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
				return pet;
			}
		}
		return null;
	}

	public Pet getOldestPet() {
		Pet oldestPet = null;
		int oldest = Integer.MIN_VALUE;

		for (Pet p : data) {
			if (p.getAge() > oldest) {
				oldest = p.getAge();
				oldestPet = p;
			}
		}
		return oldestPet;
	}

	public int getCount() {
		return data.size();
	}

	public String getStatistics() {
		StringBuilder stats = new StringBuilder();
		stats.append("The clinic has the following patients:\n");

		for (Pet p : data) {
			stats.append(p.getName() + " " + p.getOwner() + "\n");
		}
		return stats.toString();
	}

}
