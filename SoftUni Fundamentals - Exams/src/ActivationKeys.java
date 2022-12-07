import java.util.Scanner;

public class ActivationKeys {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder key = new StringBuilder(sc.nextLine());

		String[] commands = sc.nextLine().split(">>>");

		while (!commands[0].equals("Generate")) {
			String command = commands[0];

			switch (command) {
			case "Contains":
				String substring = commands[1];
				if (key.toString().contains(substring)) {
					System.out.printf("%s contains %s%n", key, substring);
				} else {
					System.out.println("Substring not found!");
				}
				break;

			case "Flip":
				flip(key, commands);
				break;

			case "Slice":
				int startIndex = Integer.parseInt(commands[1]);
				int endIndex = Integer.parseInt(commands[2]);
				key.delete(startIndex, endIndex);
				System.out.println(key);
				break;
			}

			commands = sc.nextLine().split(">>>");
		}
		System.out.printf("Your activation key is: %s", key.toString());
		sc.close();
	}

	private static void flip(StringBuilder key, String[] commands) {
		String operation = commands[1];
		int startIndex = Integer.parseInt(commands[2]);
		int endIndex = Integer.parseInt(commands[3]);
		String subString = key.substring(startIndex, endIndex);

		if (operation.equals("Upper")) {
			subString = subString.toUpperCase();
			key.replace(startIndex, endIndex, subString);
			System.out.println(key.toString());
			return;
		}
		subString = subString.toLowerCase();
		key.replace(startIndex, endIndex, subString);

		System.out.println(key.toString());
	}
}
