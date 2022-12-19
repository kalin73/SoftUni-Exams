import java.util.Scanner;

public class Armory {
	private static int officerX;
	private static int officerY;
	private static int mirror1X;
	private static int mirror1Y;
	private static int mirror2X;
	private static int mirror2Y;
	private static int swordsWorth = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		char[][] armory = new char[n][n];

		for (int i = 0; i < n; i++) {
			armory[i] = sc.nextLine().toCharArray();
		}

		findOfficerAndMirrors(armory);

		while (swordsWorth < 65) {
			String command = sc.nextLine();
			armory[officerX][officerY] = '-';

			switch (command) {
			case "up":
				officerX--;
				break;

			case "down":
				officerX++;
				break;

			case "left":
				officerY--;
				break;

			case "right":
				officerY++;
				break;
			}

			if (gointOut(officerX, officerY, n)) {
				System.out.println("I do not need more swords!");
				break;

			} else {
				move(armory);
			}
		}
		if (!gointOut(officerX, officerY, n)) {
			System.out.println("Very nice swords, I will come back for more!");
		}

		System.out.printf("The king paid %d gold coins.%n", swordsWorth);
		printArmory(armory);
		sc.close();
	}

	private static void findOfficerAndMirrors(char[][] armory) {
		boolean mirrorFound = false;

		for (int row = 0; row < armory.length; row++) {
			for (int col = 0; col < armory.length; col++) {
				if (armory[row][col] == 'A') {
					officerX = row;
					officerY = col;

				} else if (armory[row][col] == 'M' && !mirrorFound) {
					mirror1X = row;
					mirror1Y = col;
					mirrorFound = true;

				} else if (armory[row][col] == 'M' && mirrorFound) {
					mirror2X = row;
					mirror2Y = col;
				}
			}
		}
	}

	private static boolean gointOut(int x, int y, int n) {
		if (x < 0 || x >= n || y < 0 || y >= n) {
			return true;
		}
		return false;
	}

	private static void move(char[][] armory) {
		if (Character.isDigit(armory[officerX][officerY])) {
			swordsWorth += Character.getNumericValue(armory[officerX][officerY]);
			armory[officerX][officerY] = 'A';

		} else if (officerX == mirror1X && officerY == mirror1Y) {
			mirrorTravel(mirror2X, mirror2Y, armory);

		} else if (officerX == mirror2X && officerY == mirror2Y) {
			mirrorTravel(mirror1X, mirror1Y, armory);

		} else {
			armory[officerX][officerY] = 'A';
		}
	}

	private static void printArmory(char[][] armory) {
		for (int row = 0; row < armory.length; row++) {
			for (int col = 0; col < armory.length; col++) {
				System.out.print(armory[row][col]);
			}
			System.out.println();
		}
	}

	private static void mirrorTravel(int mirrorX, int mirrorY, char[][] armory) {
		armory[officerX][officerY] = '-';
		officerX = mirrorX;
		officerY = mirrorY;
		armory[officerX][officerY] = 'A';
	}
}
