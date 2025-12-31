package objects;

import java.util.Objects;

public class WorkoutRoutine {

    private int id;
    private String name;
    private String type;
    private double caloriesBurned;
    private String duration;
    private boolean active;

    public WorkoutRoutine(int id, String name, String type, double caloriesBurned, String duration, boolean active) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.caloriesBurned = caloriesBurned;
        this.duration = duration;
        this.active = active;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public double getCaloriesBurned() {
        return caloriesBurned;
    }
    public void setCaloriesBurned(double caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    public void showInfo() {
        System.out.println("WorkoutRoutine info:");
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "WorkoutRoutine{id=" + id +
                " | name=" + name +
                " | type=" + type +
                " | calories=" + caloriesBurned +
                " | duration=" + duration +
                " | active=" + active + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        WorkoutRoutine r = (WorkoutRoutine) o;
        return id == r.id &&
                Double.compare(r.caloriesBurned, caloriesBurned) == 0 &&
                active == r.active &&
                Objects.equals(name, r.name) &&
                Objects.equals(type, r.type) &&
                Objects.equals(duration, r.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, caloriesBurned, duration, active);
    }
}
