import java.util.ArrayList;
import java.util.List;

class Employee{
    private List<Integer> numEmployees;
    private List<Double> budget;
    boolean openStatus;

   public Employee(){
        this.numEmployees = new ArrayList<>();
        this.budget = new ArrayList<>();
        this.openStatus = false;
        System.out.println("New office created with default values.");
    }

    public Employee(List<Integer>Employees,List<Double>budget){
        this.numEmployees = new ArrayList<>(Employees);
        this.budget = new ArrayList<>(budget);
        openStatus= true;
    }

    //Setters and Getters Design
    public List<Integer> getNumEmployees(){
        return new ArrayList<> (numEmployees);
    }

    public List<Double> getbudget(){
        return  new ArrayList<> (budget);
    }

      public boolean isOpen() {
        return openStatus;
    }

    public void setNumEmployees(List<Integer> employees) {
        this.numEmployees = new ArrayList<>(employees);
    }

    public void setbudget(List<Double>budget){
        this.budget=new ArrayList<>(budget);
    }

    public void setOpenStatus(boolean status) {
        this.openStatus = status;
    }

// Display method
    public void displayOfficeInfo() {
        System.out.println("\n--- Office Information ---");
        System.out.println("Status: " + (openStatus ? "Open" : "Closed"));
        for (int i = 0; i < numEmployees.size(); i++) {
            System.out.println("Department " + (i + 1) +
                    " - Employees: " + numEmployees.get(i) +
                    ", Budget: $" + budget.get(i));
        }
    }
}

class TheOfficeDemo {

    public static void main(String[] args) {

        System.out.println("\n=== Creating Vance Refrigeration (Default Constructor) ===");
        Employee vanceRefrigeration = new Employee();
        vanceRefrigeration.displayOfficeInfo();

        System.out.println("\n=== Creating Dunder Mifflin Scranton (Parameterized Constructor) ===");
        List<Integer> scrantonEmployees = List.of(15, 30, 25, 10);
        List<Double> scrantonBudgets = List.of(75000.0, 120000.0, 95000.0, 150000.0);
        Employee dunderMifflin = new Employee(scrantonEmployees, scrantonBudgets);
        dunderMifflin.displayOfficeInfo();

        System.out.println("\n=== Expanding Vance Refrigeration ===");
        List<Integer> vanceEmployees = new ArrayList<>();
        vanceEmployees.add(8);
        List<Double> vanceBudget = new ArrayList<>();
        vanceBudget.add(50000.0);

        vanceRefrigeration.setNumEmployees(vanceEmployees);
        vanceRefrigeration.setbudget(vanceBudget);
        vanceRefrigeration.setOpenStatus(true);
        vanceRefrigeration.displayOfficeInfo();

        System.out.println("\n=== Adding New Department to Vance Refrigeration ===");
        List<Integer> updatedVanceEmployees = vanceRefrigeration.getNumEmployees();
        List<Double> updatedVanceBudget = vanceRefrigeration.getbudget();

        updatedVanceEmployees.add(12);
        updatedVanceBudget.add(65000.0);

        System.out.println("Number of departments: " + updatedVanceEmployees.size());
        System.out.println("First department employees: " + updatedVanceEmployees.get(0));
        System.out.println("Last department employees: " + updatedVanceEmployees.get(updatedVanceEmployees.size() - 1));

        try {
            System.out.println("Second department employees: " + updatedVanceEmployees.get(1));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Department index out of range!");
        }

        if (!updatedVanceEmployees.isEmpty()) {
            System.out.println("Vance Refrigeration has departments.");
        }

        // Remove last department
        if (!updatedVanceEmployees.isEmpty()) {
            updatedVanceEmployees.remove(updatedVanceEmployees.size() - 1);
            updatedVanceBudget.remove(updatedVanceBudget.size() - 1);
        }

        vanceRefrigeration.setNumEmployees(updatedVanceEmployees);
        vanceRefrigeration.setbudget(updatedVanceBudget);
        vanceRefrigeration.displayOfficeInfo();
    }
}
