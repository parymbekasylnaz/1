package objects;
public class WorkoutRoutine {

    private int id;
    private String name;
    private double caloriesBurned;
    private String type;
    private String duration;
    private boolean active;

    public WorkoutRoutine() {
    }

    public WorkoutRoutine(int id, String name, double caloriesBurned, String type, String duration, boolean active) {
        this.id = id;
        this.name = name;
        this.caloriesBurned = caloriesBurned;
        this.type = type;
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

    public double getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(double caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}