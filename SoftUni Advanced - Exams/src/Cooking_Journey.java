import java.util.Scanner;

public class Cooking_Journey {
	private static int cheffX;
	private static int cheffY;
	private static int pillar1X = -1;
	private static int pillar1Y;
	private static int pillar2X;
	private static int pillar2Y;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = Integer.parseInt(sc.nextLine());
		char[][] pastryShop = new char[size][size];
		fillPastryShop(sc, pastryShop, size);
		findCheffAndPiller(pastryShop, size);

		String command = sc.nextLine();
		int money = 0;

		while (money < 50) {
			pastryShop[cheffX][cheffY] = '-';

			switch (command) {
			case "up":
				cheffX--;
				break;

			case "down":
				cheffX++;
				break;

			case "right":
				cheffY++;
				break;

			case "left":
				cheffY--;
				break;
			}
			if (!valid(size)) {
				System.out.println("Bad news! You are out of the pastry shop.");
				break;

			} else if (pastryShop[cheffX][cheffY] == 'P') {
				pillerFound(pastryShop);

			} else if (Character.isDigit(pastryShop[cheffX][cheffY])) {
				money += Character.getNumericValue(pastryShop[cheffX][cheffY]);
			}

			pastryShop[cheffX][cheffY] = 'S';

			if (money > 49) {
				System.out.println("Good news! You succeeded in collecting enough money!");
				break;
			}
			command = sc.nextLine();
		}

		System.out.println("Money: " + money);
		print(pastryShop, size);

	}

	private static void fillPastryShop(Scanner sc, char[][] pastryShop, int size) {
		for (int row = 0; row < size; row++) {
			pastryShop[row] = sc.nextLine().toCharArray();
		}
	}

	private static void findCheffAndPiller(char[][] pastryShop, int size) {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				if (pastryShop[row][col] == 'S') {
					cheffX = row;
					cheffY = col;

				} else if (pastryShop[row][col] == 'P' && pillar1X == -1) {
					pillar1X = row;
					pillar1Y = col;

				} else if (pastryShop[row][col] == 'P') {
					pillar2X = row;
					pillar2Y = col;
				}
			}
		}
	}

	private static void pillerFound(char[][] pastryShop) {
		pastryShop[cheffX][cheffY] = '-';
		if (cheffX == pillar1X && cheffY == pillar1Y) {
			cheffX = pillar2X;
			cheffY = pillar2Y;

		} else if (cheffX == pillar2X && cheffY == pillar2Y) {
			cheffX = pillar1X;
			cheffY = pillar1Y;
		}
	}

	private static boolean valid(int n) {
		if (cheffX >= 0 && cheffX < n && cheffY >= 0 && cheffY < n) {
			return true;
		}
		return false;
	}

	private static void print(char[][] pastryShop, int size) {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				System.out.print(pastryShop[row][col]);
			}
			System.out.println();
		}
	}
}
