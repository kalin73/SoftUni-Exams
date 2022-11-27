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
			char currChar = input.charAt(i);

			if (currChar == '=' && Character.isUpperCase(input.charAt(i + 1))) {
				i = filter(input, i, currChar, destinations);

			} else if (currChar == '/') {
				i = filter(input, i, currChar, destinations);

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

	private static int filter(String input, int i, char currChar, List<String> destinations) {

		if (Character.isUpperCase(input.charAt(i + 1))) {

			for (int k = i + 1; k < input.length(); k++) {
				if (input.charAt(k) == currChar && k - i >= 4) {
					destinations.add(input.substring(i + 1, k));
					return k - 1;

				} else if (!Character.isLetter(input.charAt(k))) {
					return k - 1;

				}
			}
		}
		return i;
	}
}
