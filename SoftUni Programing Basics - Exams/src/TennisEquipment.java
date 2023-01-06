import java.util.Scanner;

public class TennisEquipment {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double priceForRacket = Double.parseDouble(sc.nextLine());
		int numbOfRackets = Integer.parseInt(sc.nextLine());
		int numbOfShoes = Integer.parseInt(sc.nextLine());

		double totalPrice = 0.;
		double shoesPrice = priceForRacket / 6;

		double totalShoePrice = numbOfShoes * shoesPrice;
		double totalRacketPrice = numbOfRackets * priceForRacket;
		totalPrice = totalRacketPrice + totalShoePrice;
		double otherPrice = totalPrice * 0.2;

		totalPrice += otherPrice;

		double priceForDjokovic = totalPrice / 8;
		double priceForSponsors = totalPrice / 8 * 7;

		System.out.println("Price to be paid by Djokovic " + (int) Math.floor(priceForDjokovic));
		System.out.println("Price to be paid by sponsors " + (int) Math.ceil(priceForSponsors));
		sc.close();
	}

}
