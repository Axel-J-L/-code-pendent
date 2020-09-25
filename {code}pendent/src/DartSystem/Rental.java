package DartSystem;
import DartSystem.Game;

import java.util.*;

public class Rental {

    private UUID id;
    private String title;
    private String genre;
    private double rentCost;
    private boolean isRented;
    private Date lastRentalDate;

    private static double rentalIncome = 25.00;

    private static Game[] rental = Game.getGames();

    private static Helper getInput = new Helper();
    // Default Constructor
    public Rental() {
    }

    public double getRentalIncome() {
        return rentalIncome;
    }


    public double totalProfit;

    public void rentGame() {

        for(int i = 0; i < rental.length; i++){
            if (rental[i] != null){
                    System.out.println(rental[i].toString());
                }
        }

        String rentId = getInput.getInput("Enter the ID of the game would you like to rent: ");
        int idMatch = -1;
        Boolean rentalStatus = false;
        Boolean isFound = false;

        for (int i = 0; i < rental.length;i++) {
            if (rental[i].getId().equals(rentId)) {
                isFound = true;
                idMatch = i;
                rentalStatus = rental[i].getIsRented();
            }
        }

        if (isFound == true && rentalStatus == false){
            rental[idMatch].setIsRented(true);
            System.out.println("Game rented now");
        } else if (isFound == true && rentalStatus == true){
            System.out.println("Game is already rented.");
        } else {
                System.out.println("Game with this ID not found.");
        }

        CustomerMenu.customerMenu();
    }

    public void returnGame() {

        int rentId = getInput.getInt("Enter the ID of the game would you like to return: ");
        int daysRented = getInput.getInt("Enter number of days that you rented: ");
        int idMatch = -1;
        Boolean rentalStatus = false;
        Boolean isFound = false;
        double dailyRate = 0;
        double userBill = 0;

        for (int i = 0; i < rental.length;i++) {
            if (rental[i].getId().equals(rentId)) {
                isFound = true;
                idMatch = i;
                rentalStatus = rental[i].getIsRented();
                dailyRate = rental[i].getRentCost();
            }
        }

        if (isFound == true && rentalStatus == true){
            rental[idMatch].setIsRented(false);
            userBill = daysRented * dailyRate;
            rentalIncome = rentalIncome + userBill;
            System.out.println("Your total is " + userBill + " SEK");
            System.out.println("Game is now returned.");
        } else if (isFound == true && rentalStatus == false){
            System.out.println("Game is not rented.");
        } else {
            System.out.println("Game with this ID not found.");
        }
        CustomerMenu.customerMenu();
    }

    public void showRentalIncome() {
        System.out.println("Rental income to-date is: " + getRentalIncome() + " SEK\n");

        EmployeeMenu.employeeMenu();
    }

    public String toString(){
        String outputString = this.id + " : " + this.title + " (" + this.genre + "). " + this.rentCost
                + "kr. " + "Status: "+ "\n";
        return outputString;
    }

    /**
     * @param rentProfit

    public void rentProfit(void rentProfit) {
        // TODO implement here
    }
     */

}