import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Climb_The_Peaks {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayDeque<Integer> dailyPortions = Arrays.stream(sc.nextLine().split(", ")).map(x -> Integer.parseInt(x))
				.collect(Collectors.toCollection(ArrayDeque::new));

		ArrayDeque<Integer> dailyStamina = Arrays.stream(sc.nextLine().split(", ")).map(x -> Integer.parseInt(x))
				.collect(Collectors.toCollection(ArrayDeque::new));

		Map<Integer, String> peaks = new LinkedHashMap<>();
		peaks.put(80, "Vihren");
		peaks.put(90, "Kutelo");
		peaks.put(100, "Banski Suhodol");
		peaks.put(60, "Polezhan");
		peaks.put(70, "Kamenitza");

		List<String> peaksClimbed = new ArrayList<>();

		for (int i = 0; i < 7; i++) {
			int portion = dailyPortions.removeLast();
			int stamina = dailyStamina.removeFirst();
			int sum = portion + stamina;

			for (Integer key : peaks.keySet()) {
				if (sum >= key) {
					peaksClimbed.add(peaks.remove(key));
				}
				break;
			}
			if (peaks.isEmpty()) {
				System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
				System.out.println("Conquered peaks:");
				peaksClimbed.forEach(x -> System.out.println(x));
				sc.close();
				return;
			}
		}

		System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
		if (!peaksClimbed.isEmpty()) {
			System.out.println("Conquered peaks:");
			peaksClimbed.forEach(x -> System.out.println(x));
		}
		sc.close();
	}

}
