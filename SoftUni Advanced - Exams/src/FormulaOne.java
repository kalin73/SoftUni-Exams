import java.util.Scanner;

public class FormulaOne {
	private static int playerX;
	private static int playerY;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = Integer.parseInt(sc.nextLine());
		int numbOfCommands = Integer.parseInt(sc.nextLine());
		char[][] matrix = new char[size][size];

		fillMatrix(sc, matrix, size);
		findPlayer(matrix, size);

		for (int i = 0; i < numbOfCommands; i++) {
			String command = sc.nextLine();
			matrix[playerX][playerY] = '.';
			int oldPos = 0;

			switch (command) {
			case "up":
				oldPos = playerX;
				playerX--;
				if (!valid(size)) {
					playerX = size - 1;
				}
				if (matrix[playerX][playerY] == 'B') {
					playerX--;
					if (!valid(size)) {
						playerX = size - 1;
					}

				} else if (matrix[playerX][playerY] == 'T') {
					playerX = oldPos;
				}
				break;

			case "down":
				oldPos = playerX;
				playerX++;
				if (!valid(size)) {
					playerX = 0;
				}
				if (matrix[playerX][playerY] == 'B') {
					playerX++;
					if (!valid(size)) {
						playerX = 0;
					}

				} else if (matrix[playerX][playerY] == 'T') {
					playerX = oldPos;
				}
				break;

			case "right":
				oldPos = playerY;
				playerY++;
				if (!valid(size)) {
					playerY = 0;
				}
				if (matrix[playerX][playerY] == 'B') {
					playerY++;
					if (!valid(size)) {
						playerY = 0;
					}

				} else if (matrix[playerX][playerY] == 'T') {
					playerY = oldPos;
				}
				break;

			case "left":
				oldPos = playerY;
				playerY--;
				if (!valid(size)) {
					playerY = size - 1;
				}
				if (matrix[playerX][playerY] == 'B') {
					playerY--;
					if (!valid(size)) {
						playerY = size - 1;
					}

				} else if (matrix[playerX][playerY] == 'T') {
					playerY = oldPos;
				}
				break;
			}
			if (matrix[playerX][playerY] == 'F') {
				matrix[playerX][playerY] = 'P';
				System.out.println("Well done, the player won first place!");
				print(matrix, size);
				return;
			}
			matrix[playerX][playerY] = 'P';
		}
		System.out.println("Oh no, the player got lost on the track!");
		print(matrix, size);
	}

	private static void fillMatrix(Scanner sc, char[][] matrix, int size) {
		for (int row = 0; row < size; row++) {
			matrix[row] = sc.nextLine().toCharArray();
		}
	}

	private static void findPlayer(char[][] matrix, int size) {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				if (matrix[row][col] == 'P') {
					playerX = row;
					playerY = col;
				}
			}
		}
	}

	private static void print(char[][] matrix, int size) {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				System.out.print(matrix[row][col]);
			}
			System.out.println();
		}
	}

	private static boolean valid(int n) {
		if (playerX >= 0 && playerX < n && playerY >= 0 && playerY < n) {
			return true;
		}
		return false;
	}
}
