import java.util.Scanner;

public class GuineaPig {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double foodKg = Double.parseDouble(sc.nextLine()) * 1000;
		double hayKg = Double.parseDouble(sc.nextLine()) * 1000;
		double coverKg = Double.parseDouble(sc.nextLine()) * 1000;
		double weightKg = Double.parseDouble(sc.nextLine()) * 1000;

		final double COVER_QUANT = weightKg / 3;

		int days = 1;

		while (days < 31) {

			foodKg -= 300.0;

			if (days % 2 == 0) {
				hayKg -= foodKg * 0.05;
			}

			if (days % 3 == 0) {
				coverKg -= COVER_QUANT;
			}

			if (foodKg < 1.0 || hayKg < 1.0 || coverKg < 1.0) {
				System.out.println("Merry must go to the pet store!");
				sc.close();
				return;
			}
			days++;
		}

		System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.", foodKg / 1000,
				hayKg / 1000, coverKg / 1000);
		sc.close();
	}

}
