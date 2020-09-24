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

    private static Game[] rental = Game.getGames();

    private Helper helper = new Helper();
    // Default Constructor
    public Rental() {
    }


    public double totalProfit;


    public void rentGame() {
        for(int i = 0; i < rental.length; i++){
            if (rental[i] != null){
                    System.out.println(rental[i].toString());
                }
        }

        System.out.println("Enter the ID of the game would you like to rent");
        int rentId = helper.input.nextInt();
        for (int i = 0; i < rental.length ; i++){
            if (rental[i].getId() == rentId){
                rental[i].setIsRented(true);
            }
        }
        CustomerMenu.customerMenu();
    }

    public String toString(){
        String outputString = this.id + " : " + this.title + " (" + this.genre + "). " + this.rentCost
                + "kr. " + "Status: "+ "\n";
        return outputString;
    }

    public void returnGame() {
        System.out.println(rental[0].toString());
        CustomerMenu.customerMenu();
    }

    /**
     * @param rentProfit

    public void rentProfit(void rentProfit) {
        // TODO implement here
    }
     */

}