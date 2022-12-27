package university;

import java.util.Objects;

public class Student {
	public String firstName;
	public String lastName;
	public String bestSubject;

	public Student(String firstName, String lastName, String bestSubject) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.bestSubject = bestSubject;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBestSubject() {
		return bestSubject;
	}

	public void setBestSubject(String bestSubject) {
		this.bestSubject = bestSubject;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bestSubject, firstName, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(bestSubject, other.bestSubject) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName);
	}

	@Override
	public String toString() {
		return String.format("Student: %s %s, %s", this.firstName, this.lastName, this.bestSubject);
	}

}
