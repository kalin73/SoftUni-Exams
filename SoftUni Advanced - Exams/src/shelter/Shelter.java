package shelter;

import java.util.ArrayList;
import java.util.List;

public class Shelter {
	private int capacity;
	private List<Animal> data;

	public Shelter(int capacity) {
		this.capacity = capacity;
		data = new ArrayList<>(capacity);
	}

	public void add(Animal animal) {
		if (data.size() < capacity) {
			data.add(animal);
		}
	}

	public boolean remove(String name) {
		return data.removeIf(x -> x.getName().equals(name));
	}

	public Animal getAnimal(String name, String caretaker) {
		for (Animal animal : data) {
			if (animal.getName().equals(name) && animal.getCaretaker().equals(caretaker)) {
				return animal;
			}
		}
		return null;

	}

	public Animal getOldestAnimal() {
		Animal oldest = null;

		for (Animal animal : data) {
			if (oldest == null || animal.getAge() > oldest.getAge()) {
				oldest = animal;
			}
		}
		return oldest;
	}

	public int getCount() {
		return data.size();
	}

	public String getStatistics() {
		StringBuilder statistic = new StringBuilder();
		statistic.append("The shelter has the following animals:\n");

		data.forEach(x -> statistic.append(x.getName() + " " + x.getCaretaker() + "\n"));
		return statistic.toString();

	}
}
