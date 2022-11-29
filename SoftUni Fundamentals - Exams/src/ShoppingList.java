import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> items = new ArrayList<>(Arrays.stream(sc.nextLine().split("!")).collect(Collectors.toList()));

		String[] command = sc.nextLine().split(" ");

		while (!command[0].equals("Go")) {

			switch (command[0]) {
			case "Urgent":
				if (!items.contains(command[1])) {
					items.add(0, command[1]);
				}
				break;

			case "Unnecessary":
				if (items.contains(command[1])) {
					items.remove(command[1]);
				}
				break;

			case "Correct":
				for (int i = 0; i < items.size(); i++) {
					if (items.get(i).equals(command[1])) {
						items.set(i, command[2]);
						break;
					}
				}
				break;

			case "Rearrange":
				for (int i = 0; i < items.size(); i++) {
					if (items.get(i).equals(command[1])) {
						items.add(items.size(), items.get(i));
						items.remove(i);
						break;
					}
				}
				break;

			}

			command = sc.nextLine().split(" ");
		}
		String shoppingList = items.stream().collect(Collectors.joining(", "));
		System.out.println(shoppingList);
		sc.close();
	}

}
