import java.util.Scanner;

public class TennisRanklist {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double n = Double.parseDouble(sc.nextLine());
		int startingPoints = Integer.parseInt(sc.nextLine());

		int finalPoints = 0;
		double wins = 0;
		double avrgPointsPerTour = 0;

		for (int i = 0; i < n; i++) {
			String position = sc.nextLine();

			switch (position) {
			case "W":
				wins++;
				finalPoints += 2000;
				break;

			case "F":
				finalPoints += 1200;
				break;

			case "SF":
				finalPoints += 720;
				break;

			default:
				break;
			}
		}
		avrgPointsPerTour = finalPoints / n;
		finalPoints += startingPoints;
		double winPercentage = wins * 100 / n;

		System.out.println("Final points: " + finalPoints);
		System.out.println("Average points: " + (int) Math.floor(avrgPointsPerTour));
		System.out.printf("%.2f%%", winPercentage);

		sc.close();
	}

}
