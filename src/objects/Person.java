package objects;

import java.util.Objects;

public abstract class Person {
    private String firstName;
    private String lastName;
    private String email;

    public Person() {}

    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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

    public abstract void showInfo();

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + email + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person p = (Person) o;
        return Objects.equals(email, p.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
