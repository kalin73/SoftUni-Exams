import java.util.Scanner;

public class AgencyProfit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		int aTickets = Integer.parseInt(sc.nextLine());
		int cTickets = Integer.parseInt(sc.nextLine());
		double aTicketsPrice = Double.parseDouble(sc.nextLine());
		double servicePrice = Double.parseDouble(sc.nextLine());

		double adultTicket = aTicketsPrice + servicePrice;
		double totalPriceForAdults = aTickets * adultTicket;

		double kidTicket = servicePrice + (aTicketsPrice - (aTicketsPrice * 0.7));
		double totalPriceForKids = cTickets * kidTicket;

		double totalProfit = (totalPriceForAdults + totalPriceForKids) * 0.2;

		System.out.printf("The profit of your agency from %s tickets is %.2f lv.", name, totalProfit);
		sc.close();

	}

}
