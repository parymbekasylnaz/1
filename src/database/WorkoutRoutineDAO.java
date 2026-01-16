package database;

import objects.WorkoutRoutine;
import java.sql.*;
import java.util.*;

public class WorkoutRoutineDAO {

    public void add(WorkoutRoutine w, int userId) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "INSERT INTO workout_routines (user_id, name, type, calories_burned, duration, active) VALUES (?, ?, ?, ?, ?, ?)")) {
            // БЕЗ id
            ps.setInt(1, userId);
            ps.setString(2, w.getName());
            ps.setString(3, w.getType());
            ps.setDouble(4, w.getCaloriesBurned());
            ps.setString(5, w.getDuration());
            ps.setBoolean(6, w.isActive());
            ps.executeUpdate();
            System.out.println("Workout added");
        } catch (SQLException e) {
            System.out.println("Error adding workout");
            e.printStackTrace();
        }
    }

    public List<WorkoutRoutine> getByUserId(int userId) {
        List<WorkoutRoutine> workouts = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM workout_routines WHERE user_id=?")) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                workouts.add(new WorkoutRoutine(rs.getInt("id"), rs.getString("name"),
                        rs.getString("type"), rs.getDouble("calories_burned"),
                        rs.getString("duration"), rs.getBoolean("active")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workouts;
    }

    public void update(WorkoutRoutine w) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "UPDATE workout_routines SET name=?, type=?, calories_burned=?, duration=?, active=? WHERE id=?")) {
            ps.setString(1, w.getName());
            ps.setString(2, w.getType());
            ps.setDouble(3, w.getCaloriesBurned());
            ps.setString(4, w.getDuration());
            ps.setBoolean(5, w.isActive());
            ps.setInt(6, w.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM workout_routines WHERE id=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}