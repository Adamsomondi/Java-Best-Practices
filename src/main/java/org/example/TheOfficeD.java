package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/*
 * Java implementation of the C++ TheOffice class
 * This version uses ArrayList instead of vectors
 */

class TheOfficeD {
    // Private fields
    private ArrayList<Integer> numEmployees;
    private ArrayList<Double> budget;
    private boolean openStatus;
    private static int officeCount = 0; // Static counter for offices created

    // Default constructor
    public TheOfficeD() {
        numEmployees = new ArrayList<>();
        budget = new ArrayList<>();
        openStatus = false;
        ++officeCount;
        System.out.println("New office created with default values");
    }

    // Parameterized constructor
    public TheOfficeD(ArrayList<Integer> employees, ArrayList<Double> budgets) {
        numEmployees = new ArrayList<>();
        budget = new ArrayList<>();
        setNumEmployees(employees); // validation
        setBudget(budgets); // validation
        openStatus = true;
        ++officeCount;
        System.out.println("Office initialized with provided employees and budgets.");
    }

    // Copy constructor (Java doesn't have built-in copy constructors, so we implement manually)
    public TheOfficeD(TheOfficeD other) {
        this.numEmployees = new ArrayList<>(other.numEmployees);
        this.budget = new ArrayList<>(other.budget);
        this.openStatus = other.openStatus;
        ++officeCount;
        System.out.println("Copy constructor called.");
    }

    // Setter methods
    public void setNumEmployees(ArrayList<Integer> employees) {
        numEmployees = new ArrayList<>(employees);
    }

    public void setBudget(ArrayList<Double> budgets) {
        budget = new ArrayList<>(budgets);
    }

    public void setOpenStatus(boolean status) {
        openStatus = status;
    }

    // Getter methods
    public ArrayList<Integer> getNumEmployees() {
        return new ArrayList<>(numEmployees);
    }

    public ArrayList<Double> getBudget() {
        return new ArrayList<>(budget);
    }

    public boolean isOpen() {
        return openStatus;
    }

    // Static method to get office count
    public static int getOfficeCount() {
        return officeCount;
    }

    // Display method
    public void displayOfficeInfo() {
        System.out.println("\n--- Office Information ---");
        System.out.println("Status: " + (openStatus ? "Open" : "Closed"));

        for (int i = 0; i < numEmployees.size(); ++i) {
            System.out.println("Department " + (i + 1) + " - Employees: " + numEmployees.get(i)
                    + ", Budget: $" + budget.get(i));
        }
    }
    public static void main(String[] args) {
        // Creating a default office
        System.out.println("\n=== Creating Vance Refrigeration (Default Constructor) ===");
        TheOfficeD vanceRefrigeration = new TheOfficeD();
        vanceRefrigeration.displayOfficeInfo();

        // Calling the Parameterized Constructor
        System.out.println("\n=== Creating Dunder Mifflin Scranton (Parameterized Constructor) ===");
        ArrayList<Integer> scrantonEmployees = new ArrayList<>(List.of(15, 30, 25, 10)); // Sales, Warehouse, Accounting, Management
        ArrayList<Double> scrantonBudgets = new ArrayList<>(List.of(75000.0, 120000.0, 95000.0, 150000.0));
        TheOfficeD dunderMifflin = new TheOfficeD(scrantonEmployees, scrantonBudgets);
        dunderMifflin.displayOfficeInfo();

        // Reverse iteration over DunderMifflin employees.
        System.out.print("Reverse iteration over dunderMifflin employees: ");
        for (int i = scrantonEmployees.size() - 1; i >= 0; i--) {
            System.out.print(scrantonEmployees.get(i) + " ");
        }
        System.out.println();

        // Random Access
        System.out.println("Using list indexing to do random access: " + scrantonBudgets.get(2));

        // Using copy constructor to create a competing branch
        System.out.println("\n=== Creating Stamford Branch (Copy Constructor) ===");
        TheOfficeD stamfordBranch = new TheOfficeD(dunderMifflin);  // Copy constructor called

        // Modifying the Stamford branch data using getters and setters
        ArrayList<Integer> stamfordEmployees = new ArrayList<>(List.of(20, 35, 28, 12));  // Different employee counts
        ArrayList<Double> stamfordBudgets = new ArrayList<>(List.of(80000.0, 130000.0, 98000.0, 160000.0));
        stamfordBranch.setNumEmployees(stamfordEmployees);
        stamfordBranch.setBudget(stamfordBudgets);
        stamfordBranch.displayOfficeInfo();

        // Backward iteration over Stamford budgets
        System.out.println("Backward iteration over Stamford budgets: ");
        ListIterator<Double> it = stamfordBudgets.listIterator(stamfordBudgets.size());
        while (it.hasPrevious()) {
            System.out.println(it.previous() + " ");
        }

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

        // Accessing elements with exception handling
        try {
            System.out.println("Second department employees: " + updatedVanceEmployees.get(1));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Department index out of range!");
        }

        if (!updatedVanceEmployees.isEmpty()) {
            System.out.println("Vance Refrigeration has departments");
        }

        // Remove last department
        if (!updatedVanceEmployees.isEmpty()) {
            updatedVanceEmployees.remove(updatedVanceEmployees.size() - 1);
            updatedVanceBudget.remove(updatedVanceBudget.size() - 1);
        }

        // Iteration using for-each loop (equivalent to begin/end iterators in C++)
        System.out.println("The employees are: ");
        for (Integer employee : updatedVanceEmployees) {
            System.out.println(employee);
        }

        vanceRefrigeration.setNumEmployees(updatedVanceEmployees);
        vanceRefrigeration.setBudget(updatedVanceBudget);
        vanceRefrigeration.displayOfficeInfo();

        // Display the total number of office objects created
        System.out.println("\nTotal offices created so far: " + TheOfficeD.getOfficeCount());
    }
}
