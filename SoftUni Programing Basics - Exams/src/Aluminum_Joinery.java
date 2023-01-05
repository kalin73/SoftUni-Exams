import java.util.Scanner;

public class Aluminum_Joinery {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = Integer.parseInt(sc.nextLine());
		String type = sc.nextLine();
		boolean delivery = sc.nextLine().equals("With delivery");
		double discount = 0.0;
		double price = 0.0;

		if (number < 10) {
			System.out.println("Invalid order");
			sc.close();
			return;
		}

		switch (type) {
		case "90X130":
			if (number > 60) {
				discount = 0.08;
			} else if (number > 30) {
				discount = 0.05;
			}
			price = 110;
			break;

		case "100X150":
			if (number > 80) {
				discount = 0.1;
			} else if (number > 40) {
				discount = 0.06;
			}
			price = 140;
			break;

		case "130X180":
			if (number > 50) {
				discount = 0.12;
			} else if (number > 20) {
				discount = 0.07;
			}
			price = 190;
			break;

		case "200X300":
			if (number > 50) {
				discount = 0.14;
			} else if (number > 25) {
				discount = 0.09;
			}
			price = 250;
			break;

		default:
			break;
		}

		double totalPrice = number * (price - (price * discount));

		if (delivery) {
			totalPrice += 60;
		}
		if (number > 99) {
			totalPrice = totalPrice - (totalPrice * 0.04);
		}

		System.out.printf("%.2f BGN", totalPrice);
		sc.close();

	}

}
