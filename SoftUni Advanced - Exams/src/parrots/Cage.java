package parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
	private String name;
	private int capacity;
	private List<Parrot> data;

	public Cage(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
		data = new ArrayList<>();
	}

	public String getName() {
		return this.name;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public void add(Parrot parrot) {
		if (capacity > data.size()) {
			data.add(parrot);
		}
	}

	public boolean remove(String name) {
		boolean removed = data.removeIf(x -> x.getName().equals(name));
		return removed;
	}

	public Parrot sellParrot(String name) {
		for (Parrot p : data) {
			if (p.getName().equals(name)) {
				p.setAvailable(false);
				return p;
			}
		}
		return null;
	}

	public List<Parrot> sellParrotBySpecies(String species) {
		List<Parrot> sold = new ArrayList<>();
		for (Parrot p : data) {
			if (p.getSpecies().equals(species)) {
				p.setAvailable(false);
				sold.add(p);
			}
		}
		return sold;
	}

	public int count() {
		return data.size();
	}

	public String report() {
		StringBuilder report = new StringBuilder();
		report.append(String.format("Parrots available at %s:%n", this.name));

		for (Parrot p : data) {
			if (p.isAvailable()) {
				report.append(p + "\n");
			}
		}
		return report.toString().trim();
	}
}
