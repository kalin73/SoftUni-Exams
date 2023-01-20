import java.util.Scanner;

public class SuitcasesLoad {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double capacity = Double.parseDouble(sc.nextLine());
		String command = sc.nextLine();

		int suitcaseCounter = 0;

		while (!"End".equals(command)) {
			double volume = Double.parseDouble(command);
			suitcaseCounter++;

			if (suitcaseCounter % 3 == 0) {
				volume *= 1.1;

			}
			if (volume > capacity) {
				System.out.println("No more space!");
				System.out.printf("Statistic: %d suitcases loaded.", suitcaseCounter - 1);
				sc.close();
				return;
			}

			capacity -= volume;
			command = sc.nextLine();
		}

		System.out.println("Congratulations! All suitcases are loaded!");
		System.out.printf("Statistic: %d suitcases loaded.", suitcaseCounter);
		sc.close();
	}

}
