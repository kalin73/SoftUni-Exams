import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlowerWreaths {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayDeque<Integer> roses = Arrays.stream(sc.nextLine().split(", ")).map(Integer::parseInt)
				.collect(Collectors.toCollection(ArrayDeque::new));

		ArrayDeque<Integer> lilies = Arrays.stream(sc.nextLine().split(", ")).map(Integer::parseInt)
				.collect(Collectors.toCollection(ArrayDeque::new));

		int wreaths = 0;
		int flowers = 0;

		while (!roses.isEmpty() && !lilies.isEmpty()) {
			int rose = roses.removeFirst();
			int lilie = lilies.removeLast();
			int sum = rose + lilie;

			if (sum == 15) {
				wreaths++;
				continue;

			} else if (sum < 15) {
				flowers += sum;
				continue;
			}

			while (sum > 15) {
				sum -= 2;
				if (sum == 15) {
					wreaths++;
					break;

				} else if (sum < 15) {
					flowers += sum;
					break;
				}
			}
		}
		wreaths = wreaths + (flowers / 15);

		if (wreaths < 5) {
			System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreaths);

		} else {
			System.out.printf("You made it, you are going to the competition with %d wreaths!", wreaths);
		}
		sc.close();
	}
}
