import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
	private static long threshold = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String barcodePattern = "([*]{2})[A-Z][a-z]{2,}([*]{2})|([:]{2})[A-Z][a-z]{2,}([:]{2})";
		Pattern regex = Pattern.compile(barcodePattern);

		List<String> emojis = new ArrayList<>();
		List<String> coolEmojis = new ArrayList<>();

		calculateThreshold(input);
		findEmojis(input, regex, emojis);
		findCoolEmojis(threshold, emojis, coolEmojis);
		printResult(threshold, emojis, coolEmojis);

		sc.close();
	}

	private static void findEmojis(String input, Pattern regex, List<String> emojis) {
		Matcher matcher = regex.matcher(input);
		while (matcher.find()) {
			emojis.add(matcher.group());
		}
	}

	private static void findCoolEmojis(long threshold, List<String> emojis, List<String> coolEmojis) {
		for (String e : emojis) {
			long sum = 0;
			for (int i = 2; i < e.length() - 2; i++) {
				long curr = e.charAt(i);
				sum += curr;
			}
			if (sum >= threshold) {
				coolEmojis.add(e);
			}
		}
	}

	private static void printResult(long threshold, List<String> emojis, List<String> coolEmojis) {
		System.out.println("Cool threshold: " + threshold);
		System.out.println(emojis.size() + " emojis found in the text. The cool ones are:");
		coolEmojis.stream().forEach(x -> System.out.println(x));
	}

	private static void calculateThreshold(String input) {
		for (int i = 0; i < input.length(); i++) {
			char currChar = input.charAt(i);
			if (Character.isDigit(currChar)) {
				threshold *= Character.getNumericValue(currChar);
			}
		}
	}
}
