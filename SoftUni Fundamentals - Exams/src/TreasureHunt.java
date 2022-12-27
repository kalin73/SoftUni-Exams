import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> chest = Arrays.stream(sc.nextLine().split("\\|")).collect(Collectors.toList());
		String[] commands = sc.nextLine().split(" ");

		while (!commands[0].equals("Yohoho!")) {
			String command = commands[0];

			switch (command) {
			case "Loot":
				loot(commands, chest);
				break;

			case "Drop":
				int index = Integer.parseInt(commands[1]);
				if (chest.size() > index && index > -1) {
					chest.add(chest.size() - 1, chest.remove(index));
				}
				break;

			case "Steal":
				steal(commands, chest);
				break;
			}

			commands = sc.nextLine().split(" ");
		}
		if (chest.isEmpty()) {
			System.out.println("Failed treasure hunt.");

		} else {
			double averageGain = 0.0;
			for (String s : chest) {
				averageGain += s.length();

			}
			averageGain /= chest.size();
			System.out.printf("Average treasure gain: %.2f pirate credits.", averageGain);
		}
		sc.close();

	}

	private static void loot(String[] commands, List<String> chest) {
		for (int i = 1; i < commands.length; i++) {
			if (!chest.contains(commands[i])) {
				chest.add(0, commands[i]);
			}
		}
	}

	private static void steal(String[] commands, List<String> chest) {
		int count = Integer.parseInt(commands[1]);
		List<String> list = new ArrayList<>();
		String stolen = "";

		if (count >= chest.size()) {
			stolen = chest.stream().collect(Collectors.joining(", "));
			chest.clear();
		} else {
			while (count > 0) {
				int removeFrom = chest.size() - count;
				list.add(chest.remove(removeFrom));
				count--;
			}
			stolen = list.stream().collect(Collectors.joining(", "));
		}

		System.out.println(stolen);
	}
}
