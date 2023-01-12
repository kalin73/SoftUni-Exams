import java.util.Scanner;

public class BirthdayParty {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double rent = Double.parseDouble(sc.nextLine());

		double cake = rent * 0.2;
		double drinks = cake * 0.55;
		double animator = rent / 3;

		double sum = cake + drinks + animator + rent;

		System.out.println(sum);
		sc.close();

	}

}
