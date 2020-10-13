// Name: Marvin Dale
// ID  : 18362583

// Driver for Employee hierarchy

// Java core packages
import org.joda.money.Money;

import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;

// Java extension packages
import javax.swing.JOptionPane;

public class Test {

    // test Employee hierarchy
    public static void main(String args[]) {
        //Employee employee; // superclass reference
        String output = "";
        ArrayList<Employee> employees = new ArrayList<>();

        //workers instantiated with their weekly earnings

        Boss boss = new Boss("John", "Smith", Money.parse("EUR 800"),
                LocalDate.of(2000, 1, 3));

        CommissionWorker commissionWorker =
                new CommissionWorker(
                "Sue", "Jones", LocalDate.of(2017, 1, 13),
                        Money.parse("EUR 400"), Money.parse("EUR 3.0"), 150);

        PieceWorker pieceWorker =
                new PieceWorker("Bob", "Lewis", LocalDate.of(2020, 4, 15),
                        Money.parse("EUR 2.5"), 200);

        HourlyWorker hourlyWorker =
                new HourlyWorker("Karen", "Price", LocalDate.of(2016, 9, 1),
                        Money.parse("EUR 13.75"), 40);

        //add workers to arraylist
        employees.add(boss);
        employees.add(commissionWorker);
        employees.add(pieceWorker);
        employees.add(hourlyWorker);

        output += handlePayroll(employees);

        JOptionPane.showMessageDialog(null, output,
                "Monthly Staff Payroll",
                JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }

    public static String handlePayroll(ArrayList<Employee> employees) {
        String output = "";
        int thisYear = LocalDate.now().getYear();

        Money bonus;
        for (Employee emp: employees) {
            if (thisYear - emp.getJoinDate().getYear() > 5) {
                bonus = Money.parse("EUR 200");
            }
            else {
                bonus = Money.parse("EUR 0");
            }

            try {
                output += emp.toString() + " " + emp.earnings().multipliedBy(
                        4, RoundingMode.FLOOR).plus(bonus) + "\n";
            } catch (LowWageException exception) {
                output += exception.getMessage();
                exception.printStackTrace();
            }
        }
        return output;
    }

} // end class Test
