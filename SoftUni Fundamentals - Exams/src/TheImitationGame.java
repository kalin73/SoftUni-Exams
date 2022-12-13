import java.util.Scanner;

public class TheImitationGame {
	private static StringBuilder message;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		message = new StringBuilder(sc.nextLine());
		String[] commands = sc.nextLine().split("\\|");

		while (!commands[0].equals("Decode")) {
			String command = commands[0];

			switch (command) {
			case "Move":
				move(commands);
				break;

			case "Insert":
				insert(commands);
				break;

			case "ChangeAll":
				changeAll(commands);
				break;
			}
			commands = sc.nextLine().split("\\|");
		}
		System.out.println("The decrypted message is: " + message);
		sc.close();
	}

	private static void move(String[] commands) {
		int letters = Integer.parseInt(commands[1]);
		String letterToMove = message.substring(0, letters);

		message.delete(0, letters);
		message.append(letterToMove);
	}

	private static void insert(String[] commands) {
		int index = Integer.parseInt(commands[1]);
		String value = commands[2];

		message.insert(index, value);
	}

	private static void changeAll(String[] commands) {
		String substring = commands[1];
		String replacement = commands[2];

		message = new StringBuilder(message.toString().replace(substring, replacement));
	}
}
