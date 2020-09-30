package src.DartSystem;

import java.util.ArrayList;

public class Customer {

    private int customerId;
    private String name;
    private ArrayList<Message> inbox;
    Helper helper=new Helper();

    Menus menus = new Menus(); // for now so shit isn't angry

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
        this.inbox = new ArrayList<Message>(); // adds an inbox for every customer.
    }

    // Send Message method
    public void sendMessage(){

    }

    public String toString(){
        return
                "ID: "+ this.customerId+ ", Name: "+this.name;
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
            menus.employeeMenu();
        }
    }


    public void removeCustomer() {
        viewEmployee();
        int cusIdToRemove = helper.getInt("Remove a customer here by entering their ID : ");

        for (int i = 0; i < customerList.length; i++) {
            if (customerList[i].customerId == cusIdToRemove) {
                for (int j = i + 1; j < customerList.length; j++) {
                    customerList[i] = customerList[j];
                    i++;
                }
                int arrayCount = 0;
                for (int k = 0; k < customerList.length; k++){
                    if (customerList[k] != null){
                        arrayCount++;
                    }
                }
                customerList[arrayCount-1] = null;
            }
        }
        System.out.println("Customer Removed");
        menus.employeeMenu();
    }

    public void viewEmployee(){
        for (int i = 0; i < customerList.length; i++) {
            if (customerList[i]!=null){
                System.out.println(customerList[i].toString());
            }
        }
    }

}










