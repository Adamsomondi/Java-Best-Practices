/* AUTHOR @Adams
   
   Best Practices on JAVA reference type Language features
   1.2 Functions with Primitive types Only.

  Prequisites:
  Basic Java variables.

   NOTE:
   In Java, primitive types are always passed by *value*.
   For small immutable values, passing by value is preferred.
*/

class BasicFunction{
    public static void main(String [] args){
        System.out.println("Test Case");

/*
Java Function Syntax
(public,private) static DataType Functionname(arguments){
  Statements;
    return expression; //when it returns a value
     }
*/

// Type inference in Java (introduced in Java 10) using 'var'
        var varia1 = 23;

        // Standard explicit initialization
        int varia2 = 2; // initialize at declaration

        // Fixed-width integer types do not exist in Java;
        // 'int' is always 32 bits, 'long' is 64 bits, etc.
        int preciseInt = 42;

        // final for compile-time constants
        final int msize = 100;

        /* 
         * EXTRA
         * final int DAYS_IN_WEEK = 7; // constants should use UPPERCASE names by convention
         * boolean isValid = false;    // initialize boolean values explicitly
         */

        // Function call: calculate the sum of varia and varia1
        System.out.println("The sum is " + add(varia1, varia2));

    }
    //The Declared Functions used to describe this
// Pass-by-value and Return-by-value: 
    // The method receives a copy of the argument.
    public static int add(int a, int b) {
        return a + b; // returns a copy of the sum
    }

    // Use `final` for compile-time constants (similar to constexpr in C++).
    // Java does not have constexpr, but `final` ensures immutability.
    public static int square(final int x) {
        return x * x;
    }

    // Use of throws to declare no checked exceptions (similar in spirit to noexcept)
    static int multiply(int a, int b) {
        return a * b;
    }
}