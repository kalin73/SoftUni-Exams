import java.util.Scanner;

public class Phyton {
	private static int x;
	private static int y;
	private static int length = 1;
	private static int foodLeft = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = Integer.parseInt(sc.nextLine());
		String[] commands = sc.nextLine().split(", ");

		char[][] screen = new char[size][size];

		for (int row = 0; row < size; row++) {
			screen[row] = sc.nextLine().replace(" ", "").toCharArray();
		}
		findSnake(screen);
		sc.close();

		for (int i = 0; i < commands.length; i++) {
			String command = commands[i];

			switch (command) {
			case "up":
				x--;
				if (x < 0) {
					x = size - 1;
				}

				checkForFood(screen);
				break;

			case "down":
				x++;
				if (x > size - 1) {
					x = 0;
				}
				checkForFood(screen);
				break;

			case "right":
				y++;
				if (y > size - 1) {
					y = 0;
				}
				checkForFood(screen);
				break;

			case "left":
				y--;
				if (y < 0) {
					y = size - 1;
				}

				checkForFood(screen);
				break;
			}

			if (screen[x][y] == 'e') {
				System.out.println("You lose! Killed by an enemy!");
				return;
				
			} else if (foodEaten(screen)) {
				System.out.printf("You win! Final python length is %d", length);
				return;
			}
		}
		System.out.printf("You lose! There is still %d food to be eaten.", foodLeft);
		
	}

	private static void findSnake(char[][] screen) {

		for (int row = 0; row < screen.length; row++) {
			for (int col = 0; col < screen[0].length; col++) {
				if (screen[row][col] == 's') {
					x = row;
					y = col;

				} else if (screen[row][col] == 'f') {
					foodLeft++;
				}
			}
		}

	}

	private static void checkForFood(char[][] screen) {
		if (screen[x][y] == 'f') {
			length++;
			screen[x][y] = '*';
			foodLeft--;
		}
	}

	private static boolean foodEaten(char[][] screen) {

		if (foodLeft == 0) {
			return true;
		}
		return false;

	}

}
