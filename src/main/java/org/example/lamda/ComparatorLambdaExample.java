package org.example.lamda;

import java.util.Comparator;

public class ComparatorLambdaExample {
    public static void main(String[] args) {
        // Using a lambda expression to define a comparator for Integer
        Comparator<Integer> comparator = (Integer a, Integer b) -> {
            // Comparison logic: Return a negative number if a < b, 0 if a == b, positive if a > b
            return a - b;
        };

        // Test the comparator by comparing two integers
        System.out.println(comparator.compare(5, 10)); // Should return a negative number (-5)
        System.out.println(comparator.compare(10, 5)); // Should return a positive number (5)

    }
}
