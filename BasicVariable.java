/* AUTHOR @Adams
   
   Best Pratices on Java Basic Language features.
*/

class BasicVariables{
    public static void main(String [] args){
        System.out.println("Test Case");
        String Adams = "Is the best Coder There Is";

     //  Constant values using 'final'
        final int DAYS_IN_WEEK = 7; // Constant (cannot be reassigned)
        final double PI = 3.14159;
        showConstants();  
        
    }
        public static void showConstants() {
        final int MAX_SIZE = 100; // 'final' for compile-time constant
        System.out.println("Max size constant: " + MAX_SIZE);
    }
}