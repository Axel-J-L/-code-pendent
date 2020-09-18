package DartSystem;
// Hey this is a demonstration for commit (D)
import java.time.Year;
import java.util.*;

public class Employee {

   public Employee() {
    }
    Employee[] employeeDB;
    Employee[] employeeBridge;
    UUID employeeId;
    String name;
    int birthYear;
    String address;
    int grossSalary;



    // I think the employeeMenu might be better in the DartController class (D)
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
                Customer.addCustomer();
            }
            case "d" -> {
                System.out.println("Remove customer: ");
                Customer.removeCustomer();
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


    public void addEmployee() {
        /*
        TODO eventually move the salary portion (great work, looks super good!) to the salary method (D)
         add the portion that inserts the created employee into an array (D)
         */

        // changed the variables to be the class ones :D (D)
        Helper input = new Helper(); // Create new Helper object
        // java method to extract current year and java method to convert that value to a int - (d)
        // generate a ID and ask for employee name & stores the name
        this.employeeId = UUID.randomUUID();
        String askName = "Employee name: ";
        this.name = input.getInput(askName);

        // asks for birth year then subtracts that from currentYear (we ideally want to make this represent the current year)
        // then calculates age
        String askBirthYear = "Employee birth year: ";
        this.birthYear=input.getInt(askBirthYear);
        Helper year = new Helper();
        int age=year.CURRENT_YEAR-birthYear;

        // asks for gross salary and using the method below will generate net salary;
        String askSalary=("Ask the Gross salary: ");
        int employeeGrossSalary=input.getInt(askSalary);
        this.grossSalary = employeeGrossSalary; // I think this is correct but i could be wrong (D)
        double netSalary=0;
        // TODO move this to a salary method its down at the bottom
        //  (Navya I believe you made this let me know if you think this is a good idea -(D)
            if(grossSalary<100000) {
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
                }

           }
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


    public void removeEmployee() {
        // TODO implement a method to remove employee's from the employee array
        // add a function to print name followed by ID so that you can see the ID associated with employee when removing-(D)
        Helper input=new Helper();
        String removeName = "Type ID to remove associated employee: ";
        this.name = input.getInput(removeName);


    }
    /**
     * 
     */
    public static void viewEmployees() {
        // TODO make not static
        // TODO Create a loop that runs through the employees within our array of employee obects until it hits an 'empty' slot
        System.out.println("These are all the employees: ");
    }


    public void salary() {
        // TODO implement here
    }

}