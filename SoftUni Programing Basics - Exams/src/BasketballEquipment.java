import java.util.Scanner;

public class BasketballEquipment {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int priceFor1Year = Integer.parseInt(sc.nextLine());

		double shoes = priceFor1Year - (priceFor1Year * 0.4);
		double kit = shoes - (shoes * 0.2);
		double ball = kit / 4;
		double accessories = ball / 5;

		double totalPrice = shoes + kit + ball + accessories + priceFor1Year;

		System.out.printf("%.2f", totalPrice);
		sc.close();
	}

}
