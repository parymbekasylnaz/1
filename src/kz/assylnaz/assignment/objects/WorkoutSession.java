package kz.assylnaz.assignment.objects;

import java.time.LocalDateTime;
import java.util.Objects;

public class WorkoutSession {

    private WorkoutRoutine type;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double burnedCalories;

    public WorkoutSession() {}

    public WorkoutSession(WorkoutRoutine type, LocalDateTime startTime, LocalDateTime endTime) {
        this.type = type;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public WorkoutRoutine getType() {
        return type;
    }

    public void setType(WorkoutRoutine type) {
        this.type = type;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public double getBurnedCalories() {
        return burnedCalories;
    }

    public void setBurnedCalories(double burnedCalories) {
        this.burnedCalories = burnedCalories;
    }

    @Override
    public String toString() {
        return "\n\nWorkoutSession (" + type + ") \n" + getFormattedTime(startTime) + " - " + getFormattedTime(endTime) + " \nBurned calories: " + burnedCalories;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof WorkoutSession that)) return false;
        return Double.compare(burnedCalories, that.burnedCalories) == 0 &&
                Objects.equals(type, that.type) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, startTime, endTime, burnedCalories);
    }

    private String getFormattedTime(LocalDateTime time) {
        return time.getDayOfMonth() + "-" + time.getMonthValue() + "-" + time.getYear() + " " + time.getHour() + ":" + time.getMinute() ;
    }
}
