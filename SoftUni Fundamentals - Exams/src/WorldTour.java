import java.util.Scanner;

public class WorldTour {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder text = new StringBuilder(sc.nextLine());

		String[] command = sc.nextLine().split(":");

		while (!command[0].equals("Travel")) {

			switch (command[0]) {
			case "Add Stop":
				int index = Integer.parseInt(command[1]);

				if (index >= 0 && index < text.length()) {
					text.insert(index, command[2]);

				}
				System.out.println(text);
				break;

			case "Remove Stop":
				int startIndex = Integer.parseInt(command[1]);
				int endIndex = Integer.parseInt(command[2]) + 1;

				if (startIndex >= 0 && startIndex < text.length() && endIndex >= 0 && endIndex <= text.length()) {
					text.replace(startIndex, endIndex, "");

				}
				System.out.println(text);
				break;

			case "Switch":
				text = new StringBuilder(text.toString().replace(command[1], command[2]));
				System.out.println(text);
				break;
			}
			command = sc.nextLine().split(":");
		}
		System.out.println("Ready for world tour! Planned stops: " + text);
		sc.close();
	}

}
