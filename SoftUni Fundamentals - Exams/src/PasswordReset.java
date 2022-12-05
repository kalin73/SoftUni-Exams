import java.util.Scanner;

public class PasswordReset {
	private static StringBuilder newPass;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		newPass = new StringBuilder(sc.nextLine());
		String[] input = sc.nextLine().split(" ");

		while (!input[0].equals("Done")) {
			String command = input[0];

			switch (command) {
			case "TakeOdd":
				takeOdd();
				System.out.println(newPass);
				break;

			case "Cut":
				int index = Integer.parseInt(input[1]);
				int length = Integer.parseInt(input[2]);

				newPass.delete(index, index + length);
				System.out.println(newPass);
				break;

			case "Substitute":
				String substring = input[1];
				String substitute = input[2];
				substitute(substring, substitute);
				break;
			}
			input = sc.nextLine().split(" ");
		}
		System.out.println("Your password is: " + newPass);
		sc.close();
	}

	private static void takeOdd() {
		StringBuilder oldPass = new StringBuilder(newPass);
		newPass.delete(0, newPass.length());
		for (int i = 0; i < oldPass.length(); i++) {
			if (i % 2 != 0) {
				newPass.append(oldPass.charAt(i));
			}
		}
	}

	private static void substitute( String substring, String substitute) {
		if (newPass.toString().contains(substring)) {
			String newPassword = newPass.toString().replace(substring, substitute);
			newPass = new StringBuilder(newPassword);
			System.out.println(newPass);

		} else {
			System.out.println("Nothing to replace!");
		}
	}
}
