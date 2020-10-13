## Assignment 1

Modify the supplied payroll system to include a private instance variable called joinDate in class Employee to represent when they joined the company. Use the java.time library class LocalDate as the type for this variable. See https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html for details end examples of how to use this library. The classes that extend Employee currently have an instance variable of type double to represent the amount or hourly rate that an employee is paid. Use the Joda-Money library class Money instead as the type for this variable. See https://www.joda.org/joda-money/ for details. You may also have to download the attached Joda-Money library (JAR File) and include this in your CLASSPATH or IDE Project Libraries.

Use a static variable in the Employee class to help automatically assign each new employee a unique (incremental) id number. Assume the payroll is processed once per month. Create an array of Employee variables to store references to the various employee objects. In a loop, calculate the payroll for each Employee, and add a €200.00 bonus to the person’s payroll if they joined the company more than five years before the current date. Change the earnings() method in Employee and all sub-classes to throw a user defined Exception called LowWageException if the total earnings for an employee is less than €100 for the month. The exception should have a message with the employee's name, the calculated earnings, and a short description of the problem. Modify the Test class to be able to handle exceptions. When an exception is encountered calculating an employee's earnings, the Test class should print out the error message and continue as normal with the next employees. Test this by changing the Test class so that one of the employees will have low earnings which will cause the exception to he thrown.

Use proper indentation in your source code.