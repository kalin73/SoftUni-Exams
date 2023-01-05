import java.util.Scanner;

public class AddingBaggage {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double priceOver20kg = Double.parseDouble(sc.nextLine());
		double kg = Double.parseDouble(sc.nextLine());
		int days = Integer.parseInt(sc.nextLine());
		int numberOfBags = Integer.parseInt(sc.nextLine());

		double totalPrice = 0.0;

		if (kg < 10) {
			totalPrice = totalPrice + (priceOver20kg * 0.2);

		} else if (kg >= 10 && kg <= 20) {
			totalPrice = totalPrice + (priceOver20kg * 0.5);

		} else {
			totalPrice = priceOver20kg;

		}

		totalPrice = totalPrice * numberOfBags;

		if (days < 7) {
			totalPrice += totalPrice * 0.4;

		} else if (days >= 7 && days <= 30) {
			totalPrice += totalPrice * 0.15;

		} else {
			totalPrice += totalPrice * 0.1;

		}
		System.out.printf("The total price of bags is: %.2f lv.", totalPrice);
		sc.close();
	}

}
