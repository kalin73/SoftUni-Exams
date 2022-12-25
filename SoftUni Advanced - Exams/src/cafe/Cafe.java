package cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
	private String name;
	private int capacity;
	private List<Employee> employees;

	public Cafe(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
		employees = new ArrayList<>();
	}

	public void addEmployee(Employee employee) {
		if (capacity > employees.size()) {
			this.employees.add(employee);
		}
	}

	public boolean removeEmployee(String name) {
		return employees.removeIf(x -> x.getName().equals(name));
	}

	public Employee getOldestEmployee() {
		employees.sort((f, s) -> Integer.compare(s.getAge(), f.getAge()));
		return employees.get(0);
	}

	public Employee getEmployee(String name) {
		for (Employee e : employees) {
			if (e.getName().equals(name)) {
				return e;
			}
		}
		return null;
	}

	public int getCount() {
		return employees.size();
	}

	public String report() {
		StringBuilder report = new StringBuilder();
		report.append(String.format("Employees working at Cafe %s:%n", this.name));

		for (Employee e : employees) {
			report.append(e + "\n");
		}
		return report.toString();
	}
}
