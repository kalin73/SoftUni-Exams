import java.util.LinkedHashMap;
import java.util.Scanner;

public class Heroes_of_Code_and_LogicVII {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedHashMap<String, int[]> heroes = new LinkedHashMap<>();
		int n = Integer.parseInt(sc.nextLine());
		choseHeroes(sc, heroes, n);

		String[] commands = sc.nextLine().split(" - ");

		while (!commands[0].equals("End")) {
			String command = commands[0];

			switch (command) {
			case "CastSpell":
				castSpell(heroes, commands);
				break;

			case "TakeDamage":
				takeDmg(heroes, commands);
				break;

			case "Recharge":
				recharge(heroes, commands);
				break;

			case "Heal":
				heal(heroes, commands);
				break;

			}
			commands = sc.nextLine().split(" - ");
		}

		printResult(heroes);

	}

	private static void choseHeroes(Scanner sc, LinkedHashMap<String, int[]> heros, int n) {
		for (int i = 0; i < n; i++) {
			String[] hero = sc.nextLine().split(" ");
			int hp = Integer.parseInt(hero[1]);
			int mp = Integer.parseInt(hero[2]);
			heros.put(hero[0], new int[] { hp, mp });
		}
	}

	private static void castSpell(LinkedHashMap<String, int[]> heroes, String[] commands) {
		String heroName = commands[1];
		int mpNeeded = Integer.parseInt(commands[2]);
		String spellName = commands[3];

		int[] stats = heroes.get(heroName);
		int mp = stats[1];
		stats[1] = mp - mpNeeded;

		if (mpNeeded > mp) {
			System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);

		} else {
			System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, stats[1]);
			heroes.put(heroName, stats);
		}

	}

	private static void takeDmg(LinkedHashMap<String, int[]> heroes, String[] commands) {
		String heroName = commands[1];
		int dmg = Integer.parseInt(commands[2]);
		String attacker = commands[3];

		int[] stats = heroes.get(heroName);
		int hp = stats[0];
		stats[0] = hp - dmg;

		if (stats[0] > 0) {
			System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, dmg, attacker,
					stats[0]);
			heroes.put(heroName, stats);

		} else {
			System.out.printf("%s has been killed by %s!%n", heroName, attacker);
			heroes.remove(heroName);
		}
	}

	private static void recharge(LinkedHashMap<String, int[]> heroes, String[] commands) {
		String heroName = commands[1];
		int amount = Integer.parseInt(commands[2]);
		int recovered = 0;
		int[] stats = heroes.get(heroName);
		int mp = stats[1];
		stats[1] = mp + amount;

		if (stats[1] > 200) {
			recovered = 200 - mp;
			stats[1] = 200;
			heroes.put(heroName, stats);
			System.out.printf("%s recharged for %d MP!%n", heroName, recovered);
			return;

		}
		heroes.put(heroName, stats);
		System.out.printf("%s recharged for %d MP!%n", heroName, amount);
	}

	private static void heal(LinkedHashMap<String, int[]> heroes, String[] commands) {
		String heroName = commands[1];
		int amount = Integer.parseInt(commands[2]);
		int recovered = 0;
		int[] stats = heroes.get(heroName);
		int hp = stats[0];
		stats[0] = hp + amount;
		
		if (stats[0] > 100) {
			recovered = 100 - hp;
			stats[0] = 100;
			heroes.put(heroName, stats);
			System.out.printf("%s healed for %d HP!%n", heroName, recovered);
			return;

		}
		
		heroes.put(heroName, stats);
		System.out.printf("%s healed for %d HP!%n", heroName, amount);
	}

	private static void printResult(LinkedHashMap<String, int[]> heroes) {
		heroes.forEach((key, value) -> {
			System.out.println(key);
			System.out.println("  HP: " + value[0]);
			System.out.println("  MP: " + value[1]);
		});

	}

}