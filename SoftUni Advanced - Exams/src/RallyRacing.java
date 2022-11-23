import java.util.Scanner;

public class RallyRacing {
	private static int kmPassed = 0;
	private static int carPosX = 0;
	private static int carPosY = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		sc.nextLine();
		String number = sc.nextLine();

		char[][] raceRoute = new char[size][size];

		for (int row = 0; row < size; row++) {
			raceRoute[row] = sc.nextLine().replaceAll(" ", "").toCharArray();
		}

		String command = sc.nextLine();

		while (!"End".equals(command)) {

			switch (command) {
			case "up":
				if (carPosX - 1 >= 0) {
					carPosX--;
					if (raceRoute[carPosX][carPosY] == 'T') {
						fintTunelEnd(raceRoute);
						break;
					}
					kmPassed += 10;

				}
				break;

			case "down":
				if (carPosX + 1 < size) {
					carPosX++;
					if (raceRoute[carPosX][carPosY] == 'T') {
						fintTunelEnd(raceRoute);
						break;
					}
					kmPassed += 10;

				}
				break;

			case "right":
				if (carPosY + 1 < size) {
					carPosY++;
					if (raceRoute[carPosX][carPosY] == 'T') {
						fintTunelEnd(raceRoute);
						break;
					}
					kmPassed += 10;

				}
				break;

			case "left":
				if (carPosY - 1 >= 0) {
					carPosY--;
					if (raceRoute[carPosX][carPosY] == 'T') {
						fintTunelEnd(raceRoute);
						break;
					}
					kmPassed += 10;

				}
				break;
			}
			if (raceRoute[carPosX][carPosY] == 'F') {
				raceRoute[carPosX][carPosY] = 'C';
				System.out.printf("Racing car %s finished the stage!%n", number);
				System.out.printf("Distance covered %s km.%n", kmPassed);
				printRout(raceRoute);
				sc.close();
				return;
			}
			command = sc.nextLine();
		}

		raceRoute[carPosX][carPosY] = 'C';
		System.out.printf("Racing car %s DNF.%n", number);
		System.out.printf("Distance covered %s km.%n", kmPassed);
		printRout(raceRoute);

		sc.close();
	}

	private static void fintTunelEnd(char[][] raceRoute) {
		raceRoute[carPosX][carPosY] = '.';
		for (int x = carPosX; x < raceRoute.length; x++) {
			for (int y = 0; y < raceRoute[x].length; y++) {

				if (raceRoute[x][y] == 'T') {
					carPosX = x;
					carPosY = y;
					kmPassed += 30;
					raceRoute[carPosX][carPosY] = '.';
					return;
				}

			}

		}
	}

	private static void printRout(char[][] raceRoute) {

		for (int x = 0; x < raceRoute.length; x++) {
			for (int y = 0; y < raceRoute[x].length; y++) {
				System.out.print(raceRoute[x][y]);
			}
			System.out.println();
		}
	}
}
