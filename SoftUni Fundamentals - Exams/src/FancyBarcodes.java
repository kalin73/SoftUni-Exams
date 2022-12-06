import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String barcodePattern = "^@#+(?=[A-Z])([A-Za-z0-9]{6,})(?<=[A-Z])@#+$";
		Pattern pattern = Pattern.compile(barcodePattern);
		StringBuilder productGroup = null;

		for (int i = 0; i < n; i++) {
			String code = sc.nextLine();
			Matcher matcher = pattern.matcher(code);
			productGroup = new StringBuilder();

			if (matcher.matches()) {

				for (int c = 0; c < code.length(); c++) {

					if (Character.isDigit(code.charAt(c))) {
						productGroup.append(code.charAt(c));
					}
				}
			} else {
				System.out.println("Invalid barcode");
				continue;
			}

			if (productGroup.length() > 0) {
				System.out.println("Product group: " + productGroup);

			} else {
				System.out.println("Product group: 00");
			}
		}

		sc.close();
	}

}
