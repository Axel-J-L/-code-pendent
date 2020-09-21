package DartSystem;
import java.time.Year;
import java.util.*;

public class Employee {

   public Employee() {
    }
    private UUID employeeID;
    private String name;
    private int birthYear;
    private String address;
    private double grossSalary;
    final public static int INITIAL_ARRAY_SIZE = 4;
    Employee[] employees =  new Employee[INITIAL_ARRAY_SIZE];


    public static final double MIN_SALARY=100000.00;
    public static final double  BONUS_ONE=4000.00;
    public static final double BONUS_TWO=6000.00;
    public static final double BONUS_THREE=7500.00;


    public Employee(String name, int birthYear, String address, double salary) {
        this.name = name;
        this.grossSalary = salary;
        this.birthYear = birthYear;
        this.address = address;
        this.employeeID = genEmployeeUUID();

    }

    public void employeeMenu() {
        // TODO make not static
        // Finished for the moment
        System.out.println("<<< Employee menu >>>");
        System.out.println("Employee screen - Type one of the options below:");
        System.out.println("1. Enter \"A\" to register a game ");
        System.out.println("2. Enter \"B\" to remove a game");
        System.out.println("3. Enter \"C\" to register a customer");
        System.out.println("4. Enter \"D\" to remove a customer");
        System.out.println("5. Enter \"E\" to show total rent profit");
        System.out.println("6. Enter \"F\" to view all games");
        System.out.println("7. Enter \"R\" to return to main menu\n");
        String[] employeeMenuAcceptSet = {"A","a","B","b","C","c","D","d","E","e","F","f","R","r"}; // Accepted responses for menu options /A
        Helper getInput = new Helper(); // Getting new object from Helper /A
        String userInput = getInput.getMenuInput("Please enter your choice: ", employeeMenuAcceptSet); // using argument to call Helper method/A

        switch (userInput.toLowerCase()) {
            case "a" -> {
                System.out.println("Register a game");
                Game.addNewGame();
            }
            case "b" -> {
                System.out.println("Remove game");
                Game.removeGame();
            }
            case "c" -> {
                System.out.println("Register a customer");
                Customer addNewCustomer= new Customer();
                addNewCustomer.addCustomer();
            }
            case "d" -> {
                System.out.println("Remove customer: ");
                Customer removeOldCustomer= new Customer();
                removeOldCustomer.removeCustomer();
            }
            case "e" -> System.out.println("Show total rent profit");
            case "f" -> {
                System.out.println("View all games: ");
                Game.viewAll();
            }
            case "r" -> {
                System.out.println("Return to main menu: ");
                DartController.DartController();
            }
            default -> System.out.println("no match");
        }
    }
    /*==========================Add Employee=========================*/
        public Employee[] addEmployee(Employee employee, Employee[] employeeArr) {
            for (int i = 0; i < employeeArr.length; i++) {
                if (employeeArr[i] != null) {
                    continue;
                } else {
                    employeeArr[i] = employee;
                    i = employeeArr.length;
                    //break; // I WILL FIGHT YOU
                }
            }
            return employeeArr;
        }
    /*==========================Remove Employee=========================*/
    public Employee[] removeEmployee(UUID employeeID, Employee[] employeeArr) {
        for (int i = 0; i < employeeArr.length; i++) { // goes through the array fed into method
            if (employeeArr[i] == null) continue;
            if (!employeeArr[i].getEmployeeID().equals(employeeID)) { //  it doesnt equal our employee to remove do nothing.
                continue;
            } else {
                employeeArr[i] = null; // if it does have the employee we want to remove. (Ternary statement?)
                i = employeeArr.length;
            }
        }

        for (int j = 0; j < employeeArr.length-1; j++) { //runs through the array
            if (employeeArr[j] !=(null) && employeeArr[j + 1] != null) { // position j != null && position j+1 != null
                continue; //do nothing
            } else if (employeeArr[j] == (null) && employeeArr[j + 1] != null) { // position j = null && position j+1 !=null
                employeeArr[j] = employeeArr[j + 1]; // position j = position j + 1\
                employeeArr[j+1] = null;
            } else {
                j = employeeArr.length; // only other situation would be position j && j+1 == null which means the array has two nulls in a row
            }
        }

        return employeeArr;
    }



