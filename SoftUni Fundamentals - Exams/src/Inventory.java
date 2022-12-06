import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> items = Arrays.stream(sc.nextLine().split(", ")).collect(Collectors.toList());
		String[] command = sc.nextLine().split(" - ");

		while (!command[0].equals("Craft!")) {

			switch (command[0]) {
			case "Collect":
				if (!items.contains(command[1])) {
					items.add(command[1]);
				}
				break;

			case "Drop":
				items.remove(command[1]);
				break;

			case "Combine Items":
				combine(items, command);
				break;

			case "Renew":
				renew(items, command);
				break;
			}
			command = sc.nextLine().split(" - ");
		}
		String result = items.stream().collect(Collectors.joining(", "));
		System.out.println(result);
		sc.close();
	}

	private static void combine(List<String> items, String[] command) {
		String[] item = command[1].split(":");
		String oldItem = item[0];
		String newItem = item[1];

		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).equals(oldItem)) {
				if (i < items.size() - 1) {
					items.add(i + 1, newItem);
					return;
				}
				items.add(newItem);
			}
		}
	}

	private static void renew(List<String> items, String[] command) {
		String item = command[1];

		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).equals(item)) {
				items.remove(item);
				items.add(items.size(), item);
				return;
			}
		}
	}
}
