import java.util.Scanner;

public class CatWalking {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int minsForWalk = Integer.parseInt(sc.nextLine());
		int numOfWalks = Integer.parseInt(sc.nextLine());
		int caloriesTaken = Integer.parseInt(sc.nextLine());

		int caloriesBurned = minsForWalk * numOfWalks * 5;

		if ((caloriesTaken / 2) > caloriesBurned) {
			System.out.println(
					"No, the walk for your cat is not enough. Burned calories per day: " + caloriesBurned + ".");
		} else {
			System.out
					.println("Yes, the walk for your cat is enough. Burned calories per day: " + caloriesBurned + ".");
		}
		sc.close();
	}

}
