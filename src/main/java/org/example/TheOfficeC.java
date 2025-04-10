package org.example;
/*
@Author Adams
          Topics: Java Collections (ArrayList).
                 Pass By Reference.
                 Constructor Initialization.
                 Simple ArrayList Operations.
                 Memory management.

NOTES.
Java handles memory management through garbage collection,
unlike C++ which requires manual memory reallocation.
The equivalent of std::vector in Java is ArrayList.

Prerequisites:
Basic variables.
Basic Functions.
Classes and Objects.
*/
import java.util.ArrayList;
import java.util.List;

 public class TheOfficeC {
    // Private members
    private ArrayList<Integer> numEmployees;
    private ArrayList<Double> budget;
    private boolean openStatus;

    // Default constructor
    public TheOfficeC() {
        this.numEmployees = new ArrayList<>();
        this.budget = new ArrayList<>();
        this.openStatus = false;
        System.out.println("New office created with default values");
    }

    // Parameterized constructor with pass by reference (Java always passes objects by reference)
    public TheOfficeC(ArrayList<Integer> employees, ArrayList<Double> mBudget) {
        this.numEmployees = new ArrayList<>();
        this.budget = new ArrayList<>();

        setNumEmployees(employees); // validation
        setBudget(mBudget); // validation
        this.openStatus = true;
        System.out.println("Office initialized with provided employees and budgets.");
    }

    // Setter methods
    public void setNumEmployees(ArrayList<Integer> employees) {
        this.numEmployees = new ArrayList<>(employees); // Create a copy to avoid reference issues
    }

    public void setBudget(ArrayList<Double> mBudgets) {
        this.budget = new ArrayList<>(mBudgets); // Create a copy
    }

    public void setOpenStatus(boolean status) {
        this.openStatus = status;
    }

    // Getter methods
    public ArrayList<Integer> getNumEmployees() {
        return new ArrayList<>(numEmployees); // Return a copy to maintain encapsulation
    }

    public ArrayList<Double> getBudget() {
        return new ArrayList<>(budget); // Return a copy
    }

    public boolean isOpen() {
        return openStatus;
    }

    // Copy constructor equivalent (Java doesn't have built-in copy constructors like C++)
    public TheOfficeC(TheOfficeC other) {
        this.numEmployees = new ArrayList<>(other.numEmployees);
        this.budget = new ArrayList<>(other.budget);
        this.openStatus = other.openStatus;
        System.out.println("Copy constructor called.");
    }

    // Display method
    public void displayOfficeInfo() {
        System.out.println("\n--- Office Information ---");
        System.out.println("Status: " + (openStatus ? "Open" : "Closed"));

        for (int i = 0; i < numEmployees.size(); ++i) {
            System.out.println("Department " + (i + 1) +
                    " - Employees: " + numEmployees.get(i) +
                    ", Budget: $" + budget.get(i));
        }
    }

    /* Modern Java approach using streams would be:
    public void displayOfficeInfo() {
        System.out.println("\n--- Office Information ---");
        System.out.println("Status: " + (openStatus ? "Open" : "Closed"));

        IntStream.range(0, numEmployees.size())
                .forEach(i -> System.out.println("Department " + (i + 1) +
                                               " - Employees: " + numEmployees.get(i) +
                                               ", Budget: $" + budget.get(i)));
    }
    */
    public static void main(String[] args) {
        // Creating a default office
        System.out.println("\n=== Creating Vance Refrigeration (Default Constructor) ===");
        TheOfficeC vanceRefrigeration = new TheOfficeC();
        vanceRefrigeration.displayOfficeInfo();

        // Calling the Parameterized Constructor
        System.out.println("\n=== Creating DunderMifflin Scranton (Parameterized Constructor) ===");
        ArrayList<Integer> scrantonEmployees = new ArrayList<>(List.of(15, 30, 25, 10)); // Sales, Warehouse, Accounting, Management
        ArrayList<Double> scrantonBudgets = new ArrayList<>(List.of(75000.0, 120000.0, 95000.0, 150000.0));
        TheOfficeC dunderMifflin = new TheOfficeC(scrantonEmployees, scrantonBudgets);
        dunderMifflin.displayOfficeInfo();

        // Using copy constructor to create a competing branch
        System.out.println("\n=== Creating Stamford Branch (Copy Constructor) ===");
        TheOfficeC stamfordBranch = new TheOfficeC(dunderMifflin);  // Copy constructor called

        // Modifying the Stamford branch data using getters and setters
        ArrayList<Integer> stamfordEmployees = new ArrayList<>(List.of(20, 35, 28, 12));  // Different employee counts
        ArrayList<Double> stamfordBudgets = new ArrayList<>(List.of(80000.0, 130000.0, 98000.0, 160000.0));
        stamfordBranch.setNumEmployees(stamfordEmployees);
        stamfordBranch.setBudget(stamfordBudgets);
        stamfordBranch.displayOfficeInfo();

        // ILLUSTRATING ARRAYLIST OPERATIONS WITH VANCE REFRIGERATION

        // Expanding Vance Refrigeration
        System.out.println("\n=== Expanding Vance Refrigeration ===");
        ArrayList<Integer> vanceEmployees = new ArrayList<>(List.of(8));
        ArrayList<Double> vanceBudget = new ArrayList<>(List.of(50000.0));
        vanceRefrigeration.setNumEmployees(vanceEmployees);
        vanceRefrigeration.setBudget(vanceBudget);
        vanceRefrigeration.setOpenStatus(true);
        vanceRefrigeration.displayOfficeInfo();

        // Adding a new department to Vance Refrigeration
        System.out.println("\n=== Adding New Department to Vance Refrigeration ===");
        ArrayList<Integer> updatedVanceEmployees = vanceRefrigeration.getNumEmployees();
        ArrayList<Double> updatedVanceBudget = vanceRefrigeration.getBudget();

        updatedVanceEmployees.add(12);  // Add new department with 12 employees
        updatedVanceBudget.add(65000.0);  // Add budget for new department

        // ArrayList member functions demonstrations
        System.out.println("Number of departments: " + updatedVanceEmployees.size());
        System.out.println("First department employees: " + updatedVanceEmployees.get(0));
        System.out.println("Last department employees: " + updatedVanceEmployees.get(updatedVanceEmployees.size() - 1));

        // Exception handling
        try {
            System.out.println("Second department employees: " + updatedVanceEmployees.get(1));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Department index out of range!");
        }

        if (!updatedVanceEmployees.isEmpty()) {
            System.out.println("Vance Refrigeration has departments");
        }

        // Remove last department (equivalent to pop_back)
        if (!updatedVanceEmployees.isEmpty()) {
            updatedVanceEmployees.remove(updatedVanceEmployees.size() - 1);
            updatedVanceBudget.remove(updatedVanceBudget.size() - 1);
        }

        /*
        OTHER OPERATIONS IN JAVA COLLECTIONS:
        remove() - Remove elements by index or value
        clear() - Remove all elements
        addAll() - Add all elements from another collection
        contains() - Check if an element exists
        subList() - Get a portion of the list
        sort() - Sort the list (requires Comparator)
        */

        vanceRefrigeration.setNumEmployees(updatedVanceEmployees);
        vanceRefrigeration.setBudget(updatedVanceBudget);
        vanceRefrigeration.displayOfficeInfo();
    }
}
