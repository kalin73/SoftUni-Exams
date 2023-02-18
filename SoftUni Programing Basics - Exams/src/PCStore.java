import java.util.Scanner;

public class PCStore {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double totalPrice = 0.0;

		double levsFor1Dolar = 1.57;

		double cpu = Double.parseDouble(sc.nextLine());
		double gpu = Double.parseDouble(sc.nextLine());
		double ram = Double.parseDouble(sc.nextLine());

		int numbOfRams = Integer.parseInt(sc.nextLine());

		double discount = Double.parseDouble(sc.nextLine());

		cpu *= levsFor1Dolar;
		cpu -= cpu * discount;

		gpu *= levsFor1Dolar;
		gpu -= gpu * discount;

		ram = ram * numbOfRams * levsFor1Dolar;

		totalPrice = cpu + gpu + ram;
		System.out.printf("Money needed - %.2f leva.", totalPrice);

		sc.close();
	}

}
