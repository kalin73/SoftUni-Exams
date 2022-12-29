import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cooking {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayDeque<Integer> liquids = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt)
				.collect(Collectors.toCollection(ArrayDeque::new));

		ArrayDeque<Integer> ingredients = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt)
				.collect(Collectors.toCollection(ArrayDeque::new));

		Map<Integer, String> pastries = Map.of(25, "Bread", 50, "Cake", 75, "Pastry", 100, "Fruit Pie");
		LinkedHashMap<String, Integer> deserts = new LinkedHashMap<>();
		deserts.put("Bread", 0);
		deserts.put("Cake", 0);
		deserts.put("Fruit Pie", 0);
		deserts.put("Pastry", 0);

		while (!liquids.isEmpty() && !ingredients.isEmpty()) {
			int liquid = liquids.removeFirst();
			int ingredient = ingredients.removeLast();
			int sum = liquid + ingredient;

			if (pastries.containsKey(sum)) {
				String pastry = pastries.get(sum);
				deserts.put(pastry, deserts.get(pastry) + 1);
				continue;
			}

			ingredients.addLast(ingredient + 3);

		}

		if (jobDone(deserts)) {
			System.out.println("Wohoo! You succeeded in cooking all the food!");
		} else {
			System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
		}

		if (liquids.isEmpty()) {
			System.out.println("Liquids left: none");
		} else {
			List<Integer> list = liquids.stream().collect(Collectors.toList());
			Collections.reverse(list);
			String liquidsLeft = liquids.stream().map(String::valueOf).collect(Collectors.joining(", "));
			System.out.println("Liquids left: " + liquidsLeft);
		}

		if (ingredients.isEmpty()) {
			System.out.println("Ingredients left: none");
		} else {
			List<Integer> list = ingredients.stream().collect(Collectors.toList());
			Collections.reverse(list);
			String ingredientsLeft = list.stream().map(String::valueOf).collect(Collectors.joining(", "));
			System.out.println("Ingredients left: " + ingredientsLeft);
		}
		deserts.forEach((key, value) -> System.out.println(key + ": " + value));
		sc.close();
	}

	private static boolean jobDone(LinkedHashMap<String, Integer> deserts) {
		for (String key : deserts.keySet()) {
			if (deserts.get(key) == 0) {
				return false;
			}
		}
		return true;
	}
}
