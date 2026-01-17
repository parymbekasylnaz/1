package kz.assylnaz.assignment.database;

import java.sql.*;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/fitness_app";
    private static final String USER = "postgres";
    private static final String PASSWORD = "iphone2020";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }


}