package DartSystem;
// Hey this is a demonstration for commit (D)
import java.util.*;

public class Employee {

   public Employee() {
    }

    UUID employeeId;
    String name;
    int birthYear;
    String address;
    int grossSalary;



    // I think the employeeMenu might be better in the DartController class (D)
    public static void employeeMenu() {
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

        switch(userInput.toLowerCase())
        {
            case "a":
                System.out.println("Register a game");
                break;
            case "b":
                System.out.println("Remove game");
                break;
            case "c":
                System.out.println("Register a customer");
                break;
            case "d":
                System.out.println("Remove customer: ");
                break;
            case "e":
                System.out.println("Show total rent profit");
                break;
            case "f":
                System.out.println("View all games: ");
                break;
            case "r":
                System.out.println("Return to main menu: ");
                break;
            default:
                System.out.println("no match");
        }
    }


    public void addEmployee() {
        /*
                                        TODO list
        1. eventually move the salary portion (great work, looks super good!) to the salary method (D)
        2. add the portion that inserts the created employee into an array (D)
         */

        // changed the variables to be the class ones :D (D)
        //
        Helper input = new Helper(); // Create new Helper object

        // generate a ID and ask for employee name & stores the name
        this.employeeId = UUID.randomUUID();
        String askName = "Employee name: ";
        this.name = input.getInput(askName);

        // asks for birth year then subtracts that from currentYear (we ideally want to make this represent the current year)
        // then calculates age
        String askBirthYear = "Employee birth year: ";
        this.birthYear=input.getInt(askBirthYear);
        int currentYear = 2020;
        int age=birthYear-currentYear;

        // asks for gross salary and using the method below will generate net salary;
        String askSalary=("Ask the Gross salary: ");
        int employeeGrossSalary=input.getInt(askSalary);
        this.grossSalary = employeeGrossSalary; // I think this is correct but i could be wrong (D)
        double netSalary=0;

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
        if(age<22) {
            bonus = 4000;
            netSalary = netSalary + bonus;
            System.out.print("Employee's net salary with bonus :"+netSalary);
        }else
            if(age==22&&age<30){
                bonus=6000;
                netSalary=netSalary+bonus;
                System.out.print("Employee's net salary with bonus :"+netSalary);
            }else
                if(age>30) {
                    bonus = 7500;
                    netSalary = netSalary + bonus;
                    System.out.print("Employee's net salary with bonus :"+netSalary);
                }

           }
        //int Salary;



    public String authEmployee() { //Checks and uses the Authenticator method from help class. Returns false if !=password (A)
        // TODO implement here
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
        //                  TODO
        // implement a method to remove employee's from the employee array
        Helper input=new Helper();
        String removeName = "Which user would you like to remove: ";
        // add a function to print ID's i believe
        this.name = input.getInput(removeName);


    }


    public void viewAll() {
        //                                    TODO
        // once we make the array this just needs to run through the array and print all valid elements. (D)
    }


    public void salary() {
        // TODO implement here
    }

}