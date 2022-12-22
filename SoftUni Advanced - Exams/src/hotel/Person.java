package hotel;

public class Person {
	private String name;
	private int id;
	private int age;
	private String hometown;

	public Person(String name, int id, int age, String hometown) {
		setName(name);
		setId(id);
		setAge(age);
		setHometown(hometown);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	private void setAge(int age) {
		this.age = age;
	}

	public String getHometown() {
		return hometown;
	}

	private void setHometown(String hometown) {
		if (hometown.trim().isEmpty()) {
			this.hometown = "n/a";
			return;
		}
		this.hometown = hometown;
	}

	@Override
	public String toString() {
		return String.format("Person %s: %d, Age: %d, Hometown: %s", this.name, this.id, this.age, this.hometown);
	}
}
