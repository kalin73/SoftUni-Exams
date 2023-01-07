import java.util.Scanner;

public class Darts {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();

		
		int startingPoints = 301;
		int shots = 0;
		int unsuccessfulShots = 0;

		String sector = sc.nextLine();

		while (!"Retire".equals(sector)) {
			int points = Integer.parseInt(sc.nextLine());
			int multiplayer = 1;
			
			switch (sector) {
			case "Triple":
				multiplayer = 3;
				break;
			case "Double":
				multiplayer = 2;
				break;

			default:
				break;
			}
			int totalPoints = points * multiplayer;

			if (totalPoints <= startingPoints) {
				startingPoints -= totalPoints;
				shots++;

			} else {
				unsuccessfulShots++;
			}

			if (startingPoints == 0) {
				System.out.printf("%s won the leg with %d shots.", name, shots);
				sc.close();
				return;
			}

			sector = sc.nextLine();
		}

		if (startingPoints == 0) {
			System.out.printf("%s won the leg with %d shots.", name, shots);
		} else {
			System.out.printf("%s retired after %d unsuccessful shots.", name, unsuccessfulShots);
		}
		sc.close();
	}

}
