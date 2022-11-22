package sanctuary;

import java.util.ArrayList;
import java.util.List;

public class Habitat {
	private int capacity;
	private List<Elephant> data;

	public Habitat(int capacity) {
		this.capacity = capacity;
		data = new ArrayList<>(capacity);
	}

	public void add(Elephant elephant) {
		if (data.size() < capacity) {
			data.add(elephant);
		}
	}

	public boolean remove(String name) {

		for (Elephant e : data) {
			if (e.getName().equals(name)) {
				data.remove(e);
				return true;
			}
		}
		return false;
	}

	public Elephant getElephant(String retiredFrom) {
		for (Elephant e : data) {
			if (e.getRetiredFrom().equals(retiredFrom)) {
				return e;
			}
		}
		return null;
	}

	public Elephant getOldestElephant() {
		Elephant oldest = null;

		for (Elephant e : data) {
			if (oldest == null || e.getAge() > oldest.getAge()) {
				oldest = e;
			}
		}
		return oldest;
	}

	public int getAllElephants() {
		return data.size();
	}

	public String getReport() {
		StringBuilder report = new StringBuilder();
		report.append("Saved elephants in the park:\n");

		data.forEach(x -> report.append(x.getName() + " came from: " + x.getRetiredFrom() + "\n"));

		return report.toString();

	}

}
