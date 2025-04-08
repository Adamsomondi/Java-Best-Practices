package org.example;
/* Author @Adams
    PART A: Simple Concepts.

    Best Practices in Classes and Objects.
    With Primitive Type and Basic Functions.
    The Office Design - I love the Office Series.

   Prerequisites:
   Basic variables.
   Basic functions.
   Theory in Class Design, Patterns, Principles. Bottom Up Approach Programming.
*/

//Predefined Classes
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TheOfficeA {
    // Static constants (class variables)
    private static final int MAX_EMPLOYEES = 50;
    private static final double MIN_BUDGET = 10000.0;

    // Instance variables with default values
    private int numEmployees = 0;           // Number of employees
    private double budget = 0.0;            // Budget
    private boolean openStatus = false;     // Office open status
    private LocalTime openingTime;          // Opening time
    private LocalTime closingTime;          // Closing time

    /**
     * Default Constructor.
     * Creates a new office with default values.
     */
    public TheOfficeA() {
        // Default values already set in declarations
        // Setting default office hours 9AM-5PM
        this.openingTime = LocalTime.of(9, 0);
        this.closingTime = LocalTime.of(17, 0);
        System.out.println("New office created with default values");
    }
    /**
     * Parameterized Constructor.
     * Creates a new office with specified values.
     *
     * @param employees Number of employees.
     * @param budget Office budget.
     */
    public TheOfficeA(int employees, double budget) {
        // Default values already set in declarations
        // Set default office hours
        this.openingTime = LocalTime.of(9, 0);
        this.closingTime = LocalTime.of(17, 0);

        // Use setter methods to ensure validation
        setNumEmployees(employees);
        setBudget(budget);
        this.openStatus = true;
    }
    /**
     * Fully Parameterized Constructor.
     * Creates a new office with specified values including operating hours.
     *
     * @param employees Number of employees.
     * @param budget Office budget.
     * @param openingHour Opening hour (0-23).
     * @param openingMinute Opening minute (0-59).
     * @param closingHour Closing hour (0-23).
     * @param closingMinute Closing minute (0-59).
     */
    public TheOfficeA(int employees, double budget,
                     int openingHour, int openingMinute,
                     int closingHour, int closingMinute) {

        // Use setter methods to ensure validation
        setNumEmployees(employees);
        setBudget(budget);
        setOfficeHours(openingHour, openingMinute, closingHour, closingMinute);
        this.openStatus = true;
    }

    /**
     * Sets the number of employees with validation.
     *
     * @param employees Number of employees.
     */
    public void setNumEmployees(int employees) {
        if (employees >= 0 && employees <= MAX_EMPLOYEES) {
            this.numEmployees = employees;
        } else {
            System.out.println("Invalid employee count. Must be between 0 and "
                    + MAX_EMPLOYEES);
        }
    }
    /**
     * Sets the office budget with validation.
     *
     * @param budget Office budget
     */

    public void setBudget(double budget) {
        if (budget >= MIN_BUDGET) {
            this.budget = budget;
        } else {
            System.out.println("Budget must be at least $" + MIN_BUDGET);
        }
    }

    /**
     * Sets the office open status.
     *
     * @param status Open status (true=open, false=closed)
     */
    public void setOpenStatus(boolean status) {
        this.openStatus = status;
    }

    /**
     * Sets office operating hours.
     *
     * @param openingHour Opening hour (0-23)
     * @param openingMinute Opening minute (0-59)
     * @param closingHour Closing hour (0-23)
     * @param closingMinute Closing minute (0-59)
     */
    public void setOfficeHours(int openingHour, int openingMinute,
                               int closingHour, int closingMinute) {
        try {
            LocalTime opening = LocalTime.of(openingHour, openingMinute);
            LocalTime closing = LocalTime.of(closingHour, closingMinute);

            if (closing.isAfter(opening)) {
                this.openingTime = opening;
                this.closingTime = closing;
            } else {
                System.out.println("Closing time must be after opening time");
            }
        } catch (Exception e) {
            System.out.println("Invalid time format: " + e.getMessage());
        }
    }

    /**
     * Gets the number of employees.
     *
     * @return Number of employees
     */
    public int getNumEmployees() {
        return numEmployees;
    }

    /**
     * Gets the office budget.
     *
     * @return Office budget
     */
    public double getBudget() {
        return budget;
    }

    /**
     * Checks if the office is open.
     *
     * @return Open status
     */
    public boolean isOpen() {
        return openStatus;
    }

    /**
     * Gets the office opening time.
     *
     * @return Opening time
     */

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    /**
     * Gets the office closing time.
     *
     * @return Closing time
     */
    public LocalTime getClosingTime() {
        return closingTime;
    }

    /**
     * Checks if current time is during office hours.
     *
     * @return True if current time is during office hours
     */
    public boolean isCurrentlyOpen() {
        if (!openStatus) {
            return false;
        }

        LocalTime now = LocalTime.now();
        return (now.isAfter(openingTime) && now.isBefore(closingTime));
    }

    /**
     * Displays information about the office.
     */
    public void displayOfficeInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");

        System.out.println("\n--- Office Information ---");
        System.out.println("Status: " + (openStatus ? "Open" : "Closed"));
        System.out.println("Total Employees: " + numEmployees);
        System.out.println("Monthly Budget: $" + budget);
        System.out.println("Office Hours: " +
                openingTime.format(formatter) + " to " +
                closingTime.format(formatter));
        System.out.println("Currently: " +
                (isCurrentlyOpen() ? "Open for business" : "Closed"));
    }

    // Private utility method (helper method)
    private boolean isValidGrade(char grade) {
        return (grade == 'A' || grade == 'B' || grade == 'C');
    }

    // Main method for demonstration
    public static void main(String[] args) {
        // Create office with default values
        TheOfficeA DunderMifflin = new TheOfficeA();
        DunderMifflin.displayOfficeInfo();

        // Create office with custom values
        TheOfficeA michaelScottPaperCo = new TheOfficeA(25, 75000.0);
        michaelScottPaperCo.displayOfficeInfo();

        // Create office with custom hours
        TheOfficeA DwightOffice = new TheOfficeA(15, 50000.0, 10, 30, 19, 0);
        DwightOffice.displayOfficeInfo();

        // Demonstration of setters with validation
        System.out.println("\nTesting validation:");
        michaelScottPaperCo.setNumEmployees(60); // Should show error message
        michaelScottPaperCo.setBudget(5000.0);   // Should show error message
    }
}