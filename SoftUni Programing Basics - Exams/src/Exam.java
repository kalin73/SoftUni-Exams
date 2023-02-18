import java.util.Scanner;

public class Exam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numbOfStudents = Integer.parseInt(sc.nextLine());

		double topStudentPercent = 0.0;
		double goodStudentsPercent = 0.0;
		double avgStudentsPercent = 0.0;
		double fail = 0.0;
		double avgGrade = 0.0;
		double totalGrade = 0.0;

		double topCounter = 0.0;
		double goodCounter = 0.0;
		double avgCounter = 0.0;
		double failCounter = 0.0;

		for (int i = 0; i < numbOfStudents; i++) {
			double grade = Double.parseDouble(sc.nextLine());
			totalGrade += grade;

			if (grade < 3.00) {
				failCounter++;

			} else if (grade > 2.99 && grade < 4.00) {
				avgCounter++;

			} else if (grade > 3.99 && grade < 5.00) {
				goodCounter++;

			} else if (grade > 4.99) {
				topCounter++;

			}

		}

		topStudentPercent = (topCounter / numbOfStudents) * 100.0;
		goodStudentsPercent = (goodCounter / numbOfStudents) * 100.0;
		avgStudentsPercent = (avgCounter / numbOfStudents) * 100.0;
		fail = (failCounter / numbOfStudents) * 100.0;

		avgGrade = totalGrade / numbOfStudents;

		System.out.printf("Top students: %.2f%%%n", topStudentPercent);
		System.out.printf("Between 4.00 and 4.99: %.2f%%%n", goodStudentsPercent);
		System.out.printf("Between 3.00 and 3.99: %.2f%%%n", avgStudentsPercent);
		System.out.printf("Fail: %.2f%%%n", fail);
		System.out.printf("Average: %.2f", avgGrade);
		
		sc.close();

	}

}
