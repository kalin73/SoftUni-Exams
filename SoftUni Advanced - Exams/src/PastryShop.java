import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PastryShop {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayDeque<Integer> liquids = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt)
				.collect(Collectors.toCollection(ArrayDeque::new));

		ArrayDeque<Integer> ingredients = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt)
				.collect(Collectors.toCollection(ArrayDeque::new));

		Map<Integer, String> pastries = Map.of(25, "Biscuit", 50, "Cake", 75, "Pastry", 100, "Pie");
		LinkedHashMap<String, Integer> deserts = new LinkedHashMap<>();
		deserts.put("Biscuit", 0);
		deserts.put("Cake", 0);
		deserts.put("Pie", 0);
		deserts.put("Pastry", 0);

		while (!liquids.isEmpty() && !ingredients.isEmpty()) {
			int liquid = liquids.removeFirst();
			int ingredient = ingredients.removeLast();
			int sum = liquid + ingredient;

			if (pastries.containsKey(sum)) {
				String desert = pastries.get(sum);
				deserts.put(desert, deserts.get(desert) + 1);

				continue;
			}
			ingredients.addLast(ingredient + 3);
		}
		if (jobDone(deserts)) {
			System.out.println("Great! You succeeded in cooking all the food!");
		} else {
			System.out.println("What a pity! You didn't have enough materials to cook everything.");
		}

		liquidsLeft(liquids);
		ingredientsLeft(ingredients);
		deserts.forEach((k, v) -> System.out.println(k + ": " + v));
		sc.close();

	}

	private static boolean jobDone(Map<String, Integer> deserts) {
		for (String key : deserts.keySet()) {
			if (deserts.get(key) == 0) {
				return false;
			}
		}
		return true;

	}

	private static void liquidsLeft(ArrayDeque<Integer> liquids) {
		if (liquids.isEmpty()) {
			System.out.println("Liquids left: none");
		} else {
			String liquidS = liquids.stream().map(String::valueOf).collect(Collectors.joining(", "));
			System.out.println("Liquids left: " + liquidS);

		}
	}

	private static void ingredientsLeft(ArrayDeque<Integer> ingredients) {
		if (ingredients.isEmpty()) {
			System.out.println("Ingredients left: none");
		} else {

			List<Integer> ingr = ingredients.stream().collect(Collectors.toList());
			Collections.reverse(ingr);
			String ingredientS = ingr.stream().map(String::valueOf).collect(Collectors.joining(", "));

			System.out.println("Ingredients left: " + ingredientS);

		}
	}
}
