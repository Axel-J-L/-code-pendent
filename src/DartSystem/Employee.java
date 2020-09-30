package src.DartSystem;

import java.util.UUID;


public class Employee {

    private String employeeID;
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

    Helper tools = new Helper();
    private DartController dartController = new DartController();

    public Employee(){

    }

    public Employee(String name, int birthYear, String address, double salary) {
        this.employeeID = genEmployeeID();
        this.name = name;
        this.grossSalary = salary;
        this.birthYear = birthYear;
        this.address = address;

    }

    private String genEmployeeID() {
        String generatedID = UUID.randomUUID().toString();
        return generatedID;
    }

    public Employee addEmployee(){
        String name = tools.getInput("Name: ");
        int birthYear = tools.getInt("birth year: ");
        String address = tools.getInput("Address: ");
        double monthlySalary = tools.getDouble("Monthly gross salary: ");
        grossSalary = monthlySalary * 12;
        Employee employee = new Employee(name, birthYear, address, grossSalary);
        return employee;
    }
//    public void addEmployee() {
//        if (employees[employees.length - 1] != null) {
//            employees = tools.increaseEmployeeArr(employees);
//        }
//        String name = tools.getInput("Name: ");
//        int birthYear = tools.getInt("birth year: ");
//        String address = tools.getInput("Address: ");
//        double monthlySalary = tools.getDouble("Monthly gross salary: ");
//        grossSalary = monthlySalary * 12;
//        // tools.input.nextLine();
//        for (int i = 0; i < employees.length; i++) {
//            if (employees[i] != null) {
//                continue; //starts the loop over until you get = null
//            } else {
//                employees[i] = new Employee(name, birthYear, address, grossSalary);
//                System.out.println(employees[i].toString());
//                i = employees.length;
//                //break; // I WILL FIGHT YOU
//            }
//        }
//    }



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
        String enteredID = tools.getInput("Which employee should be removed? ID: ");
        for (int i = 0; i< employees.length-1; i++) { // iterates through the array of employees
            if (enteredID.equals(employees[i].employeeID)) { // once it finds the employee with the id it enters are next loop
                for (int j = i; j < employees.length-1; j++) { // once inside this loop it starts replacing the current index with the next one
                    employees[i] = employees[j+1]; //shifting
                    i++;
                }
                employees[employees.length-1] = null; // deletes the last position after the shift to get rid of duplicate
                i = employees.length; // YEAH I KNOW THIS IS TECHNICALLY A BREAK FIGHT ME!
            }
        }
        return employees;
    }

//   public static void authEmployee() {
//        String password = "password123";
//        Helper Authorize = new Helper();
//        Boolean authSuccess = Authorize.authenticate(password);
//
//        if (authSuccess) {
//            EmployeeMenu employeeMenu = new EmployeeMenu();
//            employeeMenu.employeeMenu();
//        } else {
//            System.out.println("\n*** Wrong password ***\n");
//            DartController mainMenu = new DartController();
//            mainMenu.DartController();
//        }
//    }


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

    public String getEmployeeID() {

        return employeeID;
    }

    public Employee[] getEmployees() {

        return employees;
    }

    public String toString() {
        return "\nEmployee:\nID: " + this.employeeID + "\nName: " + this.name + "\nBirth year: " + this.birthYear
                + "\nAddress: " + this.address + "\nNet salary: " + netSalary() + "\n";
    }
}


