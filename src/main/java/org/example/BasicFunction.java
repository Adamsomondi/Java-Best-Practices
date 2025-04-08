package org.example;
/* AUTHOR @Adams
   Best Practices on Java Language features
   Functions with Primitive types Only
   Prerequisites:
   Basic variables.

*/
// In Java, functions are encapsulated within classes
public class BasicFunction{
    /*
    Function/Method Syntax in Java:
    accessModifier returnType methodName(arguments) {
      Statements;
      return expression; // when it returns a value
    }
    */

    // Pass-by-value: Java always passes primitive types by value
    public static int add(int a, int b) {
        return a + b; // returns a copy of the result
    }

    // Java doesn't have constexpr, but we can use final for constants
    // For compile-time constants, we use static final
    public static final int ARRAY_SIZE = 100;

    // Java doesn't have noexcept, exceptions are part of method signature
    // or unchecked (RuntimeException)
    public static int multiply(int a, int b) {
        return a * b;
    }

    /*
    NOTE:
        For primitive types in Java, pass by value is the only option.
        Use method overloading for default arguments (Java doesn't support default arguments).
        For reference types, Java still passes the reference by value (not the same as pass by reference).
    */

    public static void main(String[] args) {
        // Java has type inference with var (Java 10+)
        var varia = 23;

        // Standard initialization
        int varia1 = 2; // initialize at the time of creation

        // Java has fixed-width integer types
        long precise_int = 42L; // 64-bit integer
        int standard_int = 42;  // 32-bit integer

        // Constant values with final
        final int DAYS_IN_WEEK = 7; // for constant values
        boolean isValid = false;    // initialize boolean values explicitly

        // Function call
        // Calculate the sum of varia and varia1 variables
        System.out.println("The sum is " + add(varia, varia1));

        /*
        Return by value returns a new value
        We can only work with new value not the original data.
        */

        // Function call
        // Multiply the values of varia and varia1 variables
        System.out.println("The multiplication is " + multiply(varia, varia1));

        // Java doesn't evaluate at compile time like constexpr,
        // but final variables are constants
        final int result = square(ARRAY_SIZE); // evaluated at runtime
        System.out.println("Square result: " + result);
    }

    // Simple square method
    public static int square(int x) {
        return x * x;
    }
}