import java.util.Scanner;

public class GameNumberWars {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String player1 = sc.nextLine();
		String player2 = sc.nextLine();

		int player1Points = 0;
		int player2Points = 0;

		String cards = sc.nextLine();

		while (!"End of game".equals(cards)) {
			int player1Card = Integer.parseInt(cards);
			int player2Card = Integer.parseInt(sc.nextLine());

			if (player1Card > player2Card) {
				player1Points += player1Card - player2Card;

			} else if (player1Card < player2Card) {
				player2Points += player2Card - player1Card;

			} else {
				player1Card = Integer.parseInt(sc.nextLine());
				player2Card = Integer.parseInt(sc.nextLine());

				if (player1Card > player2Card) {
					System.out.println("Number wars!");
					System.out.printf("%s is winner with %d points", player1, player1Points);
					sc.close();
					return;

				} else if (player1Card < player2Card) {
					System.out.println("Number wars!");
					System.out.printf("%s is winner with %d points", player2, player2Points);
					sc.close();
					return;
				}

			}
			cards = sc.nextLine();
		}
		System.out.printf("%s has %d points%n", player1, player1Points);
		System.out.printf("%s has %d points", player2, player2Points);
		sc.close();
	}

}
