package objects;
public class FitnessApp {

    private int id;
    private User user;
    private WorkoutRoutine workoutRoutine;
    private double totalCalories;
    private double goalCalories;
    private double subscriptionFee;

    public FitnessApp() {
    }

    public FitnessApp(int id, User user, WorkoutRoutine workoutRoutine,
                      double totalCalories, double goalCalories, double subscriptionFee) {
        this.id = id;
        this.user = user;
        this.workoutRoutine = workoutRoutine;
        this.totalCalories = totalCalories;
        this.goalCalories = goalCalories;
        this.subscriptionFee = subscriptionFee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public WorkoutRoutine getWorkoutRoutine() {
        return workoutRoutine;
    }

    public void setWorkoutRoutine(WorkoutRoutine workoutRoutine) {
        this.workoutRoutine = workoutRoutine;
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    public double getGoalCalories() {
        return goalCalories;
    }

    public void setGoalCalories(double goalCalories) {
        this.goalCalories = goalCalories;
    }

    public double getSubscriptionFee() {
        return subscriptionFee;
    }

    public void setSubscriptionFee(double subscriptionFee) {
        this.subscriptionFee = subscriptionFee;
    }

    public String toString() {
        return "FitnessApp{" +
                "id=" + id +
                ", user=" + user +
                ", workoutRoutine=" + workoutRoutine +
                ", totalCalories=" + totalCalories +
                ", goalCalories=" + goalCalories +
                ", subscriptionFee=" + subscriptionFee +
                '}';
    }
}