import java.util.Scanner;

public class Snake {
	private static int snakeX;
	private static int snakeY;
	private static int burrow1X = -1;
	private static int burrow1Y;
	private static int burrow2X;
	private static int burrow2Y;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = Integer.parseInt(sc.nextLine());
		char[][] territory = new char[size][size];

		fillTerritory(sc, territory, size);
		findSnakeAndBurrow(territory, size);

		int foodEaten = 0;
		String command = sc.nextLine();

		while (foodEaten < 10) {
			territory[snakeX][snakeY] = '.';

			switch (command) {
			case "up":
				snakeX--;
				break;

			case "down":
				snakeX++;
				break;

			case "right":
				snakeY++;
				break;

			case "left":
				snakeY--;
				break;
			}
			if (!valid(size)) {
				System.out.println("Game over!");
				break;

			} else if (territory[snakeX][snakeY] == 'B') {
				burrowFound(territory);

			} else if (territory[snakeX][snakeY] == '*') {
				foodEaten++;
			}

			territory[snakeX][snakeY] = 'S';

			if (foodEaten > 9) {
				System.out.println("You won! You fed the snake.");
				break;
			}
			command = sc.nextLine();
		}
		System.out.println("Food eaten: " + foodEaten);
		print(territory, size);
	}

	private static void fillTerritory(Scanner sc, char[][] territory, int size) {
		for (int row = 0; row < size; row++) {
			territory[row] = sc.nextLine().toCharArray();
		}
	}

	private static void findSnakeAndBurrow(char[][] territory, int size) {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				if (territory[row][col] == 'S') {
					snakeX = row;
					snakeY = col;

				} else if (territory[row][col] == 'B' && burrow1X == -1) {
					burrow1X = row;
					burrow1Y = col;

				} else if (territory[row][col] == 'B') {
					burrow2X = row;
					burrow2Y = col;
				}
			}
		}
	}

	private static void burrowFound(char[][] pastryShop) {
		pastryShop[snakeX][snakeY] = '.';
		if (snakeX == burrow1X && snakeY == burrow1Y) {
			snakeX = burrow2X;
			snakeY = burrow2Y;

		} else if (snakeX == burrow2X && snakeY == burrow2Y) {
			snakeX = burrow1X;
			snakeY = burrow1Y;
		}
	}

	private static boolean valid(int n) {
		if (snakeX >= 0 && snakeX < n && snakeY >= 0 && snakeY < n) {
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
