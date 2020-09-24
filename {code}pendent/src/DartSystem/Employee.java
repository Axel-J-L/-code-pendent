package DartSystem;
import java.time.Year;
import java.util.UUID;

public class Employee {

    private UUID employeeID;
    private String name;
    private int birthYear;
    private String address;
    private double grossSalary;
    private static Employee[] employees =  new Employee[4];


    private final double MIN_SALARY=100000.00;
    private final double  BONUS_LOW=4000.00;
    private final double BONUS_MEDIUM=6000.00;
    private final double BONUS_HIGH=7500.00;
    private final int FIRST_AGE_FOR_BONUS=22;
    private final int SECOND_AGE_FOR_BONUS=30;

    Helper helper = new Helper();

    public Employee(){

    }

    public Employee(String name, int birthYear, String address, double salary) {
        this.employeeID = genEmployeeUUID();
        this.name = name;
        this.grossSalary = salary;
        this.birthYear = birthYear;
        this.address = address;

    }

    /*==========================Add Employee=========================*/
//  this is how i think it should be done... -(D) but in a different class.

//        public Employee[] addEmployee(Employee employee, Employee[] employeeArr) {
//            for (int i = 0; i < employeeArr.length; i++) {
//                if (employeeArr[i] != null) {
//                    continue;
//                } else {
//                    employeeArr[i] = employee;
//                    i = employeeArr.length;
//                    //break; // I WILL FIGHT YOU
//                }
//            }
//            return employeeArr;
//        }

    public void addEmployee() {

        if (employees[employees.length - 1] != null) {
            helper.increaseEmployeeArr(employees);
        }
        System.out.print("Creating an Employee. Please type the Employee’s:\n");
        System.out.print("Name: ");
        String name = helper.input.nextLine();

        System.out.print("Birth year: ");
        int birthYear = helper.input.nextInt();
        helper.input.nextLine();

        System.out.print("Address: ");
        String address = helper.input.nextLine();

        System.out.print("Monthly gross salary: ");
        double monthlySalary = helper.input.nextDouble();
        grossSalary = monthlySalary * 12;
        helper.input.nextLine();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                continue; //starts the loop over until you get = null
            } else {
                employees[i] = new Employee(name, birthYear, address, grossSalary);
                System.out.println(employees[i].toString());
                i = employees.length;
                //break; // I WILL FIGHT YOU
            }
        }
    }



    /*==========================Remove Employee=========================*/
//                                        i believe it should be done but in a different class

