package bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
	private String name;
	private int capacity;
	private List<Employee> employees;

	public Bakery(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
		employees = new ArrayList<>();
	}

	public void add(Employee employee) {
		if (capacity > employees.size()) {
			this.employees.add(employee);
		}
	}

	public boolean remove(String name) {
		return employees.removeIf(x -> x.getName().equals(name));
	}

	public Employee getOldestEmployee() {
		Employee oldestEmployee = null;
		int oldest = Integer.MIN_VALUE;

		for (Employee e : employees) {
			if (e.getAge() > oldest) {
				oldest = e.getAge();
				oldestEmployee = e;
			}
		}
		return oldestEmployee;
	}

	public Employee getEmployee(String name) {
		for (Employee employee : employees) {
			if (employee.getName().equals(name)) {
				return employee;
			}
		}
		return null;
	}

	public int getCount() {
		return employees.size();
	}

	public String report() {
		StringBuilder stats = new StringBuilder();
		stats.append(String.format("Employees working at Bakery %s:%n", this.name));

		for (Employee e : employees) {
			stats.append(e + "\n");
		}
		return stats.toString();
	}
}
