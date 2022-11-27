import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class PlantDiscovery {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		LinkedHashMap<String, Integer> rarities = new LinkedHashMap<>();
		LinkedHashMap<String, List<Integer>> ratings = new LinkedHashMap<>();

		for (int i = 0; i < n; i++) {
			String[] input = sc.nextLine().split("<->");
			rarities.put(input[0], Integer.parseInt(input[1]));
			ratings.put(input[0], new ArrayList<>());
		}

		String[] command = sc.nextLine().split(": ");

		while (!"Exhibition".equals(command[0])) {

			switch (command[0]) {
			case "Rate":
				rate(command, ratings);
				break;

			case "Update":
				update(command, rarities);
				break;

			case "Reset":
				reset(command, ratings);
				break;
			}

			command = sc.nextLine().split(": ");
		}
		printResult(rarities, ratings);
		sc.close();
	}

	private static void rate(String[] command, LinkedHashMap<String, List<Integer>> ratings) {
		String[] plant = command[1].split(" - ");
		String name = plant[0];
		int rating = Integer.parseInt(plant[1]);
		List<Integer> currRatings = null;

		if (ratings.containsKey(name)) {
			currRatings = ratings.get(name);
			currRatings.add(rating);
			ratings.put(name, currRatings);

		} else {
			System.out.println("error");
		}

	}

	private static void update(String[] command, LinkedHashMap<String, Integer> rarities) {
		String[] plant = command[1].split(" - ");
		String name = plant[0];
		int rarity = Integer.parseInt(plant[1]);

		if (rarities.containsKey(name)) {
			rarities.put(name, rarity);

		} else {
			System.out.println("error");
		}
	}

	private static void reset(String[] command, LinkedHashMap<String, List<Integer>> ratings) {
		String name = command[1];
		List<Integer> currRatings = null;

		if (ratings.containsKey(name)) {
			currRatings = ratings.get(name);
			currRatings.clear();
			ratings.put(name, currRatings);

		} else {
			System.out.println("error");
		}
	}

	private static void printResult(LinkedHashMap<String, Integer> rarities,
			LinkedHashMap<String, List<Integer>> ratings) {
		System.out.println("Plants for the exhibition:");
		double avg = 0.0;
		
		for (String name : rarities.keySet()) {

			avg = ratings.get(name).stream().mapToInt(x -> x).average().orElse(0);
			System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", name, rarities.get(name), avg);

		}
	}
}
