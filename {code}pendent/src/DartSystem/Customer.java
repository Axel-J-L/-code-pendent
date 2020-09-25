package DartSystem;

import java.util.Scanner;
import java.util.UUID;

public class Customer {

    private int customerId;
    private String name;
    Helper helper=new Helper();

    private static Customer[] customerList={ new Customer(1,"Vernita"),
            new Customer(2,"Navya"),
            new Customer(3,"Drake"),
            new Customer(4,"Altan"),
            new Customer(5,"Axel")};

    // Default Constructor
    Customer() {
    }

    Customer(int customerId,String name){
        this.customerId=customerId;
        this.name=name;

    }

    public String toString(){
        return
                "ID :"+ this.customerId+ " : "+this.name;
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

        System.out.println("Add a customer here");
        System.out.println("Suggested ID: " + countId);
        System.out.print("Enter the customers ID : ");
        int cusIdInputs = helper.input.nextInt();
        helper.input.nextLine();
        System.out.print("Enter the customers  name: ");
        String cusName = helper.input.nextLine();
        int arrayCount = 0;
        for (int i = 0; customerList[i] != null; i++) {
            arrayCount = i + 1;
        }
        customerList[arrayCount] = new Customer(cusIdInputs, cusName);
        System.out.println("Customer added successfully :" + customerList[arrayCount].toString());
        System.out.print("If you want to add another customer press '1': ");
        int anotherEntry = helper.input.nextInt();
        if (anotherEntry == 1) {
            addCustomer();
        }
        else if (anotherEntry!=1){
            System.out.print("Invalid entry ");
              EmployeeMenu.employeeMenu();
        }
    }


    public void removeCustomer() {

        System.out.println("Remove a customer here by entering their ID : ");
        int cusIdToRemove = helper.input.nextInt();

        for (int i = 0; i < customerList.length; i++) {
            if (customerList[i].customerId == cusIdToRemove) {
                for (int j = i + 1; j < customerList.length; j++) {
                    customerList[i] = customerList[j];
                    System.out.println(customerList[i].toString());
                }}
            //else{
              //  System.out.println("Invalid customer Id");
               //
            // EmployeeMenu.employeeMenu();
            }
        }
    }










