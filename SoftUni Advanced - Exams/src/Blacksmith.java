import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Blacksmith {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayDeque<Integer> queueOfSteel = new ArrayDeque<>();
		ArrayDeque<Integer> stackOfCarbon = new ArrayDeque<>();
		Map<String, Integer> forgedSwords = new TreeMap<>();
		Map<Integer, String> swords = Map.of(70, "Gladius", 80, "Shamshir", 90, "Katana", 110, "Sabre");

		int[] steelInp = Arrays.stream(sc.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
		int[] carbonInp = Arrays.stream(sc.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();

		for (int i = 0; i < steelInp.length; i++) {
			queueOfSteel.offer(steelInp[i]);
		}

		for (int i = 0; i < carbonInp.length; i++) {
			stackOfCarbon.push(carbonInp[i]);
		}

		while (!queueOfSteel.isEmpty() && !stackOfCarbon.isEmpty()) {
			int steel = queueOfSteel.remove();
			int carbon = stackOfCarbon.pop();
			int combination = steel + carbon;

			if (swords.containsKey(combination)) {
				String swordName = swords.get(combination);

				if (forgedSwords.containsKey(swordName)) {
					forgedSwords.put(swordName, forgedSwords.get(swordName) + 1);
				}

				forgedSwords.putIfAbsent(swordName, 1);
				continue;
			}
			stackOfCarbon.push(carbon + 5);

		}
		printResult(queueOfSteel, stackOfCarbon, forgedSwords);
		sc.close();
	}

	private static void printResult(ArrayDeque<Integer> queueOfSteel, ArrayDeque<Integer> stackOfCarbon,
			Map<String, Integer> forgedSwords) {
		if (forgedSwords.size() > 0) {
			int count = forgedSwords.values().stream().mapToInt(x -> x).sum();
			System.out.printf("You have forged %d swords.%n", count);

		} else {
			System.out.println("You did not have enough resources to forge a sword.");
		}

		if (queueOfSteel.size() == 0) {
			System.out.println("Steel left: none");
		} else {
			String steelLeft = queueOfSteel.stream().map(x -> String.valueOf(x)).collect(Collectors.joining(", "));
			System.out.println("Steel left: " + steelLeft);
		}

		if (stackOfCarbon.size() == 0) {
			System.out.println("Carbon left: none");
		} else {
			String carbonLeft = stackOfCarbon.stream().map(x -> String.valueOf(x)).collect(Collectors.joining(", "));
			System.out.println("Carbon left: " + carbonLeft);
		}

		forgedSwords.forEach((k, v) -> System.out.println(k + ": " + v));

	}
}
