// Name: Marvin Dale
// ID  : 18362583

// Abstract base class Employee.

import org.joda.money.Money;

import java.time.LocalDate;

public abstract class Employee {

    private String firstName;
    private String lastName;
    private LocalDate joinDate;
    public static int id = 0;

    // constructor
    public Employee(String first, String last, LocalDate date) {
        firstName = first;
        lastName = last;
        joinDate = date;
        id++;
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

    public abstract Money earnings() throws LowWageException;
}
