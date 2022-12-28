import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Man_O_War {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> pirateShip = Arrays.stream(sc.nextLine().split(">")).map(x -> Integer.parseInt(x))
				.collect(Collectors.toList());

		List<Integer> warship = Arrays.stream(sc.nextLine().split(">")).map(x -> Integer.parseInt(x))
				.collect(Collectors.toList());

		int maxHealth = Integer.parseInt(sc.nextLine());
		String[] commands = sc.nextLine().split(" ");

		while (!commands[0].equals("Retire")) {
			String command = commands[0];
			int dmg = 0;
			int hp = 0;

			switch (command) {
			case "Fire":
				int index = Integer.parseInt(commands[1]);
				dmg = Integer.parseInt(commands[2]);
				if (fire(warship, index, dmg)) {
					return;
				}
				break;

			case "Defend":
				int startIndex = Integer.parseInt(commands[1]);
				int endIndex = Integer.parseInt(commands[2]);
				dmg = Integer.parseInt(commands[3]);
				if (defend(pirateShip, startIndex, endIndex, dmg)) {
					return;
				}
				break;

			case "Repair":
				int indx = Integer.parseInt(commands[1]);
				hp = Integer.parseInt(commands[2]);
				repair(pirateShip, indx, hp, maxHealth);
				break;

			case "Status":
				status(pirateShip, maxHealth);
				break;
			}
			commands = sc.nextLine().split(" ");
		}
		int pirateStatus = pirateShip.stream().mapToInt(x -> x).sum();
		int warshipStatus = warship.stream().mapToInt(x -> x).sum();

		System.out.println("Pirate ship status: " + pirateStatus);
		System.out.println("Warship status: " + warshipStatus);
		sc.close();
	}

	private static boolean fire(List<Integer> warship, int index, int dmg) {

		if (index > -1 && index < warship.size()) {
			int section = warship.get(index);
			if (section - dmg <= 0) {
				System.out.println("You won! The enemy ship has sunken.");
				return true;
			}
			warship.set(index, section - dmg);

		}
		return false;
	}

	private static boolean defend(List<Integer> pirateShip, int startIndex, int endIndex, int dmg) {
		if (startIndex > -1 && startIndex < pirateShip.size() && endIndex > -1 && endIndex < pirateShip.size()) {
			for (int i = startIndex; i <= endIndex; i++) {
				if (pirateShip.get(i) - dmg <= 0) {
					System.out.println("You lost! The pirate ship has sunken.");
					return true;
				}
				pirateShip.set(i, pirateShip.get(i) - dmg);
			}
		}
		return false;

	}

	private static void repair(List<Integer> pirateShip, int index, int hp, int maxHp) {

		if (index > -1 && index < pirateShip.size()) {
			int section = pirateShip.get(index);

			if (section + hp > maxHp) {
				pirateShip.set(index, maxHp);

			} else {
				pirateShip.set(index, section + hp);
			}
		}
	}

	private static void status(List<Integer> pirateShip, int maxHp) {
		double minHp = maxHp * 0.2;
		int sections = 0;

		for (Integer i : pirateShip) {
			if (i < minHp) {
				sections++;
			}
		}
		System.out.println(sections + " sections need repair.");
	}
}
