import java.util.Scanner;

public class Navy_Battle {
	private static int mineHits = 3;
	private static int submarineX = 0;
	private static int submarineY = 0;
	private static int cruisers = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String result = "";

		char[][] battlefield = new char[n][n];
		fillBattlefield(sc, battlefield, n);
		findSubmarine(battlefield, n);

		String command = sc.nextLine();

		while (true) {
			battlefield[submarineX][submarineY] = '-';

			switch (command) {
			case "up":
				submarineX--;
				break;

			case "down":
				submarineX++;
				break;

			case "left":
				submarineY--;
				break;

			case "right":
				submarineY++;
				break;

			default:
				break;
			}

			if (battlefield[submarineX][submarineY] == '*') {
				battlefield[submarineX][submarineY] = 'S';
				mineHits--;
				if (mineHits == 0) {
					result = String.format("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!",
							submarineX, submarineY);
					break;
				}

			} else if (battlefield[submarineX][submarineY] == 'C') {
				battlefield[submarineX][submarineY] = 'S';
				cruisers++;
				if (cruisers == 3) {
					result = "Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!";
					break;
				}
			}

			command = sc.nextLine();
		}
		System.out.println(result);
		print(battlefield, n);
		sc.close();
	}

	private static void fillBattlefield(Scanner sc, char[][] battlefield, int n) {
		for (int i = 0; i < n; i++) {
			battlefield[i] = sc.nextLine().toCharArray();
		}
	}

	private static void findSubmarine(char[][] battlefield, int n) {
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				if (battlefield[row][col] == 'S') {
					submarineX = row;
					submarineY = col;
				}
			}
		}
	}

	private static void print(char[][] battlefield, int n) {
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				System.out.print(battlefield[row][col]);
			}
			System.out.println();
		}
	}
}
