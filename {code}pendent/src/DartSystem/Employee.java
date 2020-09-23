package DartSystem;
import jdk.swing.interop.SwingInterOpUtils;

import java.time.Year;
import java.util.*;

public class Employee {

    private UUID employeeID;
    private String name;
    private int birthYear;
    private String address;
    private double grossSalary;
    private final int INITIAL_ARRAY_SIZE = 4;

    private Employee[] employees =  new Employee[INITIAL_ARRAY_SIZE];


    private final double MIN_SALARY=100000.00;
    private final double  BONUS_LOW=4000.00;
    private final double BONUS_MEDIUM=6000.00;
    private final double BONUS_HIGH=7500.00;

    Helper helper = new Helper();

    public Employee(){

    }

    public Employee(String name, int birthYear, String address, double salary) {
        this.name = name;
        this.grossSalary = salary;
        this.birthYear = birthYear;
        this.address = address;
        this.employeeID = genEmployeeUUID();

    }

    /*==========================Add Employee=========================*/
// this is how i think it should be done... -(D) but in a different class that is actually responsible for keep track of employees...
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

        System.out.print("Enter new employee's name: ");
        String name = helper.input.nextLine();

        System.out.print("Enter new employee's year of birth: ");
        int birthYear = helper.input.nextInt();
        helper.input.nextLine();

        System.out.print("Enter new employee's address: ");
        String address = helper.input.nextLine();

        System.out.print("Enter new employee's gross salary: ");
        double salary = helper.input.nextDouble();
        helper.input.nextLine();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                continue;
            } else {
                employees[i] = new Employee(name, birthYear, address, salary);
                System.out.println(employees[i].toString());
                i = employees.length;
                //break; // I WILL FIGHT YOU
            }
        }
    }



    /*==========================Remove Employee=========================*/
//                Once again this is how i believe it should be done but in a different class (cough cough manager cough cough)
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


    public Employee[] removeEmployee(UUID employeeID) {
        for (int i = 0; i < employees.length; i++) { // goes through the array fed into method
            if (employees[i] == null) continue;
            if (!employees[i].getEmployeeID().equals(employeeID)) { //  it doesnt equal our employee to remove do nothing.
                continue;
            } else {
                employees[i] = null; // if it does have the employee we want to remove. (Ternary statement?)
                i = employees.length;
            }
        }

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

        return employees;
    }

    public static void authEmployee() {
        // TODO get fully fuctioning with no errors (see above comments)
        String password = "password123";
        Helper Authorize = new Helper();
        Boolean authSuccess = Authorize.authenticate(password);

        if (authSuccess) {
            EmployeeMenu.employeeMenu();
        } else {
            System.out.println("\n*** Wrong password *** \n");
            DartController dart2 = new DartController();
            dart2.DartController();
        }
    }

    // getters
    public String getName() {
        return name;
    }

    public double getSalary() {
        return grossSalary;
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
        return " => Name: " + this.name + " => UUID: " + this.employeeID + "\n*---*\n";
    }


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
        if (grossSalary < MIN_SALARY) {
            netSalary = grossSalary;

        } else {
            if (grossSalary >= MIN_SALARY) {
                netSalary = grossSalary - ((30.0 / 100) * grossSalary);
            }
        }
        double bonus;
        if (age < 22) { // change to not be magic numbers instead constant - (n)
            bonus = BONUS_LOW;
            netSalary = netSalary + bonus;
            System.out.print("Employee's net salary with bonus :" + netSalary);
        } else if (age == 22 && age < 30) { // change to not be magic numbers instead constant - (n)
            bonus = BONUS_MEDIUM;
            netSalary = netSalary + bonus;
            System.out.print("Employee's net salary with bonus :" + netSalary);
        } else if (age > 30) { // change to not be magic numbers instead constant - (n)
            bonus = BONUS_HIGH;
            netSalary = netSalary + bonus;
            System.out.print("Employee's net salary with bonus :" + netSalary);
        }

    }
}


