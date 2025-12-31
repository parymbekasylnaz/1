import objects.*;

public class Main {
    public static void main(String[] args) {

        User user = new User(1, "Assylnaz", "Parymbek", "assylnaz@mail.com", "87763360848");

        FitnessApp app = new FitnessApp(user);

        WorkoutRoutine r1 = new WorkoutRoutine(1, "Morning Workout", "Cardio", 400, "45 minutes", true);
        WorkoutRoutine r2 = new WorkoutRoutine(2, "Evening Workout", "Strength", 300, "30 minutes", false);

        app.addRoutine(r1);
        app.addRoutine(r2);

        app.sortByCalories();
        app.showInfo();

        System.out.println("Active routines: " + app.getActiveRoutines());
        System.out.println("Search 'Morning Workout': " + app.findByName("Morning Workout"));
    }
}
