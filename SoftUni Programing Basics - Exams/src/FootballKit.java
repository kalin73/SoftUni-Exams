import java.util.Scanner;

public class FootballKit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double discount = 0.85;
		double totalPrice = 0.0;

		double shirtPrice = Double.parseDouble(sc.nextLine());
		double sum = Double.parseDouble(sc.nextLine());

		double shortsPrice = shirtPrice * 0.75;
		double socksPrice = shortsPrice * 0.2;
		double shoes = (shirtPrice + shortsPrice) * 2;

		totalPrice = (shirtPrice + shortsPrice + socksPrice + shoes) * discount;
		
		
		if(totalPrice>=sum) {
			System.out.println("Yes, he will earn the world-cup replica ball!");
			System.out.printf("His sum is %.2f lv.",totalPrice);
			
		}else {
			double diff = sum - totalPrice;
			System.out.println("No, he will not earn the world-cup replica ball.");
			System.out.printf("He needs %.2f lv. more.",diff);
		}
		
		sc.close();
	}

}
