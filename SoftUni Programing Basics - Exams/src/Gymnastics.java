import java.util.Scanner;

public class Gymnastics {

	public static void main(String[] args) {
		final int MAX_POINTS = 20;

		Scanner sc = new Scanner(System.in);
		String country = sc.nextLine();
		String instrument = sc.nextLine();

		double pointsForHardnes = 0.;
		double pointsForExecution = 0.;

		double totalPoints = 0.;
		double percentLeftToMax = 0.;

		if ("Russia".equals(country)) {
			switch (instrument) {
			case "ribbon":
				pointsForHardnes = 9.100;
				pointsForExecution = 9.400;
				break;

			case "hoop":
				pointsForHardnes = 9.300;
				pointsForExecution = 9.800;
				break;

			case "rope":
				pointsForHardnes = 9.600;
				pointsForExecution = 9.000;
				break;

			default:
				break;
			}

		} else if ("Bulgaria".equals(country)) {
			switch (instrument) {
			case "ribbon":
				pointsForHardnes = 9.600;
				pointsForExecution = 9.400;
				break;

			case "hoop":
				pointsForHardnes = 9.550;
				pointsForExecution = 9.750;
				break;

			case "rope":
				pointsForHardnes = 9.500;
				pointsForExecution = 9.400;
				break;

			default:
				break;
			}

		} else if ("Italy".equals(country)) {

			switch (instrument) {
			case "ribbon":
				pointsForHardnes = 9.200;
				pointsForExecution = 9.500;
				break;

			case "hoop":
				pointsForHardnes = 9.450;
				pointsForExecution = 9.350;
				break;

			case "rope":
				pointsForHardnes = 9.700;
				pointsForExecution = 9.150;
				break;

			default:
				break;
			}
		}
		totalPoints = pointsForHardnes + pointsForExecution;
		percentLeftToMax = 100 - (totalPoints * 100 / MAX_POINTS);

		System.out.printf("The team of %s get %.3f on %s.%n", country, totalPoints, instrument);
		System.out.printf("%.2f%%", percentLeftToMax);
		sc.close();
	}

}
