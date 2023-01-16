import java.util.Scanner;

public class MountainRun {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double record = Double.parseDouble(sc.nextLine());
		double distance = Double.parseDouble(sc.nextLine());
		double meterPerSec = Double.parseDouble(sc.nextLine());

		double slows = Math.floor(distance / 50) * 30;

		double time = meterPerSec * distance;

		time += slows;
		double timeDiff = Math.abs(record - time);

		if (time < record) {
			System.out.printf("Yes! The new record is %.2f seconds.", time);

		} else {
			System.out.printf("No! He was %.2f seconds slower.", timeDiff);
		}
		sc.close();
	}

}
