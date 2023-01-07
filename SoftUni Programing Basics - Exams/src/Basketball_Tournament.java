import java.util.Scanner;

public class Basketball_Tournament {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		int matchesPlayed = 0;
		int wins = 0;

		while (!"End of tournaments".equals(name)) {
			int numbOfMatches = Integer.parseInt(sc.nextLine());
			matchesPlayed += numbOfMatches;

			for (int i = 1; i <= numbOfMatches; i++) {
				int points1 = Integer.parseInt(sc.nextLine());
				int points2 = Integer.parseInt(sc.nextLine());

				if (points1 > points2) {
					System.out.printf("Game %d of tournament %s: win with %d points.%n", i, name, points1 - points2);
					wins++;

				} else if (points1 < points2) {
					System.out.printf("Game %d of tournament %s: lost with %d points.%n", i, name, points2 - points1);
				}

			}

			name = sc.nextLine();
		}
		double winPercentage = wins * 100.0 / matchesPlayed;
		double losePercentage = 100.0 - winPercentage;

		System.out.printf("%.2f%% matches win%n", winPercentage);
		System.out.printf("%.2f%% matches lost%n", Math.abs(losePercentage));
		sc.close();
	}

}
