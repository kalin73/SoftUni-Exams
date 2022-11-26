import java.util.Scanner;

public class SoftUniReception {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int emp1 = Integer.parseInt(sc.nextLine());
		int emp2 = Integer.parseInt(sc.nextLine());
		int emp3 = Integer.parseInt(sc.nextLine());

		int total = emp1 + emp2 + emp3;

		int students = sc.nextInt();
		int hours = 1;

		while (students > 0) {
			if (hours % 4 == 0) {
				hours++;
				continue;
			}

			students -= total;
			hours++;
		}
		System.out.printf("Time needed: %dh.", hours - 1);
		sc.close();
	}

}
