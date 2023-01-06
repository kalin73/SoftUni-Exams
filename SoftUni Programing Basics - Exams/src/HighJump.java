import java.util.Scanner;

public class HighJump {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int finalHeight = Integer.parseInt(sc.nextLine());

		int startingHeight = finalHeight - 30;
		int tries = 0;
		int failedTries = 0;

		while (true) {
			tries++;
			int jump = Integer.parseInt(sc.nextLine());

			if (jump > startingHeight) {
				if (startingHeight == finalHeight) {
					System.out.printf("Tihomir succeeded, he jumped over %dcm after %d jumps.", finalHeight, tries);
					sc.close();
					return;
				}
				startingHeight += 5;
				failedTries = 0;

			} else if (jump <= startingHeight) {
				failedTries++;
			}

			if (failedTries == 3) {
				System.out.printf("Tihomir failed at %dcm after %d jumps.", startingHeight, tries);
				sc.close();
				return;
			}
		}
	}
}
