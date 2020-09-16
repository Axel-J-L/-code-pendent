package DartSystem;

import java.util.*;

public class Customer {
    String customerId;
    String name;

    // Default Constructor
    public Customer() {
    }

    public static void customerMenu() {
        System.out.println("\nCustomer Screen - Type one of the options below:");
        System.out.println("1. Rent a game");
        System.out.println("2. Return a game");
        System.out.println("3. Return to Main Menu");

        String[] customerMenuAcceptSet = {"1", "2", "3"}; // Accepted responses for menu options
        Helper input = new Helper(); // Creating new Helper object
        String mInput = input.getMenuInput("Please enter your option: ", customerMenuAcceptSet); // Calling Helper method

        switch(mInput.toLowerCase())
        {
            case "1":
                System.out.println("Looking for a game?");
                break;
            case "2":
                System.out.println("You took it a year ago?!");
                break;
            case "3":
                DartController.DartController();
                break;
            default:
                System.out.println("no match");
        }
    }

    public void addCustomer() {
        // TODO implement here
    }


    public void removeCustomer() {
        // TODO implement here
    }

}
