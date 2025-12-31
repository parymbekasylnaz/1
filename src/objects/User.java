package objects;

import java.util.Objects;

public class User extends Person {
    private int id;
    private String phoneNumber;

    public User() {
        super();
    }

    @Override
    public void showInfo() {
        System.out.println(this.toString());
    }

    public User(int id, String firstName, String lastName, String email, String phoneNumber) {
        super(firstName, lastName, email);
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    @Override
    public String toString() {
        return "User{id=" + id + " | name=" + getFirstName() + " " + getLastName() +
                " | email=" + getEmail() + " | phone=" + phoneNumber + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User u = (User) o;
        return id == u.id && Objects.equals(getEmail(), u.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getEmail());
    }
}
