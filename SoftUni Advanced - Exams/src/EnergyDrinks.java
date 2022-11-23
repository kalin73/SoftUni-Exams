import java.util.ArrayDeque;
import java.util.Scanner;

public class EnergyDrinks {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		int dailyMilligrams = 0;

		String[] caffeine = sc.nextLine().split(", ");
		String[] drinks = sc.nextLine().split(", ");

		for (String c : caffeine) {
			stack.push(Integer.parseInt(c));
		}

		for (String d : drinks) {
			queue.offer(Integer.parseInt(d));
		}

		while (!stack.isEmpty() && !queue.isEmpty()) {
			int potentialDoze = dailyMilligrams + stack.peek() * queue.peek();

			if (potentialDoze <= 300) {
				dailyMilligrams += stack.pop() * queue.remove();

			} else {
				stack.pop();
				queue.offer(queue.remove());

				if (dailyMilligrams - 30 >= 0) {
					dailyMilligrams -= 30;
				}

			}

		}
		printResult(queue, dailyMilligrams);
		sc.close();
	}

	private static void printResult(ArrayDeque<Integer> queue, int dailyDoze) {
		StringBuilder sb = new StringBuilder();

		if (queue.isEmpty()) {
			System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
			System.out.println("Stamat is going to sleep with " + dailyDoze + " mg caffeine.");
			return;
		} else {
			queue.forEach(x -> sb.append(x + ", "));

		}
		sb.replace(sb.length() - 2, sb.length(), "");

		System.out.println("Drinks left: " + sb.toString());
		System.out.println("Stamat is going to sleep with " + dailyDoze + " mg caffeine.");
	}
}
