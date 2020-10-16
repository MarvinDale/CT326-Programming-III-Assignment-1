// Name: Marvin Dale
// ID  : 18362583

// Definition of class HourlyWorker


import org.joda.money.Money;
import java.time.LocalDate;

public final class HourlyWorker extends Employee {

    private Money  wage;  // wage per hour
    private double hours; // hours worked for week
    private int    idNum; // unique id number

    // constructor for class HourlyWorker
    public HourlyWorker(String first, String last, LocalDate date,
            Money wagePerHour, double hoursWorked) {
        super(first, last, date); // call superclass constructor
        setWage(wagePerHour);
        setHours(hoursWorked);
    }

    // Set the wage
    public void setWage(Money wagePerHour) {
        Money zero = Money.parse("EUR 0");
        wage = (wagePerHour.isGreaterThan(zero)  ? wagePerHour : zero);
    }

    // Set the hours worked
    public void setHours(double hoursWorked) {
        hours = (hoursWorked >= 0 && hoursWorked < 168
                ? hoursWorked : 0);
    }

    // Get the HourlyWorker's pay
    public Money earnings() throws LowWageException {
        Money totalEarnings = wage.multipliedBy((long) hours);
        Money min           = Money.parse("EUR 100"); // set limit to throw exception

        //throw exception if the total earnings are below EUR 100
        if (totalEarnings.isLessThan(min)) {
            throw new LowWageException(getFirstName() + " " + getLastName()
                    +" is earning " + totalEarnings + " a week" + "\n"
                    + "Each employee must earn at least " + min + " a week \n");
        }
        return totalEarnings;
    }
    public String toString() {
        return "Hourly worker: " + super.toString();
    }
}
