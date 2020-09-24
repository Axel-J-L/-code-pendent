package DartSystem;
import java.util.*;

public class Employee {

    private UUID employeeID;
    private String name;
    private int birthYear;
    private String address;
    private double grossSalary;

    private final int currentYear = Calendar.getInstance().get(Calendar.YEAR);

    // Sample default array of objects to initiate Employees
    private static Employee[] employees = {
            new Employee("Andy", 1991, "Northside Rd 250", 200000),
            new Employee("Robert", 1984, "Lync St 1200", 150000),
            new Employee("Danny", 1983, "Maple Ave 110", 140000),
            new Employee("Daniel", 1996, "Northside Rd 250", 90000),
            new Employee("Jack", 1992, "Northside Rd 250", 160000),
            new Employee("Jill", 1981, "Pimmit Dr 2311", 210000)};

    Employee() {
    }

    Employee(String name, int birthYear, String address, double salary) {
        this.employeeID = UUID.randomUUID();
        this.name = name;
        this.birthYear = birthYear;
        this.address = address;
        this.grossSalary = salary;
    }

    /*==========================Add Employee=========================*/

    public void addNewEmployee() {
        // TODO make not static
        Scanner getInput = new Scanner(System.in);

        System.out.print("Enter new employee's name: ");
        String newEmployeeName = getInput.nextLine();

        System.out.print("Enter new employee's year of birth: ");
        int newEmployeeBirthYear = getInput.nextInt();
        getInput.nextLine();

        System.out.print("Enter new employee's address: ");
        String newEmployeeAddress = getInput.nextLine();

        System.out.print("Enter new employee's gross salary: ");
        double newEmployeeSalary = getInput.nextDouble();
        getInput.nextLine();

        Employee[] employeesNew = new Employee[employees.length + (employees.length/2)];

        for (int i = 0; i < employees.length; i++) {
            employeesNew[i] = employees[i];
        }
        employeesNew[employees.length] = new Employee(newEmployeeName, newEmployeeBirthYear, newEmployeeAddress, newEmployeeSalary);

        employees = employeesNew;

        int countArray = 0;
        for (int i = 0; employees[i] != null; i++){
            countArray = i;
        }

        System.out.println("Employee added successfully : " + "\n" + employees[countArray].employeeID + " : " + employees[countArray].name + " - " + employees[countArray].birthYear + " ( " + (currentYear - employees[countArray].birthYear) + " ): " + employees[countArray].grossSalary + " SEK.");

    }


    /*==========================Remove Employee=========================*/
    public void removeEmployee() {

        viewEmployees();

        Scanner getInput = new Scanner(System.in);
        System.out.print("Please enter employee UUID to remove: ");
        String idStringToRemove = getInput.nextLine();
        UUID idToRemove = UUID.fromString(idStringToRemove);

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].employeeID.equals(idToRemove)) {
                for (int j = i + 1; j < employees.length + 1; j++) {
                    if (i == employees.length - 1) {
                        employees[i] = null;
                    } else {
                        employees[i] = employees[j];
                        i++;
                    }
                }
            }
        }

        viewEmployees();
    }

    public static void authEmployee() {
        // TODO get fully fuctioning with no errors (see above comments)
        String password = "password123";
        Helper Authorize = new Helper();
        Boolean authSuccess = Authorize.Authenticator(password);

        if (authSuccess) {
            EmployeeMenu.employeeMenu();
        } else {
            System.out.println("\n*** Wrong password *** \n");
            DartController dart2 = new DartController();
            dart2.DartController();
        }
    }

    public String getName() {
        return this.name;
    }

    public double getSalary() {

        return this.grossSalary;
    }

    public int getBirthYear() {
        return this.birthYear;
    }

    public String getAddress() {
        return this.address;
    }

    public UUID getEmployeeID() {
        return this.employeeID;
    }

    private UUID genEmployeeUUID() {
        return UUID.randomUUID();
    }

    public void viewEmployees() {
        System.out.println("Employees:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].employeeID + " : " + employees[i].name + " - " + employees[i].birthYear + " ( " + (currentYear - employees[i].birthYear) + " ): " + employees[i].grossSalary + " SEK.");
            }
        }
    }


    /*public void calculateSalary() {
        Helper input = new Helper();
        String askBirthYear = "Employee birth year: ";
        this.birthYear = input.getInt(askBirthYear);
        Helper year = new Helper();
        int age = year.CURRENT_YEAR - birthYear;
        double netSalary = 0;


       //public static final double MIN_SALARY=100000.00;

        double minTaxableSalary = 100000;

        if(grossSalary<minTaxableSalary) {
            netSalary=grossSalary;

        } else  {
            if (grossSalary>=minTaxableSalary) {
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
    }*/

}
