// Abstract base class Employee.

import java.time.LocalDate;

public abstract class Employee {

    private String firstName;
    private String lastName;
    private LocalDate joinDate;

    // constructor
    public Employee(String first, String last, LocalDate date) {
        firstName = first;
        lastName = last;
        joinDate = date;
    }

    // get first name
    public String getFirstName() {
        return firstName;
    }

    // get last name
    public String getLastName() {
        return lastName;
    }

    //get join date
    public LocalDate getJoinDate() { return joinDate;}

    public String toString() {
        return firstName + ' ' + lastName;
    }

    public abstract double earnings();
}
