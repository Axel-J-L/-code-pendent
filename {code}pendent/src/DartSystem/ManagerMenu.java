package DartSystem;

public class ManagerMenu {
    public static void managerMenu() {
        // TODO make not static
        System.out.println("\nManager Screen - Type one of the options below:");
        System.out.println("1. Add an employee");
        System.out.println("2. Remove an employee");
        System.out.println("3. View all employees");
        System.out.println("4. Return to Main Menu");

        String[] managerMenuAcceptSet = {"1", "2", "3", "4"}; // Accepted responses for menu options
        Helper input = new Helper(); // Creating new Helper object
        String mInput = input.getMenuInput("Please enter your option: ", managerMenuAcceptSet); // Calling Helper method

        switch(mInput.toLowerCase())
        {
            case "1":
                Employee addEmployee = new Employee();
                addEmployee.addEmployee();
                Manager.managerMenu();
                break;
            case "2":
                Employee removeOne = new Employee();
                removeOne.removeEmployee();
                Manager.managerMenu();
                break;
            case "3":
                System.out.println("Let's view all employee");
                Employee viewEmployees = new Employee();
                viewEmployees.viewEmployees();
                Manager.managerMenu();
                break;
            case "4":
                System.out.println("Return to main menu: ");
                DartController.DartController();
            default:
                System.out.println("no match");
        }
    }
}
