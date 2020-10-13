// Name: Marvin Dale
// ID  : 18362583

// PieceWorker class derived from Employee

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.time.LocalDate;

public final class PieceWorker extends Employee {

    private Money wagePerPiece; // wage per piece output
    private int quantity; // output for week

    // constructor for class PieceWorker
    public PieceWorker(String first, String last, LocalDate date,
            Money wage, int numberOfItems) {
        super(first, last, date); // call superclass constructor
        setWage(wage);
        setQuantity(numberOfItems);
    }

    // set PieceWorker's wage
    public void setWage(Money wage) {
        Money zero = Money.parse("EUR 0");
        wagePerPiece = (wage.isGreaterThan(zero) ? wage : zero);
    }

    // set number of items output
    public void setQuantity(int numberOfItems) {
        quantity = (numberOfItems > 0 ? numberOfItems : 0);
    }

    // determine PieceWorker's earnings
    public Money earnings () throws LowWageException {
        Money totalEarnings = wagePerPiece.multipliedBy(quantity);
        Money min = Money.parse("EUR 100");

        System.out.println(totalEarnings + "piece worker total");

        //throw exception if the total earnings are below EUR 100
        if (totalEarnings.isLessThan(min)){
            throw new LowWageException(getFirstName() + " " + getLastName()
                    +" is earning " + totalEarnings + " a week" + "\n"
                    + "Each employee must earn at least " + min + " a week");
        }

        return totalEarnings;
    }

    public String toString() {
        return "Piece worker: " + super.toString();
    }
}
