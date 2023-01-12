import java.util.Scanner;

public class CareOfPuppy {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalFoodQuant = Integer.parseInt(sc.nextLine());
		String dogFood = sc.nextLine();

		int foodEaten = 0;
		totalFoodQuant = totalFoodQuant * 1000;

		while (!"Adopted".equals(dogFood)) {
			int food = Integer.parseInt(dogFood);
			foodEaten += food;
			dogFood = sc.nextLine();
		}

		int leftOrNeeded = totalFoodQuant - foodEaten;

		if (totalFoodQuant < foodEaten) {
			System.out.printf("Food is not enough. You need %d grams more.", Math.abs(leftOrNeeded));
		} else {
			System.out.printf("Food is enough! Leftovers: %d grams.", leftOrNeeded);
		}
		sc.close();

	}

}
