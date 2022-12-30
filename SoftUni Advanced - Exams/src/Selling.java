import java.util.Scanner;

public class Selling {
	private static int sellerX;
	private static int sellerY;
	private static int pillar1X = -1;
	private static int pillar1Y;
	private static int pillar2X;
	private static int pillar2Y;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = Integer.parseInt(sc.nextLine());
		char[][] bakery = new char[size][size];
		fillBakery(sc, bakery, size);
		findCheffAndPiller(bakery, size);
		int money = 0;
		String command = sc.nextLine();

		while (money < 50) {
			bakery[sellerX][sellerY] = '-';

			switch (command) {
			case "up":
				sellerX--;
				break;

			case "down":
				sellerX++;
				break;

			case "right":
				sellerY++;
				break;

			case "left":
				sellerY--;
				break;
			}
			if (!valid(size)) {
				System.out.println("Bad news, you are out of the bakery.");
				break;

			} else if (bakery[sellerX][sellerY] == 'O') {
				pillerFound(bakery);

			} else if (Character.isDigit(bakery[sellerX][sellerY])) {
				money += Character.getNumericValue(bakery[sellerX][sellerY]);
			}

			bakery[sellerX][sellerY] = 'S';

			if (money > 49) {
				System.out.println("Good news! You succeeded in collecting enough money!");
				break;
			}
			command = sc.nextLine();
		}
		System.out.println("Money: " + money);
		print(bakery, size);
	}

	private static void fillBakery(Scanner sc, char[][] bakery, int size) {
		for (int row = 0; row < size; row++) {
			bakery[row] = sc.nextLine().toCharArray();
		}
	}

	private static void findCheffAndPiller(char[][] bakery, int size) {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				if (bakery[row][col] == 'S') {
					sellerX = row;
					sellerY = col;

				} else if (bakery[row][col] == 'O' && pillar1X == -1) {
					pillar1X = row;
					pillar1Y = col;

				} else if (bakery[row][col] == 'O') {
					pillar2X = row;
					pillar2Y = col;
				}
			}
		}
	}

	private static boolean valid(int n) {
		if (sellerX >= 0 && sellerX < n && sellerY >= 0 && sellerY < n) {
			return true;
		}
		return false;
	}

	private static void pillerFound(char[][] bakery) {
		bakery[sellerX][sellerY] = '-';
		if (sellerX == pillar1X && sellerY == pillar1Y) {
			sellerX = pillar2X;
			sellerY = pillar2Y;

		} else if (sellerX == pillar2X && sellerY == pillar2Y) {
			sellerX = pillar1X;
			sellerY = pillar1Y;
		}
	}

	private static void print(char[][] bakery, int size) {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				System.out.print(bakery[row][col]);
			}
			System.out.println();
		}
	}
}
