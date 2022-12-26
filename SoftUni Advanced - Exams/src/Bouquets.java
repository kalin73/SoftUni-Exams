import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bouquets {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayDeque<Integer> daffodils = Arrays.stream(sc.nextLine().split(", ")).map(x -> Integer.parseInt(x))
				.collect(Collectors.toCollection(ArrayDeque::new));

		ArrayDeque<Integer> tulips = Arrays.stream(sc.nextLine().split(", ")).map(x -> Integer.parseInt(x))
				.collect(Collectors.toCollection(ArrayDeque::new));

		int bouquets = 0;
		int flowers = 0;

		while (!daffodils.isEmpty() && !tulips.isEmpty()) {
			int daffodil = daffodils.removeLast();
			int tulip = tulips.removeFirst();
			int sum = daffodil + tulip;

			while (true) {
				if (sum == 15) {
					bouquets++;
					break;

				} else if (sum > 15) {
					sum -= 2;

				} else if (sum < 15) {
					flowers += sum;
					break;
				}
			}
		}
		bouquets += flowers / 15;

		if (bouquets > 4) {
			System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets);
		} else {
			System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
		}
		
		sc.close();
	}
}
