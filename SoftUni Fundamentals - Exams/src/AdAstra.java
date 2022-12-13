import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		int calories = 0;
		StringBuilder meals = new StringBuilder();

		String regex = "(?<symbols>[#\\|])(?<name>[A-za-z\\s]+)(\\1)(?<date>[0-9]{2}[\\/][0-9]{2}[\\/][0-9]{2})(\\1)(?<calories>[\\d]{1,5})(\\1)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);

		while (matcher.find()) {
			calories += Integer.parseInt(matcher.group("calories"));
			String meal = matcher.group("name");
			String date = matcher.group("date");
			String cals = matcher.group("calories");
			meals.append(String.format("Item: %s, Best before: %s, Nutrition: %s%n", meal, date, cals));
		}
		int days = calories / 2000;
		System.out.printf("You have food to last you for: %d days!%n", days);
		System.out.println(meals);
		sc.close();
	}

}
