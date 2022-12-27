package university;

import java.util.ArrayList;
import java.util.List;

public class University {
	public int capacity;
	public List<Student> students;

	public University(int capacity) {
		this.capacity = capacity;
		students = new ArrayList<>();
	}

	public int getCapacity() {
		return capacity;
	}

	public List<Student> getStudents() {
		return new ArrayList<>(students);
	}

	public int getStudentCount() {
		return students.size();
	}

	public String registerStudent(Student student) {
		if (students.contains(student)) {
			return "Student is already in the university";

		} else if (capacity <= students.size()) {
			return "No seats in the university";

		} else {
			students.add(student);
			return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
		}
	}

	public String dismissStudent(Student student) {
		if (students.contains(student)) {
			students.remove(student);
			return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());

		} else {
			return "Student not found";
		}
	}

	public Student getStudent(String firstName, String lastName) {
		for (Student s : students) {
			if (s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)) {
				return s;
			}
		}
		return null;
	}

	public String getStatistics() {
		StringBuilder stats = new StringBuilder();

		for (Student s : students) {
			stats.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s%n",
					s.getFirstName(), s.getLastName(), s.getBestSubject()));
		}
		return stats.toString();
	}
}
