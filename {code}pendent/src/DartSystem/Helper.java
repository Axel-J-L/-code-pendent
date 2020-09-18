package DartSystem;
//d

import java.time.Year;
import java.util.*;
import java.io.*;

public class Helper {
    public static final int CURRENT_YEAR = Year.now().getValue();
    public static Scanner input = new Scanner(System.in); // static scanner
    String userInput;

    //Default Constructor
    public Helper() {
    }


    // THIS ONE IS SUPER USEFUL USE IT! something with opening and closing the scanner break swapping between menus (Drake)
    public String getInput(String message) { // Method to get string input from user and return

        System.out.print(message); //removed println and replaced with print (D) if we need and println version we'll make one
        String userInput = input.nextLine();  // Read user input
        // scanner.close(); // Close scanner - This causes issue, leave it commented out (Altan)
        return userInput;  // Output user input

    }

    // made this to get integers instead of String (Drake)
    public int getInt(String message) { // Method to get string input from user and return

        System.out.print(message); //removed println and replaced with print (D) if we need and println version we'll make one
        int userInput = input.nextInt();  // Read user input
        input.nextLine();
        // scanner.close(); // Close scanner - This causes issue, leave it commented out (Altan)
        return userInput;  // Output user input

    }

    public String getMenuInput(String message, String[] acceptSet) { // Method to get menu input from user and return

        Boolean accept = true;

        // di while to loop around until user enter one of the AcceptSet characters. Anything else, just keeps looping
        do {
            System.out.print("\n" + message); // String message from called class before asking for input
            userInput = input.nextLine(); // Gets user input


            for (int i = 0; i < acceptSet.length; i++) { // Loop around AcceptSet array for matching letter
                if (userInput.equals(acceptSet[i])) { // If user input is correct, then break loop and close scanner
                    accept = false;
                }

            }

        } while (accept);

        return this.userInput; // Returns user's menu choice back to called class
    }

    public void printArray(String[] pArray[]) {

        for (String[] element : pArray) {
            System.out.println(element);
        }

        // TODO implement here
    }

//    // asks for password and then returns value
//    // (would like to implement authentication and hide password)
//    public String Password() { //this is to implement passwords and password protection (D)
//        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
//        System.out.print("Password: "); // hide password input
//        String userPass = scanner.nextLine();
//        scanner.close(); // Close scanner
//        return userPass;  // Output user input
//    }

    public String Authenticator(String password) { // authenticates passwords
        String authCheck;
        String enteredPassword = getInput("Enter your password: ");

        // checks both the manager and the employee passwords to see if you entered correct
        // I think it will work but not 100% sure (D)
        if (password.equals(enteredPassword)) {
            authCheck = "success";
        } else {
            authCheck = "nogood";
        }

        return authCheck;
    }

    // Drake, let's add this on Employee Class. Let the each class to do their own specific actions.
    // WORK IN PROGRESS, CREATING A METHOD FOR ADDING AND REMOVING USERS //Axel n Drake
    //    public ArrayList<String> addUserList(String addUser, String addEmployee) {
//        Scanner input = new Scanner(System.in);
//        ArrayList<String> user = new ArrayList<>();
//        System.out.println("Add employee name: ");
//        String name1= new String();
//
//
//        System.out.print(addUser + "Y/N: ");
//        String eUser = input.nextLine();
//        eUser = eUser.toUpperCase();
//
//
//        while (eUser.equals("Y")) {
//
//            System.out.print(addEmployee);
//            String name = input.nextLine();
//            user.add(name);
//            System.out.print(addUser + "Y/N: ");
//            eUser = input.nextLine();
//            eUser = eUser.toUpperCase();
//
//
//        }
//        for (int i = 0; i < user.size(); i++) {
//            System.out.println(user.get(i));
//
//        }

    }



