/* Author @Adams Omondi Nyandiga
    PART A:Simple Concepts.

    Best Practices in Classes and Objects in Java.
    With Primitive Type and Basic Functions.
    The office Design - I love the office Series.

   Prequisites:
   Basic variables.
   Basic functions.
   Theory in Class Design,Patterns,Principles.Bottom Up Approach Programming.
*/
class  TheOffice{
    
    // Static Members and Constants
    private static final int MAX_EMPLOYEES = 50;
    private static final double MIN_BUDGET = 10_000.0;

    // Instance Variables
    private int numEmployees;
    private double budget;
    private boolean openStatus;

    // Constructors
    /**
     * Default Constructor.
     * Initializes office with default values.
     */
    public TheOffice() {
        this(0, MIN_BUDGET, false);
        System.out.println("New office created with default values");
    }

    /**
     * Parameterized Constructor.
     * Initializes an office with specific employee count and budget.
     *
     * @param employees number of employees
     * @param budget monthly budget
     */
    public TheOffice(int employees, double budget) {
        this(employees, budget, true); // office opens on creation
    }

    /**
     * Master Constructor (used internally).
     */
    private TheOffice(int employees, double budget, boolean openStatus) {
        setNumEmployees(employees);
        setBudget(budget);
        setOpenStatus(openStatus);
    }

    // ==============================
    // Getters and Setters
    // ==============================

    public int getNumEmployees() {
        return numEmployees;
    }

    public double getBudget() {
        return budget;
    }

    public boolean isOpen() {
        return openStatus;
    }

    /**
     * Sets number of employees with validation.
     */
    public void setNumEmployees(int employees) {
        if (employees < 0 || employees > MAX_EMPLOYEES) {
            throw new IllegalArgumentException(
                "Invalid employee count: must be between 0 and " + MAX_EMPLOYEES
            );
        }
        this.numEmployees = employees;
    }

    /**
     * Sets the office budget with validation.
     */
    public void setBudget(double budget) {
        if (budget < MIN_BUDGET) {
            throw new IllegalArgumentException(
                "Budget must be at least $" + MIN_BUDGET
            );
        }
        this.budget = budget;
    }

    /**
     * Sets the office open/closed status.
     */
    public void setOpenStatus(boolean status) {
        this.openStatus = status;
    }

    // ==============================
    // Business Logic
    // ==============================

    /**
     * Displays office information.
     */
    public void displayOfficeInfo() {
        System.out.println("\n--- Office Information ---");
        System.out.println("Status: " + (openStatus ? "Open" : "Closed"));
        System.out.println("Total Employees: " + numEmployees);
        System.out.printf("Monthly Budget: $%.2f%n", budget);
    }

    /**
     * Teaser: Demonstrating lambdas and streams for modern Java students to be discussed next
     * Let’s calculate some playful stats on office productivity.
     */
    
    public static void main(String [] args ){

        TheOffice dunderMifflin = new TheOffice();
        dunderMifflin.displayOfficeInfo();

        TheOffice michaelScottPaperCo = new TheOffice(25, 75_000.0);
        michaelScottPaperCo.displayOfficeInfo();

        //validation in action:
        michaelScottPaperCo.setNumEmployees(60);
        michaelScottPaperCo.setBudget(5000.0);

        System.out.println("\nLesson: Classes are blueprints. Objects are real things.");

    }

    }