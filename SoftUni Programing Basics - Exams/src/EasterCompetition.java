import java.util.Scanner;

public class EasterCompetition {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int max = Integer.MIN_VALUE;
		String winner = "";

		for (int i = 0; i < n; i++) {
			String chefName = sc.nextLine();
			String points = sc.nextLine();

			int currentPoints = 0;

			while (!"Stop".equals(points)) {
				currentPoints += Integer.parseInt(points);
				points = sc.nextLine();
			}
			System.out.printf("%s has %d points.%n", chefName, currentPoints);

			if (currentPoints > max) {
				System.out.printf("%s is the new number 1!%n", chefName);
				max = currentPoints;
				winner = chefName;
			}

		}
		System.out.printf("%s won competition with %d points!", winner, max);
		sc.close();
	}

}
