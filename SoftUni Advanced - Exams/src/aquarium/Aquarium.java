package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
	private String name;
	private int capacity;
	private int size;
	private List<Fish> fishInPool;

	public Aquarium(String name, int capacity, int size) {
		this.name = name;
		this.capacity = capacity;
		this.size = size;
		fishInPool = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getSize() {
		return size;
	}

	public int getFishInPool() {
		return this.fishInPool.size();
	}

	public void add(Fish fish) {
		boolean contains = false;

		if (fishInPool.size() < capacity) {
			for (Fish f : fishInPool) {
				if (f.getName().equals(fish.getName())) {
					contains = true;
					break;
				}
			}
			if (!contains) {
				fishInPool.add(fish);
			}
		}

	}

	public boolean remove(String name) {
		return fishInPool.removeIf(x -> x.getName().equals(name));
	}

	public Fish findFish(String name) {
		for (Fish fish : fishInPool) {
			if (fish.getName().equals(name)) {
				return fish;
			}
		}
		return null;
	}

	public String report() {
		StringBuilder aquarium = new StringBuilder();
		aquarium.append(String.format("Aquarium: %s ^ Size: %d%n", this.name, this.size));

		for (Fish fish : fishInPool) {
			aquarium.append(fish + "\n");
		}
		return aquarium.toString();
	}
}
