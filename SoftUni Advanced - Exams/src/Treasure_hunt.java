
import java.util.Scanner;

public class Treasure_hunt {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder path = new StringBuilder();
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		sc.nextLine();

		char[][] treasureMap = new char[rows][cols];

		for (int row = 0; row < rows; row++) {
			treasureMap[row] = sc.nextLine().replaceAll(" ", "").toCharArray();
		}
		int[] position = findPosition(treasureMap);
		int x = position[0];
		int y = position[1];

		String command = sc.nextLine();

		while (!"Finish".equals(command)) {

			switch (command) {
			case "up":
				if (x - 1 >= 0 && treasureMap[x - 1][y] != 'T') {
					treasureMap[x][y] = '-';
					x--;
					path.append(command + ", ");
				}
				break;

			case "down":
				if (x + 1 < rows && treasureMap[x + 1][y] != 'T') {
					treasureMap[x][y] = '-';
					x++;
					path.append(command + ", ");
				}
				break;

			case "right":
				if (y + 1 < cols && treasureMap[x][y + 1] != 'T') {
					treasureMap[x][y] = '-';
					y++;
					path.append(command + ", ");
				}
				break;

			case "left":
				if (y - 1 >= 0 && treasureMap[x][y - 1] != 'T') {
					treasureMap[x][y] = '-';
					y--;
					path.append(command + ", ");
				}
				break;
			}

			command = sc.nextLine();
		}
		printResult(treasureMap, x, y, path);
		sc.close();

	}

	private static int[] findPosition(char[][] treasureMap) {
		int[] position = new int[2];
		for (int x = 0; x < treasureMap.length; x++) {
			for (int y = 0; y < treasureMap[x].length; y++) {

				if (treasureMap[x][y] == 'Y') {
					position[0] = x;
					position[1] = y;
				}

			}
		}
		return position;
	}

	private static void printResult(char[][] treasureMap, int x, int y, StringBuilder path) {
		if (treasureMap[x][y] == 'X') {
			System.out.println("I've found the treasure!");
			path.replace(path.length() - 2, path.length(), "");
			System.out.println("The right path is " + path);
			return;
		}
		System.out.println("The map is fake!");
	}
}
