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

        System.out.print(message);
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


    public boolean authenticate(String password) { // authenticates passwords
        String enteredPassword = getInput("Enter your password: ");
        return password.equals(enteredPassword);
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
        if (array.length == 0) return array;
        int position = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] != null){
                position++;
            }
        }
        Employee[] newEmployeeArr = new Employee[(int) (position)];
        for (int i = 0; i < array.length; i++) { // loops for copying.
            if (array[i] == null) continue;
            newEmployeeArr[i] = array[i]; // copys the information from fed in array to newEmployee array
        }
        return newEmployeeArr; // returns our new and fancy array with no nulls with same values as the one fed into the method
    }
}

