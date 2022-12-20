import java.util.Scanner;

public class Throne_Conquering {
	private static int parisX;
	private static int parisY;
	private static int energy;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		energy = Integer.parseInt(sc.nextLine());
		int n = Integer.parseInt(sc.nextLine());
		char[][] chamber = new char[n][5];
		fillchamber(sc, chamber);
		findParis(chamber);

		move(sc, n, chamber);
		printChamber(chamber);

	}

	private static void fillchamber(Scanner sc, char[][] chamber) {
		for (int row = 0; row < chamber.length; row++) {
			chamber[row] = sc.nextLine().toCharArray();
		}
	}

	private static void findParis(char[][] chamber) {

		for (int row = 0; row < chamber.length; row++) {
			for (int col = 0; col < chamber[0].length; col++) {
				if (chamber[row][col] == 'P') {
					parisX = row;
					parisY = col;
					chamber[parisX][parisY] = '-';
				}
			}
		}
	}

	private static void move(Scanner sc, int x, char[][] chamber) {
		String[] command = sc.nextLine().split(" ");
		while (true) {
			int spartanX = Integer.parseInt(command[1]);
			int spartanY = Integer.parseInt(command[2]);
			chamber[spartanX][spartanY] = 'S';
			energy--;

			switch (command[0]) {
			case "up":
				parisX--;
				if (parisX < 0) {
					parisX++;

				} else if (enemyFound(chamber)) {
					fightEnemy(chamber);

				} else if (chamber[parisX][parisY] == 'H') {
					helenFound(chamber);
					return;
				}
				break;

			case "down":
				parisX++;
				if (parisX >= chamber.length) {
					parisX--;

				} else if (enemyFound(chamber)) {
					fightEnemy(chamber);

				} else if (chamber[parisX][parisY] == 'H') {
					helenFound(chamber);
					return;
				}
				break;

			case "right":
				parisY++;
				if (parisY >= 5) {
					parisY--;

				} else if (enemyFound(chamber)) {
					fightEnemy(chamber);

				} else if (chamber[parisX][parisY] == 'H') {
					helenFound(chamber);
					return;
				}
				break;

			case "left":
				parisY--;
				if (parisY < 0) {
					parisY++;

				} else if (enemyFound(chamber)) {
					fightEnemy(chamber);

				} else if (chamber[parisX][parisY] == 'H') {
					helenFound(chamber);
					return;
				}
				break;
			}

			if (energy < 1) {
				System.out.printf("Paris died at %d;%d.%n", parisX, parisY);
				chamber[parisX][parisY] = 'X';
				return;
			}
			command = sc.nextLine().split(" ");
		}
	}

	private static boolean enemyFound(char[][] chamber) {
		if (chamber[parisX][parisY] == 'S') {
			return true;
		}
		return false;
	}

	private static void fightEnemy(char[][] chamber) {
		energy -= 2;
		if (energy < 1) {
			chamber[parisX][parisY] = 'X';
			return;
		}
		chamber[parisX][parisY] = '-';
	}

	private static void helenFound(char[][] chamber) {
		chamber[parisX][parisY] = '-';
		System.out.print("Paris has successfully abducted Helen! ");
		System.out.println("Energy left: " + energy);
	}

	private static void printChamber(char[][] chamber) {
		for (int x = 0; x < chamber.length; x++) {
			for (int y = 0; y < chamber[x].length; y++) {
				System.out.print(chamber[x][y]);
			}
			System.out.println();
		}
	}
}
