import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bombs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayDeque<Integer> effects = Arrays.stream(sc.nextLine().split(", ")).map(Integer::parseInt)
				.collect(Collectors.toCollection(ArrayDeque::new));

		ArrayDeque<Integer> casings = Arrays.stream(sc.nextLine().split(", ")).map(Integer::parseInt)
				.collect(Collectors.toCollection(ArrayDeque::new));

		Map<Integer, String> bombs = Map.of(40, "Datura Bombs", 60, "Cherry Bombs", 120, "Smoke Decoy Bombs");
		LinkedHashMap<String, Integer> mix = new LinkedHashMap<>();
		mix.put("Cherry Bombs", 0);
		mix.put("Datura Bombs", 0);
		mix.put("Smoke Decoy Bombs", 0);

		while (!effects.isEmpty() && !casings.isEmpty()) {
			int effect = effects.getFirst();
			int bombCase = casings.removeLast();
			int sum = effect + bombCase;

			if (bombs.containsKey(sum)) {
				String bomb = bombs.get(sum);
				effects.removeFirst();
				mix.put(bomb, mix.get(bomb) + 1);

			} else {
				casings.addLast(bombCase - 5);
			}
			if (jobDone(mix)) {
				break;
			}
		}

		if (jobDone(mix)) {
			System.out.println("Bene! You have successfully filled the bomb pouch!");
		} else {
			System.out.println("You don't have enough materials to fill the bomb pouch.");
		}

		if (effects.isEmpty()) {
			System.out.println("Bomb Effects: empty");
		} else {
			List<Integer> list = effects.stream().collect(Collectors.toList());
			Collections.reverse(list);
			String effectsLeft = effects.stream().map(String::valueOf).collect(Collectors.joining(", "));
			System.out.println("Bomb Effects: " + effectsLeft);
		}

		if (casings.isEmpty()) {
			System.out.println("Bomb Casings: empty");
		} else {
			List<Integer> list = casings.stream().collect(Collectors.toList());
			Collections.reverse(list);
			String bombCasesLeft = list.stream().map(String::valueOf).collect(Collectors.joining(", "));
			System.out.println("Bomb Casings: " + bombCasesLeft);
		}
		mix.forEach((key, value) -> System.out.println(key + ": " + value));
		sc.close();
	}

	private static boolean jobDone(LinkedHashMap<String, Integer> mix) {
		boolean done = false;
		for (String key : mix.keySet()) {
			if (mix.get(key) >= 3) {
				done = true;
				continue;
			}
			return false;
		}
		return done;
	}
}
