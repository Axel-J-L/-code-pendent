package DartSystem;

public class Manager {

    // Default Constructor
    public Manager() {
    }

 // I think this menu might be better to have in the DartController class (D)
    public static void managerMenu() {
        // TODO make not static
        System.out.println("\nManager Screen - Type one of the options below:");
        System.out.println("1. Add an employee");
        System.out.println("2. View all employees");
        System.out.println("3. Return to Main Menu");

        String[] managerMenuAcceptSet = {"1", "2", "3"}; // Accepted responses for menu options
        Helper input = new Helper(); // Creating new Helper object
        String mInput = input.getMenuInput("Please enter your option: ", managerMenuAcceptSet); // Calling Helper method

        switch(mInput.toLowerCase())
        {
            case "1":
                System.out.println("Let's add and employee!!!"); //testing manager menu
                break;
            case "2":
                System.out.println("Let's view all employee");
                Employee.viewEmployees();
                break;
            case "3":
                System.out.println("main menu");
            default:
                System.out.println("no match");
        }
    }


    //  changed this password authenticator to work for both employee and manager and customer if needed later. (d)
    //had to remove reference to menus at this time since the menus are currently static (d)
    public String authManager(){
        // TODO get functionality to 100%
            String password = "admin1234";
            Helper Authorize = new Helper();
            String authCheck = Authorize.Authenticator(password);

        if (authCheck.equals("success")){
            return "manager menu"; // this needs to return the manager menu but because of static menus it cant (D)
        } else {
            System.out.println("\n*** Wrong password *** \n");

            return "main menu"; // this needs to return the manager menu but because of static menus it cant (D)
        }
    }
}
//
//    /**
//     *
//     */
//    public void displaySalary() {
//        // TODO implement here
