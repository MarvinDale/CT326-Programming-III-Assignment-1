// Name: Marvin Dale
// ID  : 18362583

// CommissionWorker class derived from Employee

import org.joda.money.Money;
import java.time.LocalDate;

public final class CommissionWorker extends Employee {

    private Money salary;     // base salary per week
    private Money commission; // amount per item sold
    private int   quantity;   // total items sold for week
    private int   idNum;      // unique id number

    // constructor for class CommissionWorker
    public CommissionWorker(String first, String last, LocalDate date,
                            Money salary, Money commission, int quantity) {

        super(first, last, date); // call superclass constructor
        setSalary(salary);
        setCommission(commission);
        setQuantity(quantity);
    }

    public int getIdNum() { return idNum;}

    // set CommissionWorker's weekly base salary
    public void setSalary(Money weeklySalary) {
        Money zero = Money.parse("EUR 0");
        salary     = (weeklySalary.isGreaterThan(zero) ? weeklySalary : zero);
    }

    // set CommissionWorker's commission
    public void setCommission(Money itemCommission) {
        Money zero = Money.parse("EUR 0");
        commission = (itemCommission.isGreaterThan(zero) ? itemCommission : zero);
    }

    // set CommissionWorker's quantity sold
    public void setQuantity(int totalSold) { quantity = (totalSold > 0 ? totalSold : 0); }

    // determine CommissionWorker's earnings
    public Money earnings() throws LowWageException {
        Money totalEarnings = salary.plus(commission.multipliedBy(quantity));
        Money min           = Money.parse("EUR 100"); // set limit to throw exception

        //throw exception if the total earnings are below EUR 100
        if (totalEarnings.isLessThan(min)) {
            throw new LowWageException(getFirstName() + " " + getLastName()
                    +" is earning " + totalEarnings + " a week" + "\n"
                    + "Each employee must earn at least " + min + " a week \n");
        }
        //return salary plus the product of commission and quantity
        return totalEarnings;
    }

    // get String representation of CommissionWorker's name
    public String toString() {
        return "Commission worker: " + super.toString();
    }
} // end class CommissionWorker
