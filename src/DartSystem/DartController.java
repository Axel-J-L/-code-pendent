package src.DartSystem;

import src.DartSystem.Music.Album;

import java.lang.*;
import java.util.ArrayList;

public class DartController {

    //opening child classes
    Employee employee = new Employee();
    Customer customer = new Customer();
    Manager manager = new Manager();
    Helper helper = new Helper();
    EmployeeMenu employeeMenu = new EmployeeMenu();
    Album album = new Album();

    // "kind of" Storage
    ArrayList<Album> albums;
    ArrayList<Employee> employees;


    // Talking to employee
    //--------------------------------------------------------------------------//
    public void addEmployee(){
        this.employees.add(employee.addEmployee());
        manager.managerMenu();
    }
    public void viewEmployee(){
        for (Employee employee : employees){
            System.out.println(employee.toString());
        }
    }
    //--------------------------------------------------------------------------//

        public void viewAlbums() {
//        for(int i = 0; i < dartController.getAlbums().size(); i++){
//            System.out.println(dartController.getAlbums().toString());
            for (Album album : albums) {
                System.out.println(album.toString());
            }
        }

    public void addAlbum(){
        this.albums.add(album.addAlbum());
        EmployeeMenu.employeeMenu();
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


