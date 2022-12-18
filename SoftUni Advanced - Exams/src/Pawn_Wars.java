import java.util.Scanner;

public class Pawn_Wars {
	private static int wPownX;
	private static int wPownY;
	private static int bPownX;
	private static int bPownY;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] chessBoard = new char[8][8];
		String position = "";
		fillBoard(sc, chessBoard);
		findPowns(chessBoard);

		for (int i = 1; i < 20; i++) {
			if (i % 2 == 0) {
				chessBoard[bPownX][bPownY] = '-';
				
				if (checkForPown(bPownX + 1, bPownY + 1, chessBoard)) {
					position = (char) (bPownY + 1 + 97) + "" + (Math.abs(8 - (bPownX + 1)));
					System.out.printf("Game over! Black capture on %s.%n", position);
					break;

				} else if (checkForPown(bPownX + 1, bPownY - 1, chessBoard)) {
					position = (char) (bPownY - 1 + 97) + "" + (Math.abs(8 - (bPownX + 1)));
					System.out.printf("Game over! Black capture on %s.%n", position);
					break;

				} else {
					bPownX++;
					chessBoard[bPownX][bPownY] = 'b';

				}

			} else {
				chessBoard[wPownX][wPownY] = '-';
				if (checkForPown(wPownX - 1, wPownY + 1, chessBoard)) {
					position = (char) (wPownY + 1 + 97) + "" + (Math.abs(8 - (wPownX - 1)));
					System.out.printf("Game over! White capture on %s.", position);
					break;

				} else if (checkForPown(wPownX - 1, wPownY - 1, chessBoard)) {
					position = (char) (wPownY - 1 + 97) + "" + (Math.abs(8 - (wPownX - 1)));
					System.out.printf("Game over! White capture on %s.", position);
					break;

				} else {
					wPownX--;
					chessBoard[wPownX][wPownY] = 'w';

				}
			}
			if (wPownX == 0) {
				position = (char) (wPownY + 97) + "" + (8);
				System.out.printf("Game over! White pawn is promoted to a queen at %s.", position);
				break;

			} else if (bPownX == 7) {
				position = (char) (bPownY + 97) + "" + (1);
				System.out.printf("Game over! Black pawn is promoted to a queen at %s.", position);
				break;
			}

		}
	}

	private static void fillBoard(Scanner sc, char[][] chessBoard) {
		for (int row = 0; row < 8; row++) {
			chessBoard[row] = sc.nextLine().toCharArray();
		}
	}

	private static void findPowns(char[][] chessBoard) {
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (chessBoard[row][col] == 'w') {
					wPownX = row;
					wPownY = col;

				} else if (chessBoard[row][col] == 'b') {
					bPownX = row;
					bPownY = col;
				}
			}
		}
	}

	private static boolean valid(int x, int y) {
		if (x >= 0 && x < 8 && y >= 0 && y < 8) {
			return true;
		}
		return false;
	}

	private static boolean checkForPown(int x, int y, char[][] chessBoard) {
		if (valid(x, y) && chessBoard[x][y] != '-') {
			return true;
		}
		return false;
	}
}
