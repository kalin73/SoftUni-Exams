package easterBasket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
	private String material;
	private int capacity;
	private List<Egg> data;

	public Basket(String material, int capacity) {
		this.material = material;
		this.capacity = capacity;
		data = new ArrayList<>();
	}

	public void addEgg(Egg egg) {
		if (capacity > data.size()) {
			data.add(egg);
		}
	}

	public boolean removeEgg(String color) {
		boolean removed = data.removeIf(x -> x.getColor().equals(color));
		return removed;
	}

	public Egg getStrongestEgg() {
		Egg strongestEgg = null;
		int strongest = Integer.MIN_VALUE;

		for (Egg e : data) {
			if (e.getStrength() > strongest) {
				strongest = e.getStrength();
				strongestEgg = e;
			}
		}
		return strongestEgg;
	}

	public Egg getEgg(String color) {
		Egg egg = null;

		for (Egg e : data) {
			if (e.getColor().equals(color)) {
				egg = e;
				break;
			}
		}
		return egg;
	}

	public int getCount() {
		return data.size();
	}

	public String report() {
		StringBuilder report = new StringBuilder();
		report.append(String.format("%s basket contains:%n", this.material));

		for (Egg egg : data) {
			report.append(egg + "\n");
		}
		return report.toString().trim();
	}
}
