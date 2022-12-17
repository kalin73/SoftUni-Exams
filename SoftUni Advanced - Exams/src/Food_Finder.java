import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Food_Finder {
	private static ArrayDeque<String> vowels = new ArrayDeque<>();
	private static ArrayDeque<String> consonants = new ArrayDeque<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> words = new ArrayList<>(List.of("pear", "flour", "pork", "olive"));

		String[] vowelsInp = sc.nextLine().split(" ");
		String[] consonantsInp = sc.nextLine().split(" ");

		add(vowelsInp, consonantsInp);

		while (!consonants.isEmpty()) {
			String vowel = vowels.remove();
			String consonant = consonants.pop();
			words = words
					.stream()
					.map(s -> s.replace(vowel, vowel.toUpperCase()).replace(consonant, consonant.toUpperCase()))
					.collect(Collectors.toList());
			vowels.offer(vowel);
		}
		words = words.stream().filter(x -> x.equals(x.toUpperCase())).collect(Collectors.toList());

		System.out.println("Words found: " + words.size());
		words.forEach(x -> System.out.println(x.toLowerCase()));
		sc.close();

	}

	private static void add(String[] vowelsInp, String[] consonantsInp) {
		for (int i = 0; i < vowelsInp.length; i++) {
			vowels.offer(vowelsInp[i]);
		}

		for (int i = 0; i < consonantsInp.length; i++) {
			consonants.push(consonantsInp[i]);
		}
	}
}
