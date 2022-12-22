import java.util.Scanner;

public class MouseAndCheese {
	private static int mouseX;
	private static int mouseY;
	private static int cheeseEaten;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = Integer.parseInt(sc.nextLine());
		cheeseEaten = 0;
		char[][] territory = new char[size][size];

		for (int row = 0; row < size; row++) {
			territory[row] = sc.nextLine().toCharArray();
		}
		findMouse(territory, size);

		String command = sc.nextLine();

		while (!"end".equals(command)) {
			territory[mouseX][mouseY] = '-';

			switch (command) {
			case "up":
				mouseX--;
				if (bonusFound(territory)) {
					mouseX--;
				}
				break;

			case "down":
				mouseX++;
				if (bonusFound(territory)) {
					mouseX++;
				}
				break;

			case "right":
				mouseY++;
				if (bonusFound(territory)) {
					mouseY++;
				}
				break;

			case "left":
				mouseY--;
				if (bonusFound(territory)) {
					mouseY--;
				}
				break;
			}
			if (!isOut(size)) {
				searchForCheese(territory);

			} else {
				System.out.println("Where is the mouse?");
				break;
			}
			command = sc.nextLine();
		}
		if (cheeseEaten < 5) {
			int needed = 5 - cheeseEaten;
			System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", needed);

		} else {
			System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeseEaten);
		}
		printTerritory(territory, size);
		sc.close();
	}

	private static void findMouse(char[][] territory, int size) {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				if (territory[row][col] == 'M') {
					mouseX = row;
					mouseY = col;
					return;
				}
			}
		}
	}

	private static boolean isOut(int size) {
		if (mouseX < 0 || mouseX >= size || mouseY < 0 || mouseY >= size) {
			return true;
		}
		return false;
	}

	private static void searchForCheese(char[][] territory) {
		if (territory[mouseX][mouseY] == 'c') {
			cheeseEaten++;
		}
		territory[mouseX][mouseY] = 'M';
	}

	private static boolean bonusFound(char[][] territory) {
		if (!isOut(territory.length) && territory[mouseX][mouseY] == 'B') {
			territory[mouseX][mouseY] = '-';
			return true;
		}
		return false;
	}

	private static void printTerritory(char[][] territory, int size) {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				System.out.print(territory[row][col]);
			}
			System.out.println();
		}
	}
}
