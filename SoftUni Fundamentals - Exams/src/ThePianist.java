import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ThePianist {
	private static Map<String, String[]> paintings = new LinkedHashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		addPaints(sc, n);
		String[] input = sc.nextLine().split("\\|");

		while (!input[0].equals("Stop")) {
			String command = input[0];

			switch (command) {
			case "Add":
				add(input);
				break;

			case "Remove":
				remove(input);
				break;

			case "ChangeKey":
				changeKey(input);
				break;
			}

			input = sc.nextLine().split("\\|");
		}
		paintings.forEach((k, v) -> System.out.printf("%s -> Composer: %s, Key: %s%n", k, v[0], v[1]));
		sc.close();
	}

	private static void addPaints(Scanner sc, int n) {
		for (int i = 0; i < n; i++) {
			String[] input = sc.nextLine().split("\\|");
			String piece = input[0];
			String composer = input[1];
			String key = input[2];

			paintings.put(piece, new String[] { composer, key });
		}

	}

	private static void add(String[] input) {
		String piece = input[1];
		String composer = input[2];
		String key = input[3];

		if (paintings.containsKey(piece)) {
			System.out.printf("%s is already in the collection!%n", piece);
			return;
		}
		paintings.put(piece, new String[] { composer, key });
		System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
	}

	private static void remove(String[] input) {
		String piece = input[1];

		if (paintings.containsKey(piece)) {
			paintings.remove(piece);
			System.out.printf("Successfully removed %s!%n", piece);
			return;
		}

		System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);

	}

	private static void changeKey(String[] input) {
		String piece = input[1];
		String key = input[2];

		if (paintings.containsKey(piece)) {
			String[] arr = paintings.get(piece);
			arr[1] = key;
			paintings.put(piece, arr);
			System.out.printf("Changed the key of %s to %s!%n", piece, key);
			return;
		}

		System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);

	}

}
