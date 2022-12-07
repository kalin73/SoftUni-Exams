import java.util.LinkedHashMap;
import java.util.Scanner;

public class Pirates {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedHashMap<String, int[]> cities = new LinkedHashMap<>();
		String[] input = sc.nextLine().split("\\|\\|");

		while (!input[0].equals("Sail")) {
			addCities(cities, input);
			input = sc.nextLine().split("\\|\\|");
		}

		input = sc.nextLine().split("=>");
		while (!input[0].equals("End")) {
			String event = input[0];

			switch (event) {
			case "Plunder":
				plunder(cities, input);
				break;

			case "Prosper":
				prosper(cities, input);
				break;
			}

			input = sc.nextLine().split("=>");
		}
		printResult(cities, input);
		sc.close();
	}

	private static void addCities(LinkedHashMap<String, int[]> cities, String[] input) {
		String name = input[0];
		int population = Integer.parseInt(input[1]);
		int gold = Integer.parseInt(input[2]);

		if (cities.containsKey(name)) {
			int[] arr = cities.get(name);
			arr[0] += population;
			arr[1] += gold;
			cities.put(name, arr);
			return;
		}
		cities.put(name, new int[] { population, gold });

	}

	private static void plunder(LinkedHashMap<String, int[]> cities, String[] input) {
		String name = input[1];
		int people = Integer.parseInt(input[2]);
		int gold = Integer.parseInt(input[3]);
		int[] town = cities.get(name);

		town[0] -= people;
		town[1] -= gold;

		System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", name, gold, people);

		if (town[0] < 1 || town[1] < 1) {
			System.out.printf("%s has been wiped off the map!%n", name);
			cities.remove(name);
			return;
		}

	}

	private static void prosper(LinkedHashMap<String, int[]> cities, String[] input) {
		String name = input[1];
		int gold = Integer.parseInt(input[2]);
		int[] arr = cities.get(name);

		if (gold < 0) {
			System.out.println("Gold added cannot be a negative number!");
			return;
		}
		arr[1] += gold;
		cities.put(name, arr);
		System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, name, arr[1]);
	}

	private static void printResult(LinkedHashMap<String, int[]> cities, String[] input) {
		if (cities.size() == 0) {
			System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
			return;
		}
		System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cities.size());
		cities.forEach((key, value) -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", key, value[0],
				value[1]));
	}
}
