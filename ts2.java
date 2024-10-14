import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Workout {
    String exercise;
    int duration; // in minutes
    int caloriesBurned;

    Workout(String exercise, int duration, int caloriesBurned) {
        this.exercise = exercise;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
    }

    @Override
    public String toString() {
        return exercise + " for " + duration + " minutes (Calories burned: " + caloriesBurned + ")";
    }
}

class FitnessTracker {
    private List<Workout> workouts;

    FitnessTracker() {
        workouts = new ArrayList<>();
    }

    void addWorkout(String exercise, int duration, int caloriesBurned) {
        Workout workout = new Workout(exercise, duration, caloriesBurned);
        workouts.add(workout);
    }

    void showWorkoutHistory() {
        System.out.println("Workout History:");
        for (Workout workout : workouts) {
            System.out.println(workout);
        }
    }

    int totalCaloriesBurned() {
        int total = 0;
        for (Workout workout : workouts) {
            total += workout.caloriesBurned;
        }
        return total;
    }
}

public class FitnessTrackerApp {
    public static void main(String[] args) {
        FitnessTracker tracker = new FitnessTracker();
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Welcome to the Fitness Tracker App!");

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add workout");
            System.out.println("2. Show workout history");
            System.out.println("3. Show total calories burned");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Enter exercise name: ");
                    String exercise = scanner.nextLine();
                    System.out.print("Enter duration (in minutes): ");
                    int duration = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter calories burned: ");
                    int calories = Integer.parseInt(scanner.nextLine());
                    tracker.addWorkout(exercise, duration, calories);
                    System.out.println("Workout added!");
                    break;
                case "2":
                    tracker.showWorkoutHistory();
                    break;
                case "3":
                    System.out.println("Total calories burned: " + tracker.totalCaloriesBurned());
                    break;
                case "4":
                    System.out.println("Exiting the app. Stay fit!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
