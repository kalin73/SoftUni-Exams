import java.util.Scanner;

public class SecretChat {
	private static StringBuilder message;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		message = new StringBuilder(sc.nextLine());
		String[] input = sc.nextLine().split(":\\|:");

		while (!input[0].equals("Reveal")) {
			String command = input[0];

			switch (command) {
			case "InsertSpace":
				int index = Integer.parseInt(input[1]);
				message.insert(index, " ");
				System.out.println(message);
				break;

			case "Reverse":
				reverse(input[1]);
				break;

			case "ChangeAll":
				String substring = input[1];
				String replacement = input[2];
				message = new StringBuilder(message.toString().replace(substring, replacement));
				System.out.println(message);
				break;
			}
			input = sc.nextLine().split(":\\|:");

		}
		System.out.println("You have a new text message: " + message);
		sc.close();

	}

	private static void reverse(String substring) {
		if (message.indexOf(substring)!=-1) {
			int startIndex = message.toString().indexOf(substring);
			int endIndex = startIndex + substring.length();
			StringBuilder substr = new StringBuilder(message.toString().substring(startIndex, endIndex));
			message.delete(startIndex, endIndex);
			substr.reverse();
			message.append(substr);
			System.out.println(message);

		} else {
			System.out.println("error");
		}
	}
}