import java.util.Scanner;

public class World_Snooker_Championship {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String stage = sc.nextLine();
		String ticketType = sc.nextLine();
		int ticketCount = Integer.parseInt(sc.nextLine());
		char pic = sc.nextLine().charAt(0);

		double priceForOne = 0.;

		switch (stage) {
		case "Final":
			if ("Standard".equals(ticketType)) {
				priceForOne = 110.10;

			} else if ("Premium".equals(ticketType)) {
				priceForOne = 160.66;

			} else {
				priceForOne = 400;
			}
			break;

		case "Semi final":
			if ("Standard".equals(ticketType)) {
				priceForOne = 75.88;

			} else if ("Premium".equals(ticketType)) {
				priceForOne = 125.22;

			} else {
				priceForOne = 300.40;
			}
			break;

		case "Quarter final":
			if ("Standard".equals(ticketType)) {
				priceForOne = 55.50;

			} else if ("Premium".equals(ticketType)) {
				priceForOne = 105.20;

			} else {
				priceForOne = 118.90;
			}
			break;

		default:
			break;
		}
		double totalPrice = priceForOne * ticketCount;

		if (totalPrice > 4000) {
			totalPrice = totalPrice - (totalPrice * 0.25);
			System.out.printf("%.2f", totalPrice);
			sc.close();
			return;

		} else if (totalPrice > 2500) {
			totalPrice = totalPrice - (totalPrice * 0.1);

		}

		if (pic == 'Y') {
			totalPrice += 40 * ticketCount;
		}
		System.out.printf("%.2f", totalPrice);
		sc.close();
	}

}
