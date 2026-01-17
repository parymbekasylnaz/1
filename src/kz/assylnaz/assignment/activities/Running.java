package kz.assylnaz.assignment.activities;

import kz.assylnaz.assignment.objects.WorkoutRoutine;

public class Running extends WorkoutRoutine {

    private double distanceGoal; //km
    private double result; //km

    public Running(String name, double caloriesGoal) {
        super(name, caloriesGoal);
    }

    public Running(String name, double caloriesGoal, double distanceGoal, double result) {
        super(name, caloriesGoal);
        this.distanceGoal = distanceGoal;
        this.result = result;
    }

    public double getDistanceGoal() {
        return distanceGoal;
    }

    public void setDistanceGoal(double distanceGoal) {
        this.distanceGoal = distanceGoal;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Running" + " (" + result + " / " + distanceGoal + ")";
    }
}
