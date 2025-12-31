package objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FitnessApp {

    private User user;
    private List<WorkoutRoutine> routines;

    public FitnessApp(User user) {
        this.user = user;
        this.routines = new ArrayList<>();
    }

    public void addRoutine(WorkoutRoutine routine) {
        routines.add(routine);
    }

    public WorkoutRoutine findByName(String name) {
        for (WorkoutRoutine r : routines) {
            if (r.getName().equalsIgnoreCase(name)) return r;
        }
        return null;
    }

    public List<WorkoutRoutine> getActiveRoutines() {
        List<WorkoutRoutine> active = new ArrayList<>();
        for (WorkoutRoutine r : routines) {
            if (r.isActive()) active.add(r);
        }
        return active;
    }

    public void sortByCalories() {
        for (int i = 0; i < routines.size() - 1; i++) {
            for (int j = 0; j < routines.size() - i - 1; j++) {
                WorkoutRoutine r1 = routines.get(i);
                WorkoutRoutine r2 = routines.get(j + 1);
                if(r1.getCaloriesBurned() > r2.getCaloriesBurned()) {
                    routines.set(i, r2);
                    routines.set(j + 1, r1);
                }

            }
        }
    }

    public void showInfo() {
        System.out.println("FitnessApp info:");
        System.out.println("User: " + user);
        System.out.println("Workouts: " + routines);
    }

    @Override
    public String toString() {
        return "FitnessApp{user=" + user + " | routines=" + routines + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FitnessApp app = (FitnessApp) o;
        return Objects.equals(user, app.user) &&
                Objects.equals(routines, app.routines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, routines);
    }
}
