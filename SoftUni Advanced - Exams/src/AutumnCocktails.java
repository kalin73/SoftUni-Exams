import java.util.ArrayDeque;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AutumnCocktails {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayDeque<Integer> ingredients = new ArrayDeque<>();
		ArrayDeque<Integer> freshnessValues = new ArrayDeque<>();

		Map<Integer, String> freshnessLevels = Map.of(150, "Pear Sour", 250, "The Harvest", 300, "Apple Hinny", 400,
				"High Fashion");

		TreeMap<String, Integer> cocktails = new TreeMap<>();

		String[] ingrInp = sc.nextLine().split(" ");
		String[] freshInp = sc.nextLine().split(" ");

		for (String i : ingrInp) {
			int ingredient = Integer.parseInt(i);
			if (ingredient >= 1) {
				ingredients.offer(ingredient);
			}
		}

		for (String f : freshInp) {
			int freshness = Integer.parseInt(f);
			freshnessValues.push(freshness);

		}

		while (!ingredients.isEmpty() && !freshnessValues.isEmpty()) {
			int ingredient = ingredients.remove();
			int freshness = freshnessValues.pop();
			int mix = ingredient * freshness;

			if (freshnessLevels.containsKey(mix)) {
				String cocktailName = freshnessLevels.get(mix);

				if (cocktails.containsKey(cocktailName)) {
					cocktails.put(cocktailName, cocktails.get(cocktailName) + 1);
				}
				cocktails.putIfAbsent(cocktailName, 1);
				continue;
			}
			ingredients.offer(ingredient + 5);

		}
		if (cocktails.size() == 4) {
			System.out.println("It's party time! The cocktails are ready!");

		} else {
			System.out.println("What a pity! You didn't manage to prepare all cocktails.");

		}
		if (ingredients.size() > 0) {
			int left = ingredients.stream().mapToInt(x -> x).sum();
			System.out.println("Ingredients left: " + left);
		}
		cocktails.forEach((k, v) -> System.out.printf(" # %s --> %d%n", k, v));
		sc.close();
	}
}
