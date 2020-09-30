package src.DartSystem;

import src.DartSystem.Music.Album;

import java.lang.*;
import java.util.ArrayList;

public class DartController {

    //opening child classes
    private static Employee employee = new Employee();
    private static Customer customer = new Customer();
    private static Helper helper = new Helper();
    private static Menus menu = new Menus();
    private static Album album = new Album();

    // "kind of" Storage
    ArrayList<Album> albums;
    ArrayList<Employee> employees;


    // Talking to employee
    //--------------------------------------------------------------------------//
    public void addEmployee(){
        this.employees.add(employee.addEmployee());
        menu.managerMenu();
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
        menu.employeeMenu();
    }

    // Default constructor
    public void run() {
        menu.mainMenu();
        }
}


