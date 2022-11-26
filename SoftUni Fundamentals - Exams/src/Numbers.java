import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Numbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] numbers = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		List<Integer> greater = new ArrayList<>();

		double avg = Arrays.stream(numbers).mapToDouble(x -> x).average().orElse(0);
		int counter = 1;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > avg) {
				greater.add(numbers[i]);

			}
		}
		if (greater.size() == 0) {
			System.out.println("No");
			sc.close();
			return;
		}
		greater.sort((f, s) -> Integer.compare(s, f));
		for (Integer i : greater) {
			if (counter <= 5) {
				System.out.print(i + " ");
				counter++;
			}
		}
		sc.close();

	}

}
