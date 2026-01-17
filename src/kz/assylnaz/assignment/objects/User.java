package kz.assylnaz.assignment.objects;

import java.time.LocalDate;
import java.util.Objects;

public class User {

    private int id;

    private String firstName;
    private String lastName;

    private String email;
    private String phoneNumber;

    private LocalDate dateOfBirth;
    private double caloriesGoalByDay;

    public User() {}

    public User(int id, String firstName, String lastName, String email, String phoneNumber, LocalDate dateOfBirth, double caloriesGoalByDay) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.caloriesGoalByDay = caloriesGoalByDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getCaloriesGoalByDay() {
        return caloriesGoalByDay;
    }

    public void setCaloriesGoalByDay(double caloriesGoalByDay) {
        this.caloriesGoalByDay = caloriesGoalByDay;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + email + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User p = (User) o;
        return Objects.equals(email, p.email) && Objects.equals(firstName, p.firstName) && Objects.equals(lastName, p.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