//                public Employee[] removeEmployee (UUID employeeID, Employee[]employeeArr){
//                    for (int i = 0; i < employeeArr.length; i++) { // goes through the array fed into method
//                        if (employeeArr[i] == null) continue;
//                        if (!employeeArr[i].getEmployeeID().equals(employeeID)) { //  it doesnt equal our employee to remove do nothing.
//                            continue;
//                        } else {
//                            employeeArr[i] = null; // if it does have the employee we want to remove. (Ternary statement?)
//                            i = employeeArr.length;
//                        }
//                    }
//
//                    for (int j = 0; j < employeeArr.length - 1; j++) { //runs through the array
//                        if (employeeArr[j] != (null) && employeeArr[j + 1] != null) { // position j != null && position j+1 != null
//                            continue; //do nothing
//                        } else if (employeeArr[j] == (null) && employeeArr[j + 1] != null) { // position j = null && position j+1 !=null
//                            employeeArr[j] = employeeArr[j + 1]; // position j = position j + 1\
//                            employeeArr[j + 1] = null;
//                        } else {
//                            j = employeeArr.length; // only other situation would be position j && j+1 == null which means the array has two nulls in a row
//                        }
//                    }
//
//                    return employeeArr;
//                }


    public Employee[] removeEmployee() {
        viewEmployees();
        boolean exists = false;
        System.out.print("Which employee should be removed? ID: ");
        UUID enteredUUID = UUID.fromString(helper.input.nextLine());
        for (int i = 0; i < employees.length; i++) { // goes through the array fed into method
            String deletedName = "";
            if (employees[i] == null) continue;
            if (!employees[i].getEmployeeID().equals(enteredUUID)) { //  it doesnt equal our employee to remove do nothing.
                continue;
            } else {
                deletedName = employees[i].getName();
                employees[i] = null; // if it does have the employee we want to remove. (Ternary statement?)
                exists = true;
                i = employees.length;
            }
            if (exists) {
                System.out.println("\nEmployee " + deletedName + " removed.");
            } else {
                System.out.println("no employee with that UUID exists."); // doesnt reach this statement
            }
        }
// would like to change the above nested if mess to switch
//        switch (enteredUUID) {
//            case "1":
//                break;
//            case "2":
//                break;
//            case "3":
//                break;
//            case "4":
//                break;
//            case "5":
//                break;
//            case "6":
//                break;
//            case "7":
//                break;
//            default: System.out.println("no match");
//                break;
//        }

        for (int j = 0; j < employees.length - 1; j++) { //runs through the array
            if (employees[j] != (null) && employees[j + 1] != null) { // position j != null && position j+1 != null
                continue; //do nothing
            } else if (employees[j] == (null) && employees[j + 1] != null) { // position j = null && position j+1 !=null
                employees[j] = employees[j + 1]; // position j = position j + 1\
                employees[j + 1] = null;
            } else {
                j = employees.length; // only other situation would be position j && j+1 == null which means the array has two nulls in a row
            }
        }
        helper.trimArray(employees);
        return employees;
    }

    public static void authEmployee() {
        String password = "password123";
        Helper Authorize = new Helper();
        Boolean authSuccess = Authorize.authenticate(password);

        if (authSuccess) {
            EmployeeMenu employeeMenu = new EmployeeMenu();
            employeeMenu.employeeMenu();
        } else {
            System.out.println("\n*** Wrong password ***\n");
            DartController mainMenu = new DartController();
            mainMenu.DartController();
        }
    }


    public void viewEmployees() {
        for (Employee employee : employees) { // for-each loop
            if (employee == null) return;
                System.out.println(employee.toString());
        }
    }


    public double netSalary() {
        Helper year = new Helper();
        int age = year.CURRENT_YEAR - birthYear;
        double netSalary = 0;
        //public static final double MIN_SALARY=100000.00;
        if (grossSalary < MIN_SALARY) {
            netSalary = grossSalary;

        } else {
            if (grossSalary >= MIN_SALARY) {
                netSalary = grossSalary - ((30.0 / 100) * grossSalary);
            }
        }
        double bonus;
        if (age < FIRST_AGE_FOR_BONUS) {
            bonus = BONUS_LOW;
            netSalary = netSalary + bonus;
        } else if (age == FIRST_AGE_FOR_BONUS && age < SECOND_AGE_FOR_BONUS) {
            bonus = BONUS_MEDIUM;
            netSalary = netSalary + bonus;
        } else if (age > SECOND_AGE_FOR_BONUS) {
            bonus = BONUS_HIGH;
            netSalary = netSalary + bonus;
        }
        return netSalary / 12;
    }
    // getters
    public String getName() {

        return name;
    }

    public double getSalary() {

        return netSalary();
    }

    public int getBirthYear() {

        return birthYear;
    }

    public String getAddress() {

        return address;
    }

    public UUID getEmployeeID() {

        return employeeID;
    }

    public Employee[] getEmployees() {

        return employees;
    }

    private UUID genEmployeeUUID() {

        return UUID.randomUUID();
    }

    public String toString() {
        return "\nEmployee:\nID: " + this.employeeID + "\nName: " + this.name + "\nBirth year: " + this.birthYear
                + "\nAddress: " + this.address + "\nNet salary: " + netSalary() + "\n";
    }
}


