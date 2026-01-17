package kz.assylnaz.assignment.objects;

public abstract class WorkoutRoutine {

    private String name;
    private double caloriesGoal;

    public WorkoutRoutine(String name, double caloriesGoal) {
        this.name = name;
        this.caloriesGoal = caloriesGoal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCaloriesGoal() {
        return caloriesGoal;
    }

    public void setCaloriesGoal(double caloriesGoal) {
        this.caloriesGoal = caloriesGoal;
    }

    @Override
    public String toString() {
        return "WorkoutRoutine{" +
                "name='" + name + '\'' +
                ", caloriesGoal=" + caloriesGoal +
                '}';
    }
}
