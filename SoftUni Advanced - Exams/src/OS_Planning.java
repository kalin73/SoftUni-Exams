import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OS_Planning {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] tasks = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
		int[] threads = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		ArrayDeque<Integer> stack = new ArrayDeque<>();
		ArrayDeque<Integer> queue = new ArrayDeque<>();

		for (int i : tasks) {
			stack.push(i);
		}

		for (int i : threads) {
			queue.offer(i);
		}

		int task = Integer.parseInt(sc.nextLine());

		while (true) {

			int currThread = queue.peek();
			int currTask = stack.peek();

			if (currTask == task) {
				System.out.printf("Thread with value %d killed task %d%n", currThread, currTask);
				break;
			}

			if (currThread >= currTask) {
				queue.remove();
				stack.pop();

			} else {
				queue.remove();

			}

		}
		int size = queue.size();

		for (int i = 0; i < size; i++) {
			System.out.print(queue.remove() + " ");
		}
		sc.close();

	}

}
