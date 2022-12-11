import java.util.Arrays;
import java.util.Scanner;

public class TheLift {
	private static int people;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		people = Integer.parseInt(sc.nextLine());
		int[] spots = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		placePeople(spots);
		printResult(spots);
		sc.close();
	}

	private static boolean spotsLeft(int[] spots) {
		for (int i = 0; i < spots.length; i++) {
			if (spots[i] != 4) {
				return true;
			}
		}
		return false;
	}

	private static void printResult(int[] spots) {
		if (people > 0) {
			System.out.printf("There isn't enough space! %d people in a queue!%n", people);

		} else if (spotsLeft(spots) && people == 0) {
			System.out.println("The lift has empty spots!");

		}
		for (int i = 0; i < spots.length; i++) {
			System.out.print(spots[i] + " ");
		}
	}

	private static void placePeople(int[] spots) {
		for (int i = 0; i < spots.length; i++) {
			int freeSpots = 4 - spots[i];

			if (people == 0) {
				break;
			}

			if (freeSpots > 0 && people > freeSpots) {
				people = people - freeSpots;
				spots[i] += freeSpots;

			} else if (freeSpots > 0) {
				spots[i] = spots[i] + people;
				people = 0;

			}
		}
	}
}
