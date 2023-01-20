import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class FitnessCard {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		BigDecimal money = new BigDecimal(sc.nextLine());
		char gender = sc.nextLine().charAt(0);
		int age = Integer.parseInt(sc.nextLine());
		String sport = sc.nextLine();

		BigDecimal sportPrice = new BigDecimal("0.0");

		switch (sport) {
		case "Gym":
			if (gender == 'm') {
				sportPrice = BigDecimal.valueOf(42);
			} else {
				sportPrice = BigDecimal.valueOf(35);
			}
			break;

		case "Boxing":
			if (gender == 'm') {
				sportPrice = BigDecimal.valueOf(41);
			} else {
				sportPrice = BigDecimal.valueOf(37);
			}
			break;

		case "Yoga":
			if (gender == 'm') {
				sportPrice = BigDecimal.valueOf(45);
			} else {
				sportPrice = BigDecimal.valueOf(42);
			}
			break;

		case "Zumba":
			if (gender == 'm') {
				sportPrice = BigDecimal.valueOf(34);
			} else {
				sportPrice = BigDecimal.valueOf(31);
			}
			break;

		case "Dances":
			if (gender == 'm') {
				sportPrice = BigDecimal.valueOf(51);
			} else {
				sportPrice = BigDecimal.valueOf(53);
			}
			break;

		case "Pilates":
			if (gender == 'm') {
				sportPrice = BigDecimal.valueOf(39);
			} else {
				sportPrice = BigDecimal.valueOf(37);
			}
			break;

		default:
			break;
		}
		if (age < 20) {
			sportPrice = sportPrice.multiply(BigDecimal.valueOf(0.8));
		}

		if (money.compareTo(sportPrice) >= 0) {
			System.out.printf("You purchased a 1 month pass for %s.", sport);
		} else {
			System.out.printf("You don't have enough money! You need $%s more.",
					sportPrice.subtract(money).setScale(2, RoundingMode.HALF_UP));
		}
		sc.close();
	}
}
