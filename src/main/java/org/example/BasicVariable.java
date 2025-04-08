/*
  AUTHOR @Adams

  Best Practices on Java Basic Language Features
*/
package org.example;
 public class BasicVariable {
    public static void main(String[] args) {

        // Auto type deduction (Java 10+)
        var varia = 23;

        // Explicit primitive type initialization
        int varia1 = 2; // initialize at the time of creation

        // Fixed-width integer types: in Java, 'int' is always 32-bit
        int preciseInt = 42;

        // Compile-time constant (immutable)
        final int MAX_SIZE = 100;

        /* EXTRA */
        final int DAYS_IN_WEEK = 7; // for constant values
        boolean isValid = false;    // initialize boolean values explicitly

    }
}
