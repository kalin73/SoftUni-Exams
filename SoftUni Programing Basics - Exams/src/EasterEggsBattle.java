import java.util.Scanner;

public class EasterEggsBattle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int playerOneEggs = Integer.parseInt(sc.nextLine());
		int playerTwoEggs = Integer.parseInt(sc.nextLine());

		String command = sc.nextLine();

		while (!"End".equals(command)) {
			switch (command) {
			case "one":
				playerTwoEggs--;
				break;

			case "two":
				playerOneEggs--;
				break;
			}

			if (playerOneEggs == 0) {
				System.out.printf("Player one is out of eggs. Player two has %d eggs left.", playerTwoEggs);
				sc.close();
				return;

			} else if (playerTwoEggs == 0) {
				System.out.printf("Player two is out of eggs. Player one has %d eggs left.", playerOneEggs);
				sc.close();
				return;

			}

			command = sc.nextLine();
		}
		System.out.printf("Player one has %d eggs left.%n", playerOneEggs);
		System.out.printf("Player two has %d eggs left.", playerTwoEggs);
		sc.close();
	}

}
