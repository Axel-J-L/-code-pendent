//package src.DartSystem.OLDMENUS;
//
//import src.DartSystem.DartController;
//import src.DartSystem.Employee;
//import src.DartSystem.Helper;
//
//public class Manager {
//
//    private static DartController dartController = new DartController();
//    // Default Constructor
//    public Manager() {
//    }
//
//    public static void managerMenu() {
//        // TODO make not static
//        System.out.println("\nManager Screen - Type one of the options below:");
//        System.out.println("1. Add an employee");
//        System.out.println("2. Remove an employee");
//        System.out.println("3. View all employees");
//        System.out.println("4. Return to Main Menu");
//
//        String[] managerMenuAcceptSet = {"1", "2", "3", "4"}; // Accepted responses for menu options
//        Helper input = new Helper(); // Creating new Helper object
//        String mInput = input.getMenuInput("Please enter your option: ", managerMenuAcceptSet); // Calling Helper method
//
//        switch(mInput.toLowerCase())
//        {
//            case "1":
//                Employee addEmployee = new Employee();
//                System.out.print("Creating an Employee. Please type the Employee’s:\n");
//                dartController.addEmployee();
//                break;
//            case "2":
//                Employee removeOne = new Employee();
//                removeOne.removeEmployee();
//                managerMenu();
//                break;
//            case "3":
//                System.out.println("All employees");
//                dartController.viewEmployee();
//                break;
//            case "4":
//                System.out.println("Return to main menu: ");
//                DartController.DartController();
//            default:
//                System.out.println("no match");
//        }
//    }
//
//
//    //  changed this password authenticator to work for both employee and manager and customer if needed later. (d)
//    //had to remove reference to menus at this time since the menus are currently static (d)
//    public static void authManager() {
//            String password = "admin1234";
//            Helper Authorize = new Helper();
//            Boolean authSuccess = Authorize.authenticate(password);
//
//        if ( authSuccess ) {
//            Manager mngr5 = new Manager();
//            mngr5.managerMenu();
//        } else {
//            System.out.println("\n*** Wrong password *** \n");
//            DartController dart2 = new DartController();
//            dart2.DartController();
//        }
//    }
//}