import java.util.Scanner;

public class Substitute {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = Integer.parseInt(sc.nextLine());
		int l = Integer.parseInt(sc.nextLine());
		int m = Integer.parseInt(sc.nextLine());
		int n = Integer.parseInt(sc.nextLine());
		String firstPlayer = "";
		String secondPlayer = "";
		int subs = 0;

		for (int a = k; a <= 8; a++) {
			if (a % 2 == 0) {
				for (int b = 9; b >= l; b--) {
					if (b % 2 != 0) {
						for (int c = m; c <= 8; c++) {
							if (c % 2 == 0) {
								for (int d = 9; d >= n; d--) {
									if (d % 2 != 0) {
										firstPlayer = a + "" + b;
										secondPlayer = c + "" + d;

										if (firstPlayer.equals(secondPlayer)) {
											System.out.println("Cannot change the same player.");
										} else {
											System.out.println(firstPlayer + " - " + secondPlayer);
											subs++;
										}
										if (subs == 6) {
											sc.close();
											return;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		sc.close();
	}
	
}
