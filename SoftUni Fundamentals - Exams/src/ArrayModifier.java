import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder result = new StringBuilder();
		int[] numbers = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		String[] command = sc.nextLine().split(" ");

		while (!command[0].equals("end")) {
			switch (command[0]) {

			case "swap":
				int indx1 = Integer.parseInt(command[1]);
				int indx2 = Integer.parseInt(command[2]);
				swap(numbers, indx1, indx2);
				break;

			case "multiply":
				indx1 = Integer.parseInt(command[1]);
				indx2 = Integer.parseInt(command[2]);
				numbers[indx1] = numbers[indx1] * numbers[indx2];
				break;

			case "decrease":
				for (int i = 0; i < numbers.length; i++) {
					numbers[i]--;
				}
				break;
			}
			command = sc.nextLine().split(" ");
		}
		for (int i : numbers) {
			result.append(i + ", ");
		}

		System.out.println(result.replace(result.length() - 2, result.length(), "").toString());
		sc.close();
	}

	private static void swap(int[] numbers, int index1, int index2) {
		int temp = numbers[index1];
		numbers[index1] = numbers[index2];
		numbers[index2] = temp;
	}

}
