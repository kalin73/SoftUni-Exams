import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Meeting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayDeque<Integer> males = new ArrayDeque<>();
		ArrayDeque<Integer> females = new ArrayDeque<>();
		int matches = 0;

		String[] maleInp = sc.nextLine().split(" ");
		String[] femaleInp = sc.nextLine().split(" ");

		for (String m : maleInp) {
			int stat = Integer.parseInt(m);
			if (stat >= 1) {
				males.push(stat);
			}

		}

		for (String f : femaleInp) {
			int stat = Integer.parseInt(f);
			if (stat >= 1) {
				females.offer(stat);
			}
		}

		while (!males.isEmpty() && !females.isEmpty()) {
			int male = males.peek();
			int female = females.peek();

			if (male < 1) {
				males.pop();
				continue;

			} else if (male % 25 == 0) {
				males.pop();
				males.pop();

			} else if (female % 25 == 0) {
				females.remove();
				females.remove();

			} else if (male == female) {
				matches++;
				males.pop();
				females.remove();

			} else {
				females.remove();
				males.pop();
				males.push(male - 2);
			}
		}
		System.out.println("Matches: " + matches);
		printResult(males, females);
		sc.close();

	}

	private static void printResult(ArrayDeque<Integer> males, ArrayDeque<Integer> females) {
		if (males.isEmpty()) {
			System.out.println("Males left: none");

		} else {
			String left = males.stream().map(String::valueOf).collect(Collectors.joining(", "));
			System.out.println("Males left: " + left);
		}

		if (females.isEmpty()) {
			System.out.println("Females left: none");

		} else {
			String left = females.stream().map(String::valueOf).collect(Collectors.joining(", "));
			System.out.println("Females left: " + left);
		}

	}
}
