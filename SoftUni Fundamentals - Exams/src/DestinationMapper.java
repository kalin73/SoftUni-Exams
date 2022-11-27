import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DestinationMapper {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int sum = 0;
		List<String> destinations = new ArrayList<>();

		for (int i = 0; i < input.length() - 1; i++) {
			if (input.charAt(i) == '=' && Character.isUpperCase(input.charAt(i + 1))) {

				for (int k = i + 1; k < input.length(); k++) {
					if (input.charAt(k) == '=' && k - i >= 4) {
						destinations.add(input.substring(i + 1, k));
						break;

					} else if (!Character.isLetter(input.charAt(k))) {
						i = k - 1;
						break;
					}
				}

			} else if (input.charAt(i) == '/' && Character.isUpperCase(input.charAt(i + 1))) {

				for (int k = i + 1; k < input.length(); k++) {

					if (input.charAt(k) == '/' && k - i >= 4) {
						destinations.add(input.substring(i + 1, k));
						break;

					} else if (!Character.isLetter(input.charAt(k))) {
						i = k - 1;
						break;
					}

				}

			}
		}
		System.out.printf("Destinations: %s%n",
				destinations.stream().map(String::valueOf).collect(Collectors.joining(", ")));

		for (String s : destinations) {
			sum += s.length();
		}

		System.out.println("Travel Points: " + sum);
		sc.close();
	}
}
