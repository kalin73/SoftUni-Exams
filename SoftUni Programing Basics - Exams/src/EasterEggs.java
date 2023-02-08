import java.util.Scanner;

public class EasterEggs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		int red = 0;
		int orange = 0;
		int blue = 0;
		int green = 0;

		int max = Integer.MIN_VALUE;
		String eggColor = "";

		while (n-- > 0) {
			String color = sc.nextLine();

			switch (color) {
			case "orange":
				orange++;
				if (orange > max) {
					max = orange;
					eggColor = "orange";
				}

				break;

			case "blue":
				blue++;
				if (blue > max) {
					max = blue;
					eggColor = "blue";
				}
				break;

			case "green":
				green++;
				if (green > max) {
					max = green;
					eggColor = "green";
				}
				break;

			case "red":
				red++;
				if (red > max) {
					max = red;
					eggColor = "red";
				}
				break;
			}
		}

		System.out.printf("Red eggs: %d%n", red);
		System.out.printf("Orange eggs: %d%n", orange);
		System.out.printf("Blue eggs: %d%n", blue);
		System.out.printf("Green eggs: %d%n", green);
		System.out.printf("Max eggs: %d -> %s", max, eggColor);
		sc.close();

	}

}
