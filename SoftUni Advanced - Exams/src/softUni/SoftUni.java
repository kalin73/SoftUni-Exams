package softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {
	private int capacity;
	private List<Student> data;

	public SoftUni(int capacity) {
		this.capacity = capacity;
		data = new ArrayList<>();
	}

	public int getCapacity() {
		return this.capacity;
	}

	public int getCount() {
		return this.data.size();
	}

	public String insert(Student student) {
		if (capacity > data.size()) {
			if (studentFound(student)) {
				return "Student is already in the hall.";
			}
			data.add(student);
			return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
		}
		return "The hall is full.";
	}

	public String remove(Student student) {
		if (studentFound(student)) {
			data.remove(student);
			return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
		}

		return "Student not found.";
	}

	public Student getStudent(String firstName, String lastName) {
		for (Student s : data) {
			if (s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)) {
				return s;
			}
		}
		return null;
	}

	private boolean studentFound(Student student) {
		for (Student s : data) {
			if (s.getFirstName().equals(student.getFirstName()) && s.getLastName().equals(student.getLastName())) {
				return true;
			}
		}
		return false;
	}

	public String getStatistics() {
		StringBuilder stats = new StringBuilder();
		stats.append("Hall size: " + this.data.size() + "\n");

		for (Student s : data) {
			stats.append(s + "\n");
		}

		return stats.toString();
	}
}
