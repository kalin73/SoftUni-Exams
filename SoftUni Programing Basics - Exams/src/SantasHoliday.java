import java.util.Scanner;

public class SantasHoliday {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double discout = 1.0;
		double priceForOneNight = 0.0;

		int days = Integer.parseInt(sc.nextLine());
		String place = sc.nextLine();
		String grade = sc.nextLine();

		switch (place) {
		case "room for one person":
			priceForOneNight = 18.0;
			break;

		case "apartment":
			priceForOneNight = 25.00;
			if (days < 10) {
				discout = 0.7;

			} else if (days > 9 && days <= 15) {
				discout = 0.65;

			} else if (days > 15) {
				discout = 0.5;
			}
			break;

		case "president apartment":
			priceForOneNight = 35.00;
			if (days < 10) {
				discout = 0.9;

			} else if (days > 9 && days <= 15) {
				discout = 0.85;

			} else if (days > 15) {
				discout = 0.80;
			}
			break;

		}
		double totalPrice = (days - 1) * priceForOneNight * discout;

		if ("positive".equals(grade)) {
			totalPrice *= 1.25;
		} else {
			totalPrice *= 0.9;
		}

		System.out.printf("%.2f", totalPrice);

		sc.close();
	}

}
