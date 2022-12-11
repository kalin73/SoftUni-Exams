import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ComputerStore {
	private static final double DISCOUNT = 0.1;
	private static final double TAX = 0.2;
	private static double totalPriceWithoutTax;
	private static double totalPriceWithTax;
	private static double tax;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		List<Double> parts = new ArrayList<>();

		while (!"special".equals(input) && !"regular".equals(input)) {
			double price = Double.parseDouble(input);

			if (price < 1) {
				System.out.println("Invalid price!");
				input = sc.nextLine();
				continue;
			}
			parts.add(price);
			input = sc.nextLine();
		}

		addTax(parts);
		buy(parts, input);

		if (totalPriceWithTax < 1) {
			System.out.println("Invalid order!");
			sc.close();
			return;
		}
		printResult();
		sc.close();

	}

	private static void buy(List<Double> parts, String input) {
		if (input.equals("special")) {
			totalPriceWithTax = totalPriceWithTax - (totalPriceWithTax * DISCOUNT);
		}
	}

	private static void addTax(List<Double> parts) {
		totalPriceWithoutTax = parts.stream().mapToDouble(x -> x).sum();
		tax = totalPriceWithoutTax * TAX;
		totalPriceWithTax = totalPriceWithoutTax + tax;

	}

	private static void printResult() {
		System.out.printf("Congratulations you've just bought a new computer!%n");
		System.out.printf("Price without taxes: %.2f$%n", totalPriceWithoutTax);
		System.out.printf("Taxes: %.2f$%n", tax);
		System.out.printf("-----------%n");
		System.out.printf("Total price: %.2f$", totalPriceWithTax);

	}
}