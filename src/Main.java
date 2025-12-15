import objects.FitnessApp;
import objects.User;
import objects.WorkoutRoutine;

public class Main {
    public static void main(String[] args){

        WorkoutRoutine routine = new WorkoutRoutine();
        routine.setId(1);
        routine.setType("Cardio");
        routine.setName("Morning Workout");
        routine.setCaloriesBurned(400);
        routine.setDuration("45 minutes");
        routine.setActive(false);

        User user = new User();
        user.setId(1);
        user.setFullName("Assylnaz");
        user.setEmail("assylnaz.parymbek@mail.ru");
        user.setPhoneNumber("87763360848");

        FitnessApp app = new FitnessApp(1, user, routine, 2800, 3000, 1500);

        System.out.println(user.getFullName());
        System.out.println(app.toString());
        System.out.println(routine.getName());
        System.out.println(routine.getType());
    }
}
