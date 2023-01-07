import java.util.Scanner;

public class FitnessCenter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numbOfPeople = Integer.parseInt(sc.nextLine());

		int back = 0;
		int chest = 0;
		int legs = 0;
		int abs = 0;
		int proteineShake = 0;
		int proteineBar = 0;

		int workingOut = 0;

		for (int i = 0; i < numbOfPeople; i++) {
			String activity = sc.nextLine();

			switch (activity) {
			case "Back":
				back++;
				break;

			case "Chest":
				chest++;
				break;

			case "Legs":
				legs++;
				break;

			case "Abs":
				abs++;
				break;

			case "Protein shake":
				proteineShake++;
				break;

			case "Protein bar":
				proteineBar++;
				break;

			default:
				break;
			}
		}

		workingOut = back + chest + legs + abs;
		double result1 = workingOut * 100.0 / numbOfPeople;
		double result2 = 100.0 - result1;

		System.out.println(back + " - back");
		System.out.println(chest + " - chest");
		System.out.println(legs + " - legs");
		System.out.println(abs + " - abs");
		System.out.println(proteineShake + " - protein shake");
		System.out.println(proteineBar + " - protein bar");
		System.out.printf("%.2f%% - work out%n", result1);
		System.out.printf("%.2f%% - protein", Math.abs(result2));
		sc.close();

	}
}
