import java.util.Scanner;

public class FoodForPets {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numbOfDays = Integer.parseInt(sc.nextLine());
		double foodQuant = Double.parseDouble(sc.nextLine());

		double dogFood = 0.;
		double catFood = 0.;
		double biscuits = 0.;
		double totalFoodEaten = 0.;
		double dailyFood = 0.;
		double totalBiscuits = 0.;

		for (int i = 1; i <= numbOfDays; i++) {
			int dog = Integer.parseInt(sc.nextLine());
			int cat = Integer.parseInt(sc.nextLine());
			dogFood += dog;
			catFood += cat;
			dailyFood = dog + cat;

			if (i % 3 == 0) {
				biscuits = dailyFood * 0.1;
				totalBiscuits += biscuits;
			}
			totalFoodEaten += dailyFood;
		}

		dogFood = dogFood * 100 / totalFoodEaten;
		catFood = 100 - dogFood;
		totalFoodEaten = totalFoodEaten * 100 / foodQuant;

		System.out.printf("Total eaten biscuits: %dgr.%n", Math.round(totalBiscuits));
		System.out.printf("%.2f%% of the food has been eaten.%n", totalFoodEaten);
		System.out.printf("%.2f%% eaten from the dog.%n", dogFood);
		System.out.printf("%.2f%% eaten from the cat.%n", catFood);

		sc.close();

	}

}
