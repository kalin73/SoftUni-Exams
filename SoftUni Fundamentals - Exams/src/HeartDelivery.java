import java.util.Arrays;
import java.util.Scanner;

public class HeartDelivery {
	private static int index = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] houses = Arrays.stream(sc.nextLine().split("@")).mapToInt(Integer::parseInt).toArray();

		String[] command = sc.nextLine().split(" ");

		while (!command[0].equals("Love!")) {
			int jumpLength = Integer.parseInt(command[1]);
			index += jumpLength;

			if (index < houses.length) {
				checkHearts(houses);

			} else if (index >= houses.length) {
				index = 0;
				checkHearts(houses);
			}

			command = sc.nextLine().split(" ");
		}
		printResut(houses);
		sc.close();
	}

	private static void checkHearts(int[] houses) {
		if (houses[index] == 0) {
			System.out.printf("Place %d already had Valentine's day.%n", index);

		} else {
			houses[index] -= 2;

			if (houses[index] == 0) {
				System.out.printf("Place %d has Valentine's day.%n", index);

			}
		}
	}

	private static void printResut(int[] houses) {
		System.out.printf("Cupid's last position was %d.%n", index);
		int places = 0;

		for (int i : houses) {
			if (i == 0) {
				places++;
			}
		}

		if (places < houses.length) {
			places = houses.length - places;

			System.out.printf("Cupid has failed %d places.", places);

		} else {
			System.out.println("Mission was successful.");
		}
	}
}
