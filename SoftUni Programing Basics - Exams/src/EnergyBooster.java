import java.util.Scanner;

public class EnergyBooster {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fruit = sc.nextLine();
		String size = sc.nextLine();
		int numbOfOrders = Integer.parseInt(sc.nextLine());
		double discount = 1.;

		double price = 0.;

		switch (fruit) {
		case "Watermelon":
			price = size.equals("big") ? 5 * 28.7 * numbOfOrders : 2 * 56 * numbOfOrders;
			break;

		case "Pineapple":
			price = size.equals("big") ? 5 * 24.80 * numbOfOrders : 2 * 42.10 * numbOfOrders;
			break;

		case "Raspberry":
			price = size.equals("big") ? 5 * 15.20 * numbOfOrders : 2 * 20 * numbOfOrders;
			break;

		case "Mango":
			price = size.equals("big") ? 5 * 19.60 * numbOfOrders : 2 * 36.66 * numbOfOrders;
			break;

		}

		if (price > 399 && price <= 1000) {
			discount = 0.85;

		} else if (price > 1000) {
			discount = 0.5;
		}

		price = price * discount;
		System.out.printf("%.2f lv.", price);

		sc.close();
	}

}
