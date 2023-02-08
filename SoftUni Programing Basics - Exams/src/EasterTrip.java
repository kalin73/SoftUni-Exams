import java.util.Scanner;

public class EasterTrip {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String country = sc.nextLine();
		String date = sc.nextLine();
		int numbOfNights = Integer.parseInt(sc.nextLine());
		double price = 0.;

		switch (country) {
		case "France":
			if ("21-23".equals(date)) {
				price = 30.;
			} else if ("24-27".equals(date)) {
				price = 35.;
			} else if ("28-31".equals(date)) {
				price = 40.;
			}
			break;

		case "Italy":
			if ("21-23".equals(date)) {
				price = 28.;
			} else if ("24-27".equals(date)) {
				price = 32.;
			} else if ("28-31".equals(date)) {
				price = 39.;
			}
			break;

		case "Germany":
			if ("21-23".equals(date)) {
				price = 32.;
			} else if ("24-27".equals(date)) {
				price = 37.;
			} else if ("28-31".equals(date)) {
				price = 43.;
			}
			break;

		}
		price = price * numbOfNights;

		System.out.printf("Easter trip to %s : %.2f leva.", country, price);
		sc.close();
	}

}
