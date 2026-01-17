package kz.assylnaz.assignment.managers;

import kz.assylnaz.assignment.database.DatabaseConnection;
import kz.assylnaz.assignment.objects.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private Connection connection;

    public UserManager() {
        try {
            connection = DatabaseConnection.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        createTable();
    }

    private void createTable() {
        String createUsers = """
        CREATE TABLE IF NOT EXISTS users (
            id SERIAL PRIMARY KEY,
            first_name VARCHAR(100),
            last_name VARCHAR(100),
            email VARCHAR(150) UNIQUE,
            phone_number VARCHAR(20),
            date_of_birth VARCHAR(10),
            calories_goal DECIMAL(5, 2)
        )
    """;

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createUsers);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createUser(String firstName, String lastName,  String email, String phoneNumber, String dateOfBirth, double caloriesGoalByDay) {
        try (PreparedStatement ps = connection.prepareStatement(
                     "INSERT INTO users (first_name, last_name, email, phone_number, date_of_birth, calories_goal) VALUES (?, ?, ?, ?, ?, ?)")) {

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, phoneNumber);
            ps.setString(5, dateOfBirth);
            ps.setDouble(6, caloriesGoalByDay);

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error adding user");
            e.printStackTrace();
        }
    }

    public User getUserByName(String name) {
        for (User u : getAllUsers()) {
            if (u.getFirstName().equals(name)) {
                return u;
            }
        }
        return null;
    }

    public User getById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                User user = new User();

                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setPhoneNumber(rs.getString("phone_number"));
                user.setDateOfBirth(parseDateOfBirth(rs.getString("date_of_birth")));
                user.setCaloriesGoalByDay(rs.getDouble("calories_goal"));

                return user;
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM users")) {
            while (rs.next()) {
                users.add(
                        new User(
                                rs.getInt("id"),
                                rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getString("email"),
                                rs.getString("phone_number"),
                                parseDateOfBirth(rs.getString("date_of_birth")),
                                rs.getDouble("calories_goal")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void updateUser(User user) {
        try (PreparedStatement ps = connection.prepareStatement(
                     "UPDATE users SET first_name=?, last_name=?, email=?, phone_number=?, date_of_birth=?, calories_goal=? WHERE id=?")) {
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhoneNumber());
            ps.setString(5, user.getDateOfBirth().toString());
            ps.setDouble(6, user.getCaloriesGoalByDay());
            ps.setInt(7, user.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM users WHERE id=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private LocalDate parseDateOfBirth(String dateOfBirth) {
        return LocalDate.parse(dateOfBirth);
    }

}
