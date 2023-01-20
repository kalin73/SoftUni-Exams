import java.util.Scanner;

public class TrekkingMania {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		double musala = 0.;
		double monblan = 0.;
		double kilimanjaro = 0.;
		double k2 = 0.;
		double everest = 0.;

		double totalClimbers = 0.;

		while (n-- > 0) {
			int people = Integer.parseInt(sc.nextLine());
			totalClimbers += people;

			if (people < 6) {
				musala += people;

			} else if (people < 13) {
				monblan += people;

			} else if (people < 26) {
				kilimanjaro += people;

			} else if (people < 41) {
				k2 += people;

			} else {
				everest += people;

			}
		}

		musala = musala * 100 / totalClimbers;
		monblan = monblan * 100 / totalClimbers;
		kilimanjaro = kilimanjaro * 100 / totalClimbers;
		k2 = k2 * 100 / totalClimbers;
		everest = everest * 100 / totalClimbers;

		System.out.printf("%.2f%%%n", musala);
		System.out.printf("%.2f%%%n", monblan);
		System.out.printf("%.2f%%%n", kilimanjaro);
		System.out.printf("%.2f%%%n", k2);
		System.out.printf("%.2f%%", everest);

		sc.close();
	}
}
