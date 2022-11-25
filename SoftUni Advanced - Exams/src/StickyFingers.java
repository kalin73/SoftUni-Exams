import java.util.Scanner;

public class StickyFingers {
	private static int posX = 0;
	private static int posY = 0;
	private static int pocket = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		sc.nextLine();

		char[][] field = new char[size][size];

		String[] commands = sc.nextLine().split(",");
		setField(sc, field);
		findPosition(field);

		for (int i = 0; i < commands.length; i++) {
			String command = commands[i];
			switch (command) {

			case "up":
				if (posX - 1 < 0) {
					System.out.println("You cannot leave the town, there is police outside!");
				} else if (field[posX - 1][posY] == '$') {
					field[posX][posY] = '+';
					posX--;
					houseFound(field);
				} else if (field[posX - 1][posY] == 'P') {
					field[posX][posY] = '+';
					posX--;
					police(field);
					printField(field);
					return;

				} else {
					field[posX][posY] = '+';
					posX--;
					field[posX][posY] = 'D';
				}
				break;

			case "down":
				if (posX + 1 > size - 1) {
					System.out.println("You cannot leave the town, there is police outside!");

				} else if (field[posX + 1][posY] == '$') {
					field[posX][posY] = '+';
					posX++;
					houseFound(field);

				} else if (field[posX + 1][posY] == 'P') {
					field[posX][posY] = '+';
					posX++;
					police(field);
					printField(field);
					return;

				} else {
					field[posX][posY] = '+';
					posX++;
					field[posX][posY] = 'D';
				}
				break;

			case "left":
				if (posY - 1 < 0) {
					System.out.println("You cannot leave the town, there is police outside!");

				} else if (field[posX][posY - 1] == '$') {
					field[posX][posY] = '+';
					posY--;
					houseFound(field);

				} else if (field[posX][posY - 1] == 'P') {
					field[posX][posY] = '+';
					posY--;
					police(field);
					printField(field);
					return;

				} else {
					field[posX][posY] = '+';
					posY--;
					field[posX][posY] = 'D';

				}
				break;

			case "right":
				if (posY + 1 > size - 1) {
					System.out.println("You cannot leave the town, there is police outside!");

				} else if (field[posX][posY + 1] == '$') {
					field[posX][posY] = '+';
					posY++;
					houseFound(field);

				} else if (field[posX][posY + 1] == 'P') {
					field[posX][posY] = '+';
					posY++;
					police(field);
					printField(field);
					return;

				} else {
					field[posX][posY] = '+';
					posY++;
					field[posX][posY] = 'D';
				}
				break;

			}

		}
		System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", pocket);
		printField(field);

	}

	private static void setField(Scanner sc, char[][] field) {
		for (int i = 0; i < field.length; i++) {

			field[i] = sc.nextLine().replaceAll(" ", "").toCharArray();

		}
	}

	private static void findPosition(char[][] field) {
		for (int row = 0; row < field.length; row++) {
			for (int col = 0; col < field[0].length; col++) {
				if (field[row][col] == 'D') {
					posX = row;
					posY = col;
					return;
				}
			}
		}
	}

	private static void houseFound(char[][] field) {
		int money = posX * posY;
		pocket += money;
		field[posX][posY] = 'D';

		System.out.printf("You successfully stole %d$.%n", money);
	}

	private static void police(char[][] field) {
		System.out.printf("You got caught with %d$, and you are going to jail.%n", pocket);
		field[posX][posY] = '#';
	}

	private static void printField(char[][] field) {
		for (int x = 0; x < field.length; x++) {
			for (int y = 0; y < field[x].length; y++) {
				System.out.print(field[x][y] + " ");
			}
			System.out.println();
		}
	}
}
