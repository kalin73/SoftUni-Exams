import java.util.Scanner;

public class Bee {
	private static int beeX;
	private static int beeY;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = Integer.parseInt(sc.nextLine());
		char[][] territory = new char[size][size];

		fillPastryShop(sc, territory, size);
		findBee(territory, size);

		int pollinatedFlowers = 0;

		String command = sc.nextLine();

		while (!command.equals("End")) {
			territory[beeX][beeY] = '.';

			switch (command) {
			case "up":
				beeX--;
				if (valid(size) && territory[beeX][beeY] == 'O') {
					territory[beeX][beeY] = '.';
					beeX--;
				}
				break;

			case "down":
				beeX++;
				if (valid(size) && territory[beeX][beeY] == 'O') {
					territory[beeX][beeY] = '.';
					beeX++;
				}
				break;

			case "right":
				beeY++;
				if (valid(size) && territory[beeX][beeY] == 'O') {
					territory[beeX][beeY] = '.';
					beeY++;
				}
				break;

			case "left":
				beeY--;
				if (valid(size) && territory[beeX][beeY] == 'O') {
					territory[beeX][beeY] = '.';
					beeY--;
				}
				break;
			}
			if (!valid(size)) {
				System.out.println("The bee got lost!");
				break;

			} else if (territory[beeX][beeY] == 'f') {
				pollinatedFlowers++;
			}

			territory[beeX][beeY] = 'B';

			command = sc.nextLine();

		}
		if (pollinatedFlowers < 5) {
			System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n",
					5 - pollinatedFlowers);

		} else {
			System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
		}

		print(territory, size);
	}

	private static void fillPastryShop(Scanner sc, char[][] territory, int size) {
		for (int row = 0; row < size; row++) {
			territory[row] = sc.nextLine().toCharArray();
		}
	}

	private static void findBee(char[][] territory, int size) {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				if (territory[row][col] == 'B') {
					beeX = row;
					beeY = col;

				}
			}
		}
	}

	private static boolean valid(int n) {
		if (beeX >= 0 && beeX < n && beeY >= 0 && beeY < n) {
			return true;
		}
		return false;
	}

	private static void print(char[][] territory, int size) {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				System.out.print(territory[row][col]);
			}
			System.out.println();
		}
	}
}
