
/*
Author @Adams
PART B TOPICS: Objects on the Heap.
             Memory Management Basics in Java.

Basic Variables
Basic Functions
Classes and Objects Part A.

NOTE: In Java, memory management is handled by the Java Virtual Machine (JVM)
      and its Garbage Collector. Unlike C++, Java doesn't require explicit
      memory management with 'new' and 'delete'.
*/
package org.example;

import java.lang.ref.WeakReference;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TheOfficeB{
    // Static constants (class variables)
    private static final int MAX_EMPLOYEES = 50;
    private static final double MIN_BUDGET = 10000.0;

    // Instance variables
    private int numEmployees = 0;
    private double budget = 0.0;
    private boolean openStatus = false;
    private  final LocalTime openingTime;
    private  final LocalTime closingTime;

    /**
     * Default Constructor.
     */
    public TheOfficeB() {
        // Default values already set
        this.openingTime = LocalTime.of(9, 0);
        this.closingTime = LocalTime.of(17, 0);
        System.out.println("New office created with default values");
    }

    /**
     * Parameterized Constructor.
     */
    public TheOfficeB(int employees, double budget) {
        this.openingTime = LocalTime.of(9, 0);
        this.closingTime = LocalTime.of(17, 0);

        // Use setter methods for validation
        setNumEmployees(employees);
        setBudget(budget);
        this.openStatus = true;
    }

    // Setter methods with validation
    public void setNumEmployees(int employees) {
        if (employees >= 0 && employees <= MAX_EMPLOYEES) {
            this.numEmployees = employees;
        } else {
            System.out.println("Invalid employee count. Must be between 0 and "
                    + MAX_EMPLOYEES);
        }
    }

    public void setBudget(double budget) {
        if (budget >= MIN_BUDGET) {
            this.budget = budget;
        } else {
            System.out.println("Budget must be at least $" + MIN_BUDGET);
        }
    }

    public void setOpenStatus(boolean status) {
        this.openStatus = status;
    }

    // Getter methods
    public int getNumEmployees() {
        return numEmployees;
    }

    public double getBudget() {
        return budget;
    }

    public boolean isOpen() {
        return openStatus;
    }

    public void displayOfficeInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");

        System.out.println("\n--- Office Information ---");
        System.out.println("Status: " + (openStatus ? "Open" : "Closed"));
        System.out.println("Total Employees: " + numEmployees);
        System.out.println("Monthly Budget: $" + budget);
        System.out.println("Office Hours: " +
                openingTime.format(formatter) + " to " +
                closingTime.format(formatter));
    }
    // Main method demonstrating memory management in Java
    public static void main(String[] args) {

        // 1. Object Creation - In Java, all objects are created on the heap automatically
        System.out.println("\n1. Creating objects - all objects in Java are on the heap:");
        TheOfficeB DunderMifflin = new TheOfficeB();
        DunderMifflin.displayOfficeInfo();

        // 2. Reference Variables - Java uses references to heap objects (similar to pointers)
        System.out.println("\n2. Reference Variables:");
        TheOfficeB vanceRefrigeration = null;  // Null reference (similar to nullptr in C++)
        vanceRefrigeration = new TheOfficeB();  // Now points to an object on heap
        vanceRefrigeration.displayOfficeInfo();

        // 3. Parameterized constructor
        System.out.println("\n3. Using parameterized constructor:");
        TheOfficeB dwightPaper = new TheOfficeB(15, 20000.0);
        dwightPaper.displayOfficeInfo();

        // 4. Multiple references to same object
        System.out.println("\n4. Multiple references to same object:");
        TheOfficeB branch1 = new TheOfficeB(10, 15000.0);
        TheOfficeB branch2 = branch1;  // Both reference the same object
        branch1.setNumEmployees(12);
        System.out.println("branch2 employees (changed via branch1): " + branch2.getNumEmployees());

        // 5. Setting reference to null allows object to be garbage collected
        System.out.println("\n5. Nullifying references allows garbage collection:");
        branch1 = null;  // Object still referenced by branch2
        System.out.println("branch1 nullified, branch2 still valid");
        branch2 = null;  // Now object can be garbage collected
        System.out.println("branch2 nullified, object eligible for garbage collection");

        // 6. Weak References - alternative to C++ smart pointers
        System.out.println("\n6. Weak References (similar to weak_ptr in C++):");
        TheOfficeB michaelScottPaperCo = new TheOfficeB(5, 12000.0);
        WeakReference<TheOfficeB> weakRef = new WeakReference<>(michaelScottPaperCo);

        System.out.println("Weak reference created, object still strongly referenced");
        TheOfficeB retrievedOffice = weakRef.get();  // Get the referenced object
        if (retrievedOffice != null) {
            retrievedOffice.displayOfficeInfo();
        }

        System.out.println("Removing strong reference, making object eligible for GC");
        michaelScottPaperCo = null;  // Remove strong reference

        // 7. Memory Leaks in Java
        System.out.println("\n7. Memory Leaks in Java - can still occur despite GC:");
        System.out.println("   Common causes: unclosed resources, static collections,");
        System.out.println("   inner class references, thread-local variables.");

        // No need for 'delete' operations
    }
}