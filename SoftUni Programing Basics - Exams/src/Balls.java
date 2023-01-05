import java.util.Scanner;

public class Balls {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int red = 0;
		int orange = 0;
		int yellow = 0;
		int white = 0;
		int black = 0;
		int other = 0;

		int points = 0;

		for (int i = 0; i < n; i++) {
			String color = sc.nextLine();

			switch (color) {
			case "red":
				points += 5;
				red++;
				break;

			case "orange":
				points += 10;
				orange++;
				break;

			case "yellow":
				points += 15;
				yellow++;
				break;

			case "white":
				points += 20;
				white++;
				break;

			case "black":
				points = (int) Math.floor(points / 2);
				black++;
				break;

			default:
				other++;
				break;
			}
		}

		System.out.println("Total points: " + points);
		System.out.println("Red balls: " + red);
		System.out.println("Orange balls: " + orange);
		System.out.println("Yellow balls: " + yellow);
		System.out.println("White balls: " + white);
		System.out.println("Other colors picked: " + other);
		System.out.println("Divides from black balls: " + black);

		sc.close();

	}
}
