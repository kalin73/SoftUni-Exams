import java.util.Scanner;

public class BlackFlag {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int days = Integer.parseInt(sc.nextLine());
		int plunderPerDay = Integer.parseInt(sc.nextLine());
		double required = Integer.parseInt(sc.nextLine());
		double gathered = 0;

		for (int i = 1; i <= days; i++) {
			gathered += plunderPerDay;

			if (i % 3 == 0) {
				gathered += plunderPerDay * 0.5;
			}
			if (i % 5 == 0) {
				gathered = gathered - (gathered * 0.3);
			}

		}

		if (required > gathered) {
			double percentage = gathered * 100 / required;
			System.out.printf("Collected only %.2f%% of the plunder.", percentage);

		} else {
			System.out.printf("Ahoy! %.2f plunder gained.", gathered);
		}
		sc.close();
	}
}
