package DartSystem;

import java.util.Scanner;
import java.util.UUID;

public class Customer {

private String customerId;
private String firstName;
private String lastName;

private static Customer[] customerList={ new Customer("ver","Vernita", "hdkjn"),
        new Customer("nav","Navya","pulikanla"),
        new Customer("Dra","Drake","dr"),
        new Customer("Alt","Altan","alt"),
        new Customer("Ax","Axel","axe")};

    // Default Constructor
     Customer() {
    }
   Customer(String customerId,String firstName,String lastName){
         this.customerId=customerId;
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
    public String toString(){
         return
      "ID :"+ this.customerId+" : "+ this.firstName+" "+this.lastName;
    }
   public void IncreaseArray() {
       Customer[] customerListNew = new Customer[customerList.length + (customerList.length / 2)];
       for (int i = 0; i < customerList.length; i++) {
           customerListNew[i] = customerList[i];
       }
       customerList = customerListNew;
       }
    public void addCustomer() {
        if (customerList[customerList.length - 1] != null) {
            IncreaseArray();
        }
        // TODO make not static
        Scanner newCustomer = new Scanner(System.in);
        System.out.println("Add a customer here");
        System.out.print("Enter the customers ID : ");
        String cusIdInputs = newCustomer.nextLine();
        System.out.print("Enter the customers first name: ");
        String cusFirstName = newCustomer.nextLine();
        System.out.print("Enter the customers last name: ");
        String cusLastName = newCustomer.nextLine();
        int arrayCount = 0;
        for (int i = 0; customerList[i] != null; i++) {
            arrayCount = i + 1;
        }
        customerList[arrayCount] = new Customer(cusIdInputs, cusFirstName, cusLastName);
        System.out.println("Customer added successfully :" + customerList[arrayCount].toString());
        System.out.print("If you want to add another customer press '1': ");
        int anotherEntry = newCustomer.nextInt();
      if (anotherEntry == 1) {
            addCustomer();
        }
        else if (anotherEntry!=1){
                System.out.print("Invaid,customer can't be added");
                //employeeMenu();
           // addCustomer();
        }
        newCustomer.close();
    }


    public static void removeCustomer() {
        // TODO make not static
        Scanner remCustomer = new Scanner(System.in);
        System.out.println("Remove a customer here by entering their ID : ");
        String cusIdToRemove = remCustomer.nextLine();


        for (int i = 0; i < customerList.length; i++) {
            if (customerList[i].customerId.equalsIgnoreCase(cusIdToRemove)) {
                for (int j = i + 1; j < customerList.length; j++) {
                    customerList[i] = customerList[j];
                    System.out.println(customerList[i].toString());
                }}else{
                    System.out.println("Invalid customer Id");
                    //employeeMenu();
                }



            }
        }

}


