import java.util.Scanner;

public class ChangeBureau {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int bitcoins = Integer.parseInt(sc.nextLine());
		double yuan = Double.parseDouble(sc.nextLine());
		double commission = Double.parseDouble(sc.nextLine()) / 100;

		double bitcoinEuros = bitcoins * 1168 / 1.95;
		double yuanEuros = yuan * 0.15 * 1.76 / 1.95;

		double total = bitcoinEuros + yuanEuros;
		total = total - (total * commission);
		System.out.printf("%.2f", total);

		sc.close();
	}

}
