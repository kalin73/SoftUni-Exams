import java.util.Scanner;

public class FootballResults {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int won = 0;
		int lost = 0;
		int draws = 0;

		for (int i = 0; i < 3; i++) {
			String result = sc.nextLine();
			int res1 = Character.getNumericValue(result.charAt(0));
			int res2 = Character.getNumericValue(result.charAt(2));

			if (res1 > res2) {
				won++;

			} else if (res1 < res2) {
				lost++;

			} else {
				draws++;
			}
		}
		System.out.println("Team won " + won + " games.");
		System.out.println("Team lost " + lost + " games.");
		System.out.println("Drawn games: " + draws);

		sc.close();
	}

}
