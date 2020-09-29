package DartSystem;

import DartSystem.Music.Album;

import java.lang.*;
import java.util.ArrayList;

public class DartController {
    private ArrayList<Album> albums = new ArrayList<Album>();

    public ArrayList<Album> getAlbums() {
        return albums;
    }

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

        String[] mainMenuAcceptSet = {"M", "m", "E", "e", "C", "c", "X", "x"}; // Accepted responses for menu options
        Helper getInput = new Helper(); // Creating new Helper object
        String userInput = getInput.getMenuInput("Please enter your choice: ", mainMenuAcceptSet); // Calling Helper method

        switch (userInput.toLowerCase()) {
            case "m":
                Manager.authManager();
                break;
            case "e":
                // Employee.authEmployee();
                EmployeeMenu employeeMenu = new EmployeeMenu();
                employeeMenu.employeeMenu();
                break;
            case "c":
                CustomerMenu.customerMenu();
                break;
            case "x":
                System.out.println("Exiting system ...");
                break;
            default:
                System.out.println("no match");
        }
    }
}


