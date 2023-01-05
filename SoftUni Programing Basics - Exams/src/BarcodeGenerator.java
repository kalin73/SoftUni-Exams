import java.util.Scanner;

public class BarcodeGenerator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String min = sc.nextLine();
		String max = sc.nextLine();

		int min1 = Character.getNumericValue(min.charAt(0));
		int min2 = Character.getNumericValue(min.charAt(1));
		int min3 = Character.getNumericValue(min.charAt(2));
		int min4 = Character.getNumericValue(min.charAt(3));

		int max1 = Character.getNumericValue(max.charAt(0));
		int max2 = Character.getNumericValue(max.charAt(1));
		int max3 = Character.getNumericValue(max.charAt(2));
		int max4 = Character.getNumericValue(max.charAt(3));

		StringBuilder result = new StringBuilder();

		for (int i = min1; i <= max1; i++) {
			if (i % 2 == 0) {
				continue;
			}
			for (int j = min2; j <= max2; j++) {
				if (j % 2 == 0) {
					continue;
				}
				for (int k = min3; k <= max3; k++) {
					if (k % 2 == 0) {
						continue;
					}
					for (int l = min4; l <= max4; l++) {
						if (l % 2 == 0) {
							continue;
						}
						result.append(i + "" + j + "" + k + "" + l + " ");
					}
				}
			}
		}
		System.out.println(result);
		sc.close();
	}
}
