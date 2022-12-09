import java.util.LinkedHashMap;
import java.util.Scanner;

public class NeedforSpeedIII {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedHashMap<String, int[]> cars = new LinkedHashMap<>();
		int n = Integer.parseInt(sc.nextLine());
		addCars(sc, cars, n);

		String[] commands = sc.nextLine().split(" : ");

		while (!commands[0].equals("Stop")) {
			String command = commands[0];

			switch (command) {
			case "Drive":
				drive(cars, commands);
				break;

			case "Refuel":
				refuel(cars, commands);
				break;

			case "Revert":
				revert(cars, commands);
				break;

			}
			commands = sc.nextLine().split(" : ");
		}
		cars.forEach((key, value) -> {
			System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", key, value[0], value[1]);
		});
	}

	private static void addCars(Scanner sc, LinkedHashMap<String, int[]> cars, int n) {
		for (int i = 0; i < n; i++) {
			String[] car = sc.nextLine().split("\\|");
			String model = car[0];
			int mileage = Integer.parseInt(car[1]);
			int fuel = Integer.parseInt(car[2]);

			cars.put(model, new int[] { mileage, fuel });
		}
	}

	private static void drive(LinkedHashMap<String, int[]> cars, String[] input) {
		String car = input[1];
		int distance = Integer.parseInt(input[2]);
		int fuel = Integer.parseInt(input[3]);

		if (cars.get(car)[1] < fuel) {
			System.out.println("Not enough fuel to make that ride");

		} else {
			int[] specs = cars.get(car);
			specs[0] += distance;
			specs[1] -= fuel;
			System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);
			cars.put(car, specs);

			if (specs[0] >= 100000) {
				cars.remove(car);
				System.out.printf("Time to sell the %s!%n", car);
			}
		}
	}

	private static void refuel(LinkedHashMap<String, int[]> cars, String[] input) {
		String car = input[1];
		int fuel = Integer.parseInt(input[2]);
		int[] specs = cars.get(car);

		if (specs[1] + fuel > 75) {
			int required = 75 - specs[1];
			specs[1] = 75;

			System.out.printf("%s refueled with %d liters%n", car, required);

		} else {
			specs[1] += fuel;
			System.out.printf("%s refueled with %d liters%n", car, fuel);
		}
		cars.put(car, specs);
	}

	private static void revert(LinkedHashMap<String, int[]> cars, String[] input) {
		String car = input[1];
		int km = Integer.parseInt(input[2]);
		int[] specs = cars.get(car);

		if (specs[0] - km < 10000) {
			specs[0] = 10000;

		} else {
			System.out.printf("%s mileage decreased by %d kilometers%n", car, km);
			specs[0] -= km;
		}
		cars.put(car, specs);
	}
}
