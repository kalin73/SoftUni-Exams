package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
	private String type;
	private int capacity;
	private List<Car> data;

	public Parking(String type, int capacity) {
		this.type = type;
		this.capacity = capacity;
		data = new ArrayList<>();
	}

	public void add(Car car) {
		if (capacity > data.size()) {
			this.data.add(car);
		}
	}

	public boolean remove(String manufacturer, String model) {
		return data.removeIf(x -> x.getManufacturer().equals(manufacturer) && x.getModel().equals(model));
	}

	public Car getLatestCar() {
		Car latestCar = null;
		int latest = Integer.MIN_VALUE;

		for (Car c : data) {
			if (c.getYear() > latest) {
				latest = c.getYear();
				latestCar = c;
			}
		}
		return latestCar;
	}

	public Car getCar(String manufacturer, String model) {
		for (Car car : data) {
			if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
				return car;
			}
		}
		return null;
	}

	public int getCount() {
		return data.size();
	}

	public String getStatistics() {
		StringBuilder stats = new StringBuilder();
		stats.append("The cars are parked in " + this.type + ":\n");

		for (Car c : data) {
			stats.append(c + "\n");
		}
		return stats.toString();
	}
}
