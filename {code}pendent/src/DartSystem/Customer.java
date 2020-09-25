package DartSystem;

import java.util.Scanner;
import java.util.UUID;

public class Customer {

private int customerId;
private String firstName;
private String lastName;

private static Customer[] customerList={ new Customer(1,"Vernita", "hdkjn"),
        new Customer(2,"Navya","pulikanla"),
        new Customer(3,"Drake","dr"),
        new Customer(4,"Altan","alt"),
        new Customer(5,"Axel","axe")};

    // Default Constructor
     Customer() {
    }

    Customer(int customerId,String firstName,String lastName){
         this.customerId=customerId;
         this.firstName=firstName;
         this.lastName=lastName;
         }

    public String toString(){
         return
      "ID :"+ this.customerId+ " : "+ this.firstName+" "+this.lastName;
    }
   public void IncreaseArray() {
       Customer[] customerListNew = new Customer[customerList.length + (customerList.length / 2)];
       for (int i = 0; i < customerList.length; i++) {
           customerListNew[i] = customerList[i];
       }
       customerList = customerListNew;
       }
    public void addCustomer() {
        int countArray = 0;
        for(int i = 0; i < customerList.length; i++){
            if(customerList[i] != null){
                countArray++;
            }
        }

        int countId = customerList[countArray - 1].customerId + 1;

        if (customerList[customerList.length - 1] != null) {
            IncreaseArray();
        }

        Scanner newCustomer = new Scanner(System.in);
        System.out.println("Add a customer here");
        System.out.println("Suggested ID: " + countId);
        System.out.print("Enter the customers ID : ");
        int cusIdInputs = newCustomer.nextInt();
        newCustomer.nextLine();
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


    public void removeCustomer() {
        Scanner remCustomer = new Scanner(System.in);
        System.out.println("Remove a customer here by entering their ID : ");
        int cusIdToRemove = remCustomer.nextInt();

        for (int i = 0; i < customerList.length; i++) {
            if (customerList[i].customerId == cusIdToRemove) {
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


