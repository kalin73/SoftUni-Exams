import java.util.Scanner;

public class MuOnline {
	private static int health = 100;
	private static int bitcoins = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] rooms = sc.nextLine().split("\\|");

		for (int i = 0; i < rooms.length; i++) {
			String[] commands = rooms[i].split(" ");
			String command = commands[0];
			int value = Integer.parseInt(commands[1]);

			switch (command) {
			case "potion":
				heal(commands);
				break;

			case "chest":
				bitcoins += value;
				System.out.printf("You found %d bitcoins.%n", value);
				break;

			default:
				health -= value;
				if (health < 1) {
					System.out.printf("You died! Killed by %s.%n", command);
					System.out.println("Best room: " + (i + 1));
					return;
				}

				System.out.printf("You slayed %s.%n", command);
				break;
			}

		}
		System.out.println("You've made it!");
		System.out.printf("Bitcoins: %d%n", bitcoins);
		System.out.printf("Health: %d", health);
		sc.close();

	}

	private static void heal(String[] commands) {
		int heal = Integer.parseInt(commands[1]);

		if (heal + health > 100) {		
			System.out.printf("You healed for %d hp.%n", 100 - health);
			health = 100;
		} else {
			health += heal;
			System.out.printf("You healed for %d hp.%n", heal);
		}

		System.out.printf("Current health: %d hp.%n", health);
	}
}
