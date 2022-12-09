import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MirrorWords {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		List<String> pairs = new ArrayList<>();
		List<String> mirrorWords = new ArrayList<>();

		String regex = "([@#])(?<first>[A-Za-z]{3,})(\\1)(\\1)(?<second>[A-Za-z]{3,})(\\1)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);

		while (matcher.find()) {
			pairs.add(matcher.group());
			String word1 = matcher.group("first");
			StringBuilder word2 = new StringBuilder(matcher.group("second"));
			word2.reverse();

			if (word1.equals(word2.toString())) {
				mirrorWords.add(matcher.group());
			}
		}
		checkForPairs(pairs);
		checkForMirrorWords(mirrorWords);
		
		sc.close();
	}

	private static void checkForPairs(List<String> pairs) {
		if (pairs.size() == 0) {
			System.out.println("No word pairs found!");
			
		} else {
			System.out.printf("%d word pairs found!%n", pairs.size());
			
		}
	}

	private static void checkForMirrorWords(List<String> mirrorWords) {
		if (mirrorWords.size() == 0) {
			System.out.println("No mirror words!");
			
		} else {
			System.out.printf("The mirror words are:%n");
			String word = mirrorWords
					.stream()
					.map(x -> x.replaceAll("\\W", " ").trim().replaceAll("\\s+", " <=> "))
					.collect(Collectors.joining(", "));

			System.out.print(word);
		}
	}
}
