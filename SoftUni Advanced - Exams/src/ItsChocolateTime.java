import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class ItsChocolateTime {
	private static final double MILK_CHOCOLATE = 30.0;
	private static final double DARK_CHOCOLATE = 50.0;
	private static final double BAKING_CHOCOLATE = 100.0;
	private static int milkChocolates = 0;
	private static int darkChocolates = 0;
	private static int bakingChocolates = 0;
	private static TreeMap<String, Integer> chocolates = new TreeMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Double> cacao = new ArrayList<>();
		ArrayDeque<Double> milk = new ArrayDeque<>();

		String[] milkInp = sc.nextLine().split(" ");
		String[] cacaoInp = sc.nextLine().split(" ");

		for (String s : milkInp) {
			milk.offer(Double.parseDouble(s));
		}

		for (String s : cacaoInp) {
			cacao.add(Double.parseDouble(s));
		}
		makeChocolate(cacao, milk);
		printResult();
		sc.close();

	}

	private static void makeChocolate(List<Double> cacao, ArrayDeque<Double> milk) {
		while (!cacao.isEmpty() && !milk.isEmpty()) {
			double mix = cacao.get(cacao.size() - 1) / (cacao.get(cacao.size() - 1) + milk.peek()) * 100;

			if (mix == MILK_CHOCOLATE) {
				milkChocolates++;
				chocolates.put("Milk Chocolate", milkChocolates);
				cacao.remove(cacao.size() - 1);
				milk.remove();

			} else if (mix == DARK_CHOCOLATE) {
				darkChocolates++;
				chocolates.put("Dark Chocolate", darkChocolates);
				cacao.remove(cacao.size() - 1);
				milk.remove();

			} else if (mix == BAKING_CHOCOLATE) {
				bakingChocolates++;
				chocolates.put("Baking Chocolate", bakingChocolates);
				cacao.remove(cacao.size() - 1);
				milk.remove();

			} else {
				milk.offer(milk.remove() + 10);
				cacao.remove(cacao.size() - 1);
			}

		}

	}

	private static void printResult() {

		if (chocolates.size() == 3) {
			System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
			chocolates.forEach((k, v) -> System.out.println("# " + k + " --> " + v));
		} else {
			System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
			chocolates.forEach((k, v) -> System.out.println("# " + k + " --> " + v));
		}

	}
}
