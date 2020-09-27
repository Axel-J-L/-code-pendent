package DartSystem;

public class EmployeeMenu {
    public static void employeeMenu() {
        // TODO make not static
        // Finished for the moment
        System.out.println("<<< Employee menu >>>");
        System.out.println("Employee screen - Type one of the options below:");
        System.out.println("1. Register a game ");
        System.out.println("2. Remove a game");
        System.out.println("3. Register a customer");
        System.out.println("4. Remove a customer");
        System.out.println("5. Show total rent profit");
        System.out.println("6. View all games");
        System.out.println("7. Return to main menu");

        String[] employeeMenuAcceptSet = {"1","2","3","4","5","6","7"}; // Accepted responses for menu options /A
        Helper getInput = new Helper(); // Getting new object from Helper /A
        String userInput = getInput.getMenuInput("Please enter your choice: ", employeeMenuAcceptSet); // using argument to call Helper method/A

        switch (userInput.toLowerCase()) {
            case "1":
                System.out.println("Register a game");
                Game addProcess = new Game();
                addProcess.addNewGame();
                break;
            case "2":
                System.out.println("Remove game");
                Game removeProcess = new Game();
                removeProcess.removeGame();
                break;
            case "3":
                System.out.println("Register a customer");
                Customer menuWorker = new Customer();
                menuWorker.addCustomer();
                break;
            case "4":
                Customer menuWorker2 = new Customer();
                menuWorker2.removeCustomer();
                break;
            case "5":
                Rental getIncome = new Rental();
                getIncome.showRentalIncome();
                break;
            case "6":
                System.out.println("View all games: ");
                Game viewProcess = new Game();
                viewProcess.viewAll();

                break;
            case "7":
                System.out.println("Return to main menu: ");
                DartController.DartController();

                break;
            default: System.out.println("no match");
                break;
        }
    }
}