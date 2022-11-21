import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class KAT {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] licenses = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
		int[] cars = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

		int days = 0;
		int licensedCars = 0;

		ArrayDeque<Integer> queueOfLicenses = new ArrayDeque<>();
		List<Integer> listOfCars = new ArrayList<>();

		for (int l : licenses) {
			queueOfLicenses.offer(l);
		}

		for (int c : cars) {
			listOfCars.add(c);
		}

		while (!queueOfLicenses.isEmpty() && !listOfCars.isEmpty()) {
			days++;

			int lastIndex = listOfCars.size() - 1;
			int firstCars = listOfCars.get(lastIndex);

			if (queueOfLicenses.peek() > firstCars * 2) {

				queueOfLicenses.offer(queueOfLicenses.remove() - firstCars * 2);
				licensedCars += listOfCars.remove(lastIndex);

			} else if (queueOfLicenses.peek() == firstCars * 2) {
				licensedCars += listOfCars.remove(lastIndex);
				queueOfLicenses.remove();

			} else {
				licensedCars += queueOfLicenses.peek() / 2;
				listOfCars.add(0, listOfCars.remove(lastIndex) - queueOfLicenses.remove() / 2);
			}
		}

		printResult(queueOfLicenses, listOfCars, days, licensedCars);
		sc.close();
	}

	private static void printResult(ArrayDeque<Integer> queueOfLicenses, List<Integer> listOfCars, int days,
			int licensedCars) {

		System.out.printf("%d cars were registered for %d days!%n", licensedCars, days);

		if (queueOfLicenses.isEmpty() && listOfCars.isEmpty()) {
			System.out.println("Good job! There is no queue in front of the KAT!");

		} else if (queueOfLicenses.isEmpty() && !listOfCars.isEmpty()) {
			int carsLeft = listOfCars.stream().mapToInt(x -> x).sum();
			System.out.printf("%d cars remain without license plates!%n", carsLeft);

		} else {
			int licensePlatesLeft = queueOfLicenses.stream().mapToInt(x -> x).sum();
			System.out.printf("%d license plates remain!%n", licensePlatesLeft);
		}

	}
}
