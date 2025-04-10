package org.example;

import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class TheOfficeF {

    // Private member variables
    private List<Integer> numEmployees; // Automatically initialized to empty
    private List<Double> budget; // Automatically initialized to empty
    private boolean openStatus;
    private static int officeCount = 0; // Static always initialized to zero explicitly

    // Default constructor
    public TheOfficeF() {
        this.numEmployees = new ArrayList<>();
        this.budget = new ArrayList<>();
        this.openStatus = false;
        ++officeCount;
        System.out.println("New office created with default values");
    }

    // Parameterized Constructor
    public TheOfficeF(List<Integer> employees, List<Double> Mbudget) {
        this.numEmployees = new ArrayList<>();
        this.budget = new ArrayList<>();
        setNumEmployees(employees); // validation
        setBudget(Mbudget); // validation
        this.openStatus = true;
        ++officeCount;
        System.out.println("Office initialized with provided employees and budgets.");
    }

    // Setter methods
    public void setNumEmployees(List<Integer> employees) {
        this.numEmployees = new ArrayList<>(employees);
    }

    public void setBudget(List<Double> Mbudgets) {
        this.budget = new ArrayList<>(Mbudgets);
    }

    public void setOpenStatus(boolean status) {
        this.openStatus = status;
    }

    // Getter methods
    public List<Integer> getNumEmployees() {
        return new ArrayList<>(numEmployees);
    }

    public List<Double> getBudget() {
        return new ArrayList<>(budget);
    }

    public boolean isOpen() {
        return openStatus;
    }

    // Static member function to get the count of offices
    public static int getOfficeCount() {
        return officeCount;
    }

    // Copy constructor equivalent (in Java we use clone or copy constructor pattern)
    public TheOfficeF(TheOfficeF other) {
        this.numEmployees = new ArrayList<>(other.numEmployees);
        this.budget = new ArrayList<>(other.budget);
        this.openStatus = other.openStatus;
        ++officeCount;
        System.out.println("Copy constructor called.");
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
        TheOfficeF VanceRefrigeration = new TheOfficeF();
        VanceRefrigeration.displayOfficeInfo();

        // Calling the Parameterized Constructor
        System.out.println("\n=== Creating Dunder Mifflin Scranton (Parameterized Constructor) ===");
        List<Integer> scranton_employees = new ArrayList<>();
        scranton_employees.add(15); // Sales
        scranton_employees.add(30); // Warehouse
        scranton_employees.add(25); // Accounting
        scranton_employees.add(10); // Management

        List<Double> scranton_budgets = new ArrayList<>();
        scranton_budgets.add(75000.0);
        scranton_budgets.add(120000.0);
        scranton_budgets.add(95000.0);
        scranton_budgets.add(150000.0);

        TheOfficeF DunderMifflin = new TheOfficeF(scranton_employees, scranton_budgets);
        DunderMifflin.displayOfficeInfo();

        // Reverse iteration over DunderMifflin budgets
        System.out.print("reverse iteration over DunderMifflin budgets: ");
        for (int i = scranton_employees.size() - 1; i >= 0; --i) {
            System.out.print(scranton_employees.get(i) + " ");
        }
        System.out.println();

        // Random Access - getting the third element
        System.out.println("Using direct access for random access: " + scranton_budgets.get(2));

        // Using at() method equivalent with exception handling
        try {
            // Using get() method to access the third element (index 2)
            System.out.println("Using get() method with exception handling: "
                    + scranton_budgets.get(2));
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Error: Index out of range. " + e.getMessage());
        }

        // Using copy constructor to create a competing branch
        System.out.println("\n=== Creating Stamford Branch (Copy Constructor) ===");
        TheOfficeF StamfordBranch = new TheOfficeF(DunderMifflin); // Copy constructor called

        // Modifying the Stamford branch data
        List<Integer> stamford_employees = new ArrayList<>();
        stamford_employees.add(20);
        stamford_employees.add(35);
        stamford_employees.add(28);
        stamford_employees.add(12);

        List<Double> stamford_budgets = new ArrayList<>();
        stamford_budgets.add(80000.0);
        stamford_budgets.add(130000.0);
        stamford_budgets.add(98000.0);
        stamford_budgets.add(160000.0);

        Collections.sort(stamford_employees);
        Collections.sort(stamford_budgets); // Default sorting (ascending)

        // Binary Search-Ensure Sorted Landscape before venturing to binary Search
        double value_to_search = 130000.0;

        // Java's Collections.binarySearch returns index directly
        int index = Collections.binarySearch(stamford_budgets, value_to_search);

        if (index >= 0) {
            System.out.println("Value " + value_to_search + " found at index: " + index);
        } else {
            int insertPoint = -index - 1; // where it would be inserted

            // Handle lower bound
            if (insertPoint > 0) {
                System.out.println("Lower bound for " + value_to_search + ": " + stamford_budgets.get(insertPoint - 1));
            } else {
                System.out.println("Lower bound not found for " + value_to_search);
            }

            // Handle upper bound
            if (insertPoint < stamford_budgets.size()) {
                System.out.println("Upper bound for " + value_to_search + ": " + stamford_budgets.get(insertPoint));
            } else {
                System.out.println("Upper bound not found for " + value_to_search);
            }
        }

        // Using binary search to search for 98000.0
        double search_budget = 98000.0;
        int searchIndex = Collections.binarySearch(stamford_budgets, search_budget);

        if (searchIndex >= 0) {
            System.out.println("Budget " + search_budget + " found at index: " + searchIndex);
        } else {
            System.out.println("Budget " + search_budget + " not found.");
        }

        StamfordBranch.setNumEmployees(stamford_employees);
        StamfordBranch.setBudget(stamford_budgets);
        StamfordBranch.displayOfficeInfo();

        // Backward iteration over Stamford budgets
        System.out.println("Backward iteration over Stamford budgets: ");
        for (int i = stamford_budgets.size() - 1; i >= 0; --i) {
            System.out.println(stamford_budgets.get(i) + " ");
        }

        // Expanding Vance Refrigeration
        System.out.println("\n=== Expanding Vance Refrigeration ===");
        List<Integer> vance_employees = new ArrayList<>();
        vance_employees.add(8);

        List<Double> vance_budget = new ArrayList<>();
        vance_budget.add(50000.0);

        VanceRefrigeration.setNumEmployees(vance_employees);
        VanceRefrigeration.setBudget(vance_budget);
        VanceRefrigeration.setOpenStatus(true);
        VanceRefrigeration.displayOfficeInfo();

        // Adding a new department to Vance Refrigeration
        System.out.println("\n=== Adding New Department to Vance Refrigeration ===");
        List<Integer> updated_vance_employees = VanceRefrigeration.getNumEmployees();
        List<Double> updated_vance_budget = VanceRefrigeration.getBudget();

        updated_vance_employees.add(12); // Add new department with 12 employees
        updated_vance_budget.add(65000.0); // Add budget for new department

        // Vector member functions demonstrations
        System.out.println("Number of departments: " + updated_vance_employees.size());
        System.out.println("First department employees: " + updated_vance_employees.get(0)); // front equivalent
        System.out.println("Last department employees: " + updated_vance_employees.get(updated_vance_employees.size() - 1)); // back equivalent

        // Accessing elements with bounds checking
        try {
            System.out.println("Second department employees: " + updated_vance_employees.get(1));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Department index out of range!");
        }

        if (!updated_vance_employees.isEmpty()) {
            System.out.println("Vance Refrigeration has departments");
        }

        // Remove last department (equivalent to pop_back)
        if (!updated_vance_employees.isEmpty()) {
            updated_vance_employees.remove(updated_vance_employees.size() - 1);
            updated_vance_budget.remove(updated_vance_budget.size() - 1);
        }

        // Iteration using for-each (equivalent to C++'s range-based for loop)
        for (Integer emp : updated_vance_employees) {
            System.out.println("The employees are: " + emp);
        }

        // Linear search (equivalent to std::find)
        int valueToFind = 12;
        int foundIndex = updated_vance_employees.indexOf(valueToFind);

        if (foundIndex != -1) {
            System.out.println("Value found: " + updated_vance_employees.get(foundIndex));
        } else {
            System.out.println("Value not found");
        }

        VanceRefrigeration.setNumEmployees(updated_vance_employees);
        VanceRefrigeration.setBudget(updated_vance_budget);
        VanceRefrigeration.displayOfficeInfo();

        // Demonstrating Deque (double-ended queue) functionality
        System.out.println("\n=== Demonstrating Deque Functionality ===");
        Deque<Integer> employeeDeque = new ArrayDeque<>();

        // Adding elements to both ends
        employeeDeque.addFirst(10); // Push to front
        employeeDeque.addLast(20);  // Push to back
        employeeDeque.addFirst(5);  // Push to front again
        employeeDeque.addLast(30);  // Push to back again

        System.out.println("Deque contents: " + employeeDeque);
        System.out.println("Front element: " + employeeDeque.peekFirst());
        System.out.println("Back element: " + employeeDeque.peekLast());

        // Removing elements from both ends
        System.out.println("Removed from front: " + employeeDeque.pollFirst());
        System.out.println("Removed from back: " + employeeDeque.pollLast());
        System.out.println("Deque after removals: " + employeeDeque);

        // Display the total number of office objects created
        System.out.println("\nTotal offices created so far: " + TheOfficeF.getOfficeCount());
    }
}