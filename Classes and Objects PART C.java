
class TheOffice {

    private int numEmployees;
    private double budget;
    private boolean openStatus;

    // Default constructor.
    public TheOffice() {
        this(0, 10_000.0, false);
        System.out.println("New Office Created Default Constructor)");
    }

    // Parameterized constructor.
    public TheOffice(int employees, double budget) {
        this(employees, budget, true);
    }

     //Master Constructor.
    private TheOffice(int employees, double budget, boolean status) {
        this.numEmployees = employees;
        this.budget = budget;
        this.openStatus = status;
    }

    public void displayOfficeInfo() {
        System.out.println("\n--- Office Information ---");
        System.out.println("Status: " + (openStatus ? "Open" : "Closed"));
        System.out.println("Employees: " + numEmployees);
        System.out.printf("Budget: $%.2f%n", budget);
    }
     public static void main(String[] args) {

        System.out.println("Welcome to The Office - Memory Management Edition\n");

        // ---------------------------------------
        // C++: theOffice* VanceFrigeration { nullptr };
        // Java Equivalent: Just declare a reference (it’s null by default)
        // ---------------------------------------
        TheOffice vanceFrigeration = null;

        // C++: new theOffice{};
        // Java: 'new' allocates on the heap automatically
        vanceFrigeration = new TheOffice();

        vanceFrigeration.displayOfficeInfo();

        // C++: delete VanceFrigeration;
        // Java: Not needed! Garbage collector handles cleanup
        vanceFrigeration = null; // Hint to GC (Optional)
        System.gc(); // Gentle suggestion to run GC — not required

        // ---------------------------------------
        // 2Second Office Instance
        // ---------------------------------------
        TheOffice dwightPaper = new TheOffice(15, 200_000.0);
        dwightPaper.displayOfficeInfo();

        // In C++ you would delete manually:
        // delete DwightPaper;
        // In Java, no explicit delete — memory is reclaimed automatically

        dwightPaper = null; //Optional The reference is dropped, object becomes eligible for GC


        System.out.println("\n End of demo. All offices cleaned up automatically by the JVM.");
    }
}
