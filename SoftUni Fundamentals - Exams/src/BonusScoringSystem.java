import java.util.Scanner;

public class BonusScoringSystem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int students = Integer.parseInt(sc.nextLine());
		int lecturers = Integer.parseInt(sc.nextLine());
		int bonus = Integer.parseInt(sc.nextLine());
		double totalBonus = 0.0;
		double highest = 0.0;
		double attendance = 0.0;

		for (int i = 0; i < students; i++) {
			attendance = Double.parseDouble(sc.nextLine());

			if (highest < attendance) {
				highest = attendance;
				totalBonus = attendance / lecturers * (5 + bonus);
			}

		}
		System.out.println("Max Bonus: " + (int) Math.ceil(totalBonus) + ".");
		System.out.printf("The student has attended %d lectures.", (int) highest);
		sc.close();
	}

}
