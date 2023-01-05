import java.util.Scanner;

public class BestPlayer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int topScorrerGoals = Integer.MIN_VALUE;
		String nameOfTopScorrer = "";

		String name = sc.nextLine();

		while (!name.equals("END")) {
			int goals = Integer.parseInt(sc.nextLine());

			if (goals >= 10) {
				topScorrerGoals = goals;
				nameOfTopScorrer = name;
				break;
			}

			if (goals > topScorrerGoals) {
				topScorrerGoals = goals;
				nameOfTopScorrer = name;
			}

			name = sc.nextLine();
		}

		System.out.printf("%s is the best player!%n", nameOfTopScorrer);

		if (topScorrerGoals >= 3) {
			System.out.printf("He has scored %d goals and made a hat-trick !!!", topScorrerGoals);

		} else {
			System.out.printf("He has scored %d goals.", topScorrerGoals);

		}
		sc.close();
	}
}
