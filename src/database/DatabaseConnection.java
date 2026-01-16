package database;

import java.sql.*;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/fitness_app";
    private static final String USER = "postgres";
    private static final String PASSWORD = "iphone2020";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void createTablesIfNotExist() {
        String createUsers = """
        CREATE TABLE users (
            id SERIAL PRIMARY KEY,
            first_name VARCHAR(100),
            last_name VARCHAR(100),
            email VARCHAR(150) UNIQUE,
            phone_number VARCHAR(20)
        )
    """;

        String createWorkouts = """
        CREATE TABLE workout_routines (
            id SERIAL PRIMARY KEY,
            user_id INTEGER REFERENCES users(id),
            name VARCHAR(200),
            type VARCHAR(100),
            calories_burned DECIMAL(10, 2),
            duration VARCHAR(50),
            active BOOLEAN
        )
    """;

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(createUsers);
            stmt.execute(createWorkouts);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}