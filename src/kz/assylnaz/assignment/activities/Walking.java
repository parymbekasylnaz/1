package kz.assylnaz.assignment.activities;

import kz.assylnaz.assignment.objects.WorkoutRoutine;

public class Walking extends WorkoutRoutine {

    private int stepCount;
    private int stepGoal;

    public Walking(String name, double caloriesGoal) {
        super(name, caloriesGoal);
    }

    public Walking(String name, double caloriesGoal, int stepCount, int stepGoal) {
        super(name, caloriesGoal);
        this.stepCount = stepCount;
        this.stepGoal = stepGoal;
    }

    public int getStepCount() {
        return stepCount;
    }

    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }

    public int getStepGoal() {
        return stepGoal;
    }

    public void setStepGoal(int stepGoal) {
        this.stepGoal = stepGoal;
    }

    @Override
    public String toString() {
        return "Walking" + " (" + stepCount + " / " + stepGoal + ")";
    }
}
