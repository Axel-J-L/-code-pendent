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
    /*======================Array Increment/Reformat=======================*/
    public Employee[] increaseEmployeeArr(Employee[] array) { //Employee[] arr is our throw away array to bridge data into Employee[] newEmployeeArr
        Employee[] newEmployeeArr = new Employee[(int) (array.length * 1.5)]; // creates a new array that is larger then the array you feed into the method of 1.5
        for (int i = 0; i < array.length; i++) { // loops for copying.
            newEmployeeArr[i] = array[i]; // copy's the information from fed in array to newEmployee array
        }
        return newEmployeeArr; // returns our new and fancy larger array with same values as the one fed into the method
    }

    public Employee[] trimArray(Employee[] array){
        int position = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] != null){
                position++;
            }
        }
        Employee[] newEmployeeArr = new Employee[(int) (position)];
        for (int i = 0; i < array.length; i++) { // loops for copying.
            newEmployeeArr[i] = array[i]; // copys the information from fed in array to newEmployee array
        }
        return newEmployeeArr; // returns our new and fancy larger array with same values as the one fed into the method
    }
}


