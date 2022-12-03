package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
	private List<Pet> data;
	private int capacity;

	public GroomingSalon(int capacity) {
		this.capacity = capacity;
		data = new ArrayList<>();
	}

	public void add(Pet pet) {
		if (capacity > data.size()) {
			this.data.add(pet);
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

	public int getCount() {
		return data.size();
	}

	public String getStatistics() {
		StringBuilder stats = new StringBuilder();
		stats.append("The grooming salon has the following clients:\n");
		data.forEach(x -> stats.append(x.getName() + " " + x.getOwner() + "\n"));
		
		return stats.toString();
	}
}
