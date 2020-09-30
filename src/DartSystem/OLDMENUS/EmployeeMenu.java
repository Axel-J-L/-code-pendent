//package src.DartSystem.OLDMENUS;
//
//import src.DartSystem.*;
//
//public class EmployeeMenu {
//    // parent class (only static because menus need to be made nonestatic.)
//    private static DartController dartController = new DartController();
//
//    public static void employeeMenu() {
//        // TODO make not static
//        // Finished for the moment
//        System.out.println("<<< Employee menu >>>");
//        System.out.println("Employee screen - Type one of the options below:");
//        System.out.println("1. Register a game ");
//        System.out.println("2. Remove a game");
//        System.out.println("3. Register an album");
//        System.out.println("4. Remove an album");
//        System.out.println("5. View all albums");
//        System.out.println("6. Register a customer");
//        System.out.println("7. Remove a customer");
//        System.out.println("8. Show total rent profit");
//        System.out.println("9. View all games");
//        System.out.println("10. Return to main menu");
//
//        String[] employeeMenuAcceptSet = {"1","2","3","4","5","6","7"}; // Accepted responses for menu options /A
//        Helper getInput = new Helper(); // Getting new object from Helper /A
//        String userInput = getInput.getMenuInput("Please enter your choice: ", employeeMenuAcceptSet); // using argument to call Helper method/A
//
//        switch (userInput.toLowerCase()) {
//            case "1":
//                System.out.println("Register a game");
//                Game addProcess = new Game();
//                addProcess.addNewGame();
//                break;
//            case "2":
//                System.out.println("Remove game");
//                Game removeProcess = new Game();
//                removeProcess.removeGame();
//                break;
//                case "3":
//                System.out.println("Register album ");
//                dartController.addAlbum();
//                break;
//                case "4":
//                System.out.println("Remove album");
////                Album removeAlbum = new Album();
////                removeAlbum.removeAlbum();
//                break;
//            case "5":
//                System.out.println("All albums");
//                dartController.viewAlbums();
//                employeeMenu();
//                break;
//            case "6":
//                System.out.println("Register a customer");
//                Customer menuWorker = new Customer();
//                menuWorker.addCustomer();
//                break;
//            case "7":
//                Customer menuWorker2 = new Customer();
//                menuWorker2.removeCustomer();
//                break;
//            case "8":
//                Rental getIncome = new Rental();
//                getIncome.showRentalIncome();
//                break;
//            case "9":
//                System.out.println("View all games: ");
//                Game viewProcess = new Game();
//                viewProcess.viewAll();
//
//                break;
//            case "10":
//                System.out.println("Return to main menu: ");
//                DartController.DartController();
//
//                break;
//            default: System.out.println("no match");
//                break;
//        }
//    }
//}