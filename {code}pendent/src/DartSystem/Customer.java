package DartSystem;

import java.util.Scanner;
import java.util.UUID;

public class Customer {

private UUID  customerId;
private String firstName;
private String lastName;

private Customer[] customerList={ new Customer("Vernita","hdkjn"),new Customer("Navya","pulikanla")};

    // Default Constructor
     Customer() {
    }
   Customer(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
        }


    public static void customerMenu() {
        // TODO make not static
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
                Rental toRent=new Rental();
                toRent.rentGame();
                break;
            case "2":
                System.out.println("You took it a year ago?!");
                Rental toReturn=new Rental();
                    toReturn.returnGame();
                break;
            case "3":
                DartController.DartController();
                break;
            default:
                System.out.println("no match");
        }
    }

    public void addCustomer() {
        // TODO make not static
        System.out.println("Add a customer here");
    }



    public static void removeCustomer() {
        // TODO make not static
        System.out.println("Remove a customer here");
    }

}
