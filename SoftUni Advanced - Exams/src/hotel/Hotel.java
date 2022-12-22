package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
	private String name;
	private int capacity;
	private List<Person> roster;

	public Hotel(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
		roster = new ArrayList<>();
	}

	public void add(Person person) {
		if (capacity > roster.size()) {
			this.roster.add(person);
		}
	}

	public boolean remove(String name) {
		return roster.removeIf(x -> x.getName().equals(name));
	}

	public Person getPerson(String name, String hometown) {
		for (Person person : roster) {
			if (person.getName().equals(name) && person.getHometown().equals(hometown)) {
				return person;
			}
		}
		return null;
	}

	public int getCount() {
		return roster.size();
	}

	public String getStatistics() {
		StringBuilder stats = new StringBuilder();
		stats.append(String.format("The people in the hotel %s are:%n", this.name));

		for (Person p : roster) {
			stats.append(p + "\n");
		}
		return stats.toString();
	}
}
