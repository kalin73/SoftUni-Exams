package workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {
	private String type;
	private int exerciseCount;
	private List<Exercise> exercises;

	public Workout(String type, int exerciseCount) {
		this.type = type;
		this.exerciseCount = exerciseCount;
		this.exercises = new ArrayList<>();
	}

	public void addExercise(Exercise exercise) {
		if (exercises.size() < exerciseCount) {
			exercises.add(exercise);
		}
	}

	public boolean removeExercise(String name, String muscle) {
		return exercises.removeIf(x -> x.getName().equals(name) && x.getMuscle().equals(muscle));
	}

	public Exercise getExercise(String name, String muscle) {
		for (Exercise e : exercises) {
			if (e.getName().equals(name) && e.getMuscle().equals(muscle)) {
				return e;
			}
		}
		return null;
	}

	public Exercise getMostBurnedCaloriesExercise() {
		Exercise most = null;
		for (Exercise ex : exercises) {
			if (most == null || ex.getBurnedCalories() > most.getBurnedCalories()) {
				most = ex;
			}
		}
		return most;

	}

	public int getExerciseCount() {
		return exercises.size();
	}

	public String getStatistics() {
		StringBuilder stats = new StringBuilder();
		stats.append("Workout type: " + this.type + "\n");

		exercises.forEach(x -> stats.append(x + "\n"));

		return stats.toString();

	}
}