        // asks for gross salary and using the method below will generate net salary;
        //String askSalary=("Ask the Gross salary: ");
        //int employeeGrossSalary=input.getInt(askSalary);
        //this.grossSalary = employeeGrossSalary; // I think this is correct but i could be wrong (D)
        //double netSalary=0;
        // TODO move this to a salary method its down at the bottom
        //  (Navya I believe you made this let me know if you think this is a good idea -(D)
         /* if(grossSalary<100000) {
            netSalary=grossSalary;
           // System.out.print("Employee's net salary is " + grossSalary+" SEK");
        } else  {
           if (grossSalary>=100000){
                netSalary=grossSalary-((30.0/100)*grossSalary);
              // System.out.print("Employee's net salary is "+grossSalary+" SEK");
            }
        }
        double bonus;
        if(age<22) { // change to not be magic numbers instead constant - (n)
            bonus = 4000;
            netSalary = netSalary + bonus;
            System.out.print("Employee's net salary with bonus :"+netSalary);
        }else
            if(age==22&&age<30){ // change to not be magic numbers instead constant - (n)
                bonus=6000;
                netSalary=netSalary+bonus;
                System.out.print("Employee's net salary with bonus :"+netSalary);
            }else
                if(age>30) { // change to not be magic numbers instead constant - (n)
                    bonus = 7500;
                    netSalary = netSalary + bonus;
                    System.out.print("Employee's net salary with bonus :"+netSalary);
                }*/

        //int Salary;



    public String authEmployee() { //Checks and uses the Authenticator method from help class. Returns false if !=password (A)
                                    // ill take it look at it @(A) - (D)
        // TODO get fully fuctioning with no errors (see above comments)
        String password = "password123";
        Helper Authorize = new Helper();
        String authCheck = Authorize.Authenticator(password);

        if (authCheck.equals("success")){
            return "employee menu";
        } else {

            System.out.println("\n*** Wrong password *** \n");

            return "main menu";
        }
    }
    public String getName(){
        return name;
    }
    public double getSalary(){
        return grossSalary;
    }
    public int getBirthYear(){
        return birthYear;
    }
    public String getAddress(){
        return address;
    }
    public UUID getEmployeeID() { return employeeID;}

    private UUID genEmployeeUUID() {
        return UUID.randomUUID();
    }

    public String toString(){
        return " => Name: " + this.name + " => UUID: " + this.employeeID + "\n*---*\n";
    }


    /**
     * 
     */
    public void viewEmployees() {
        System.out.println("These are all the employees: ");
        for (Employee employee : employees) {
            if (employee == null) return;
            System.out.println(employee.toString());
        }
    }



    public void salary() {
        Helper input = new Helper();
        String askBirthYear = "Employee birth year: ";
        this.birthYear = input.getInt(askBirthYear);
        Helper year = new Helper();
        int age = year.CURRENT_YEAR - birthYear;
        double netSalary = 0;


       //public static final double MIN_SALARY=100000.00;
        if(grossSalary<MIN_SALARY) {
            netSalary=grossSalary;

        } else  {
            if (grossSalary>=MIN_SALARY) {
                netSalary = grossSalary - ((30.0 / 100) * grossSalary);
            }
        }
        double bonus;
        if(age<22) { // change to not be magic numbers instead constant - (n)
            bonus = 4000;
            netSalary = netSalary + bonus;
            System.out.print("Employee's net salary with bonus :"+netSalary);
        }else
        if(age==22&&age<30){ // change to not be magic numbers instead constant - (n)
            bonus=6000;
            netSalary=netSalary+bonus;
            System.out.print("Employee's net salary with bonus :"+netSalary);
        }else
        if(age>30) { // change to not be magic numbers instead constant - (n)
            bonus = 7500;
            netSalary = netSalary + bonus;
            System.out.print("Employee's net salary with bonus :"+netSalary);
        }

    }
}

