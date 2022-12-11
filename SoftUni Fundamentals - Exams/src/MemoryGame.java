import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> memory = Arrays.stream(sc.nextLine().split(" ")).collect(Collectors.toList());
		String[] indices = sc.nextLine().split(" ");
		int moves = 0;

		while (!indices[0].equals("end")) {

			
			moves++;
			int index1 = Integer.parseInt(indices[0]);
			int index2 = Integer.parseInt(indices[1]);

			if (verifyIndices(index1, index2, memory)) {
				remove(index1, index2, memory);

			} else {
				add(memory, moves);
			}
			if (memory.size() == 0) {
				System.out.printf("You have won in %d turns!%n", moves);
				sc.close();
				return;
			}
			indices = sc.nextLine().split(" ");
		}
		System.out.println("Sorry you lose :(");
		memory.stream().forEach(x -> System.out.print(x + " "));
		sc.close();
	}

	private static boolean verifyIndices(int index1, int index2, List<String> memory) {
		int length = memory.size() - 1;

		if ((index1 < 0 || index1 > length) || (index2 < 0 || index2 > length) || (index1 == index2)) {
			return false;
		}
		return true;

	}

	private static void remove(int index1, int index2, List<String> memory) {
		String element = memory.get(index1);
		if (element.equals(memory.get(index2))) {
			System.out.printf("Congrats! You have found matching elements - %s!%n", element);

			if (index1 > index2) {
				memory.remove(index1);
				memory.remove(index2);
				return;
			}
			memory.remove(index2);
			memory.remove(index1);

		} else {
			System.out.println("Try again!");
		}

	}

	private static void add(List<String> memory, int moves) {
		System.out.println("Invalid input! Adding additional elements to the board");
		int middle = memory.size() / 2;
		memory.add(middle, "-" + moves + "a");
		memory.add(middle, "-" + moves + "a");
	}
}
