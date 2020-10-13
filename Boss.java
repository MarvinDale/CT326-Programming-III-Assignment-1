// Name: Marvin Dale
// ID  : 18362583

// Boss class derived from Employee.

import org.joda.money.Money;

import java.time.LocalDate;

public final class Boss extends Employee {

    private Money weeklySalary;

    // constructor for class Boss
    public Boss(String first, String last, Money salary, LocalDate date) {
        super(first, last, date); // call superclass constructor
        setWeeklySalary(salary);
    }

    // set Boss's salary
    public void setWeeklySalary(Money salary) {
        Money zero = Money.parse("EUR 0");
        weeklySalary = (salary.isGreaterThan(zero) ? salary : zero);
    }

    // get Boss's pay
    public Money earnings() {
        return weeklySalary;
    }

    // get String representation of Boss's name
    public String toString() {
        return "Boss: " + super.toString();
    }
} // end class Boss
