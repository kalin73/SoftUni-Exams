import java.util.Scanner;

public class Skeleton {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int controlMin = Integer.parseInt(sc.nextLine());
		int controlSec = Integer.parseInt(sc.nextLine());
		double length = Double.parseDouble(sc.nextLine());
		int secFor100M = Integer.parseInt(sc.nextLine());

		double controlTime = controlMin * 60 + controlSec;

		double timeDecreases = length / 120.0;
		double decreasedTime = timeDecreases * 2.5;

		double MarinTime = (length / 100) * secFor100M - decreasedTime;

		if (controlTime >= MarinTime) {
			System.out.printf("Marin Bangiev won an Olympic quota!%nHis time is %.3f.", MarinTime);
		} else {
			double slower = MarinTime - controlTime;
			System.out.printf("No, Marin failed! He was %.3f second slower.", slower);
		}
		sc.close();
	}

}
