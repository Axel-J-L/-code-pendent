package DartSystem;

import java.io.*;
import java.util.*;
import java.lang.*;

public class DartController {


    // Default Constructor
    public static void DartController() {
        // TODO make not static

            System.out.println("Main Menu:");
            System.out.println("Welcome to DART, your good old game rental system. The competition has no steam to keep up! \n");
            // Poking fun at Steam, huh.
            System.out.println("1. Enter \"M\" for Manager ");
            System.out.println("2. Enter \"E\" for Employee");
            System.out.println("3. Enter \"C\" for Customer");
            System.out.println("4. Enter \"X\" to exit system");

            String[] mainMenuAcceptSet = {"M","m","E","e","C","c","X","x"}; // Accepted responses for menu options
            Helper getInput = new Helper(); // Creating new Helper object
            String userInput = getInput.getMenuInput("Please enter your choice: ", mainMenuAcceptSet); // Calling Helper method

            switch(userInput.toLowerCase())
            {
                case "m":
                    // Manager.authManager(); // Moved authManager() to Manager class. Let's have classes to do their own stuff. (Altan)
                    System.out.println("prompts manager authorization"); // we cant access the authManger yet due to static's (Drake)
                    break;
                case "e":
//                    Employee.employeeMenu();
                    break;
                case "c":
                    Customer.customerMenu();
                    break;
                case "x":
                    System.out.println("Exiting system ...");
                    break;
                default:
                    System.out.println("no match");
            }


//    public void mainMenu() {
//        // TODO implement here
//    }
//
//    public void exit() {
//        // TODO implement here
//    }
//
//
//    public void exceptionHandler() {
//        // TODO implement here
    }

}




//    going to modify this so that if the wrong password is entered it takes you back to the main menu (drake)
//        Scanner input = new Scanner(System.in);
//        int menuC = 0;
//        while (menuC != 1 || menuC != 2 || menuC != 3 || menuC != 4) {
//            menuC = input.nextInt();
//            input.nextLine();
//            if (menuC == 1) {
//                System.out.print("password: ");
//                String password = input.nextLine();
//            } else if (menuC == 2) {
//                // generate employee menu
//            } else if (menuC == 3) {
//                // generate customer menu
//            } else if (menuC == 4) {
//                // exit system
//            } else {
//                System.out.println("");
//            }
//        }