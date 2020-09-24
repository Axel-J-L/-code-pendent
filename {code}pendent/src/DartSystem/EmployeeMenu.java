package DartSystem;

public class EmployeeMenu {
    public static void employeeMenu() {
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
                Game addProcess = new Game();
                addProcess.addNewGame();
            }
            case "b" -> {
                System.out.println("Remove game");
                Game removeProcess = new Game();
                removeProcess.removeGame();
            }
            case "c" -> {
                System.out.println("Register a customer");
                System.out.print("brings up a menu to remove a customer");
                Customer addProcess=new Customer();
                addProcess.addCustomer(); // has not been implemented
            }
            case "d" -> {
                System.out.println("Remove customer: ");
                Customer.removeCustomer();
            }
            case "e" -> System.out.println("Show total rent profit");
            case "f" -> {
                System.out.println("View all games: ");
                Game viewProcess = new Game();
                viewProcess.viewAll();
            }
            case "r" -> {
                System.out.println("Return to main menu: ");
                DartController.DartController();
            }
            default -> System.out.println("no match");
        }
    }
}