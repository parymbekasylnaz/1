package kz.assylnaz.assignment.managers;

import kz.assylnaz.assignment.activities.Running;
import kz.assylnaz.assignment.activities.Walking;
import kz.assylnaz.assignment.database.DatabaseConnection;
import kz.assylnaz.assignment.objects.WorkoutRoutine;
import kz.assylnaz.assignment.objects.WorkoutSession;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RoutineManager {
    private Connection connection;

    public RoutineManager() {
        try {
            connection = DatabaseConnection.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        createTable();
    }

    private void createTable() {
        String createSessions = """
        CREATE TABLE IF NOT EXISTS sessions (
            
            routineName VARCHAR(20),
            caloriesGoal DECIMAL(5,2),
            startTime VARCHAR(50),
            endTime VARCHAR(50),
            burnedCalories DECIMAL(5,2),
            params TEXT
        )
        """;

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createSessions);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createSession(WorkoutRoutine routine, String startTime, String endTime, double burnedCalories) {

        String routineName = routine.getName();
        double caloriesGoal = routine.getCaloriesGoal();

        String params = "";
        if (routine instanceof Walking) {
            int stepCount = ((Walking) routine).getStepCount();
            int stepGoal = ((Walking) routine).getStepGoal();

            params = "stepCount=" + stepCount + ";stepGoal=" + stepGoal;
        } else if (routine instanceof Running) {
            double distanceGoal = ((Running) routine).getDistanceGoal();
            double result = ((Running) routine).getResult();

            params = "distanceGoal=" + distanceGoal + ";result=" + result;
        }

        try (PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO sessions (routineName, caloriesGoal, startTime, endTime, burnedCalories, params) VALUES (?, ?, ?, ?, ?, ?)")) {

            ps.setString(1, routineName);
            ps.setDouble(2, caloriesGoal);
            ps.setString(3, startTime);
            ps.setString(4, endTime);
            ps.setDouble(5, burnedCalories);
            ps.setString(6, params);

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error on creating session:");
            e.printStackTrace();
        }
    }

    public WorkoutSession getByTime(String startTime, String endTime) {
        String sql = "SELECT * FROM sessions WHERE startTime = ? AND endTime = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, startTime);
            statement.setString(2, endTime);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                WorkoutSession workoutSession = new WorkoutSession();
                String workoutName = rs.getString("routineName");

                String params = rs.getString("params");

                if (workoutName.equals("Running")) {
                    Running running = new Running(workoutName, rs.getDouble("caloriesGoal"));

                    running.setDistanceGoal(getIntFromParams("distanceGoal", params));
                    running.setResult(getIntFromParams("result", params));

                    workoutSession.setType(running);
                } else if (workoutName.equals("Walking")) {
                    Walking walking = new Walking(workoutName, rs.getDouble("caloriesGoal"));

                    walking.setStepCount(getIntFromParams("stepCount", params));
                    walking.setStepGoal(getIntFromParams("stepGoal", params));

                    workoutSession.setType(walking);
                }

                workoutSession.setStartTime(parseDate(startTime));
                workoutSession.setEndTime(parseDate(endTime));
                workoutSession.setBurnedCalories(rs.getDouble("burnedCalories"));

                return workoutSession;
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<WorkoutSession> getAllSessions() {
        List<WorkoutSession> workoutSessions = new ArrayList<>();

        try (ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM sessions")) {
            while (rs.next()) {
                WorkoutSession workoutSession = new WorkoutSession();
                String workoutName = rs.getString("workoutName");

                String params = rs.getString("params");

                if (workoutName.equals("Running")) {
                    Running running = new Running(workoutName, rs.getDouble("caloriesGoal"));

                    running.setDistanceGoal(getIntFromParams("distanceGoal", params));
                    running.setResult(getIntFromParams("result", params));

                    workoutSession.setType(running);
                } else if (workoutName.equals("Walking")) {
                    Walking walking = new Walking(workoutName, rs.getDouble("caloriesGoal"));

                    walking.setStepCount(getIntFromParams("stepCount", params));
                    walking.setStepGoal(getIntFromParams("stepGoal", params));

                    workoutSession.setType(walking);
                }

                workoutSession.setStartTime(parseDate(rs.getString("startTime")));
                workoutSession.setEndTime(parseDate(rs.getString("endTime")));
                workoutSession.setBurnedCalories(rs.getDouble("burnedCalories"));

                workoutSessions.add(workoutSession);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return workoutSessions;
    }

    public void updateSession(WorkoutSession workoutSession) {
        try (PreparedStatement ps = connection.prepareStatement(
                "UPDATE sessions SET routineName=?, caloriesGoal=?, startTime=?, endTime=?, " +
                        "burnedCalories=?, params=? WHERE routineName=? AND startTime=? AND endTime=?")) {

            WorkoutRoutine routine = workoutSession.getType();

            ps.setString(1, routine.getName());
            ps.setDouble(2, routine.getCaloriesGoal());
            ps.setString(3, workoutSession.getStartTime().toString());
            ps.setString(4, workoutSession.getEndTime().toString());
            ps.setDouble(5, workoutSession.getBurnedCalories());

            String params = "";
            if (routine instanceof Walking) {
                int stepCount = ((Walking) routine).getStepCount();
                int stepGoal = ((Walking) routine).getStepGoal();

                params = "stepCount=" + stepCount + ";stepGoal=" + stepGoal;
            } else if (routine instanceof Running) {
                double distanceGoal = ((Running) routine).getDistanceGoal();
                double result = ((Running) routine).getResult();

                params = "distanceGoal=" + distanceGoal + ";result=" + result;
            }

            ps.setString(6, params);
            ps.setString(7, routine.getName());

            ps.setString(8, workoutSession.getStartTime().toString());
            ps.setString(9, workoutSession.getEndTime().toString());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteWorkoutSession(String routineName, String startTime, String endTime) {
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM sessions WHERE routineName=? AND startTime=? AND endTime=?")) {
            ps.setString(1, routineName);
            ps.setString(2, startTime);
            ps.setString(3, endTime);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private int getIntFromParams(String name, String params) {
        String[] p = params.split(";");

        for (int i = 0; i < p.length; i++) {
            String param = p[i];
            if (param.startsWith(name)) {
                return Integer.parseInt(param.substring(name.length() + 1));
            }
        }
        return -1;
    }

    private LocalDateTime parseDate(String date) {
        return LocalDateTime.parse(date);
    }
}