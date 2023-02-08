import java.util.Scanner;

public class EasterLunch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numbOfKozunaci = Integer.parseInt(sc.nextLine());
		int eggBoxes = Integer.parseInt(sc.nextLine());
		int kgCookies = Integer.parseInt(sc.nextLine());

		int eggs = eggBoxes * 12;

		double kozinaciPrice = numbOfKozunaci * 3.2;
		double eggsPrice = eggBoxes * 4.35;
		double cookiesPrice = kgCookies * 5.4;
		double eggPaintPrice = eggs * 0.15;
		double totalPrice = kozinaciPrice + eggsPrice + cookiesPrice + eggPaintPrice;

		System.out.printf("%.2f", totalPrice);
		sc.close();

	}

}
