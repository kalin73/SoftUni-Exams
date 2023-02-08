import java.util.Scanner;

public class EasterParty {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numbOfGuests = Integer.parseInt(sc.nextLine());
		double priceForOnePerson = Double.parseDouble(sc.nextLine());
		double budget = Double.parseDouble(sc.nextLine());
		double cakePrice = budget * 0.1;

		double discount = 1.;

		if (numbOfGuests > 9 && numbOfGuests < 16) {
			discount = 0.85;

		} else if (numbOfGuests > 15 && numbOfGuests < 21) {
			discount = 0.8;
		} else if (numbOfGuests > 20) {
			discount = 0.75;
		}

		double totalPrice = numbOfGuests * priceForOnePerson * discount + cakePrice;

		if (totalPrice > budget) {
			System.out.printf("No party! %.2f leva needed.", totalPrice - budget);
		} else {
			System.out.printf("It is party time! %.2f leva left.", budget - totalPrice);
		}
		sc.close();
	}

}
