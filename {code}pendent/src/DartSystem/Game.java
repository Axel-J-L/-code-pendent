package DartSystem;

import java.util.Scanner;
import java.util.UUID;
import java.util.Date;

public class Game {

    private UUID id;
    private String title;
    private String genre;
    private double rentCost;
    private boolean isRented;
    private Date lastRentalDate;

    private static Game[] games = { new Game("It is this", "Comedy", 12, true),
            new Game("Brainfreeze", "Comedy", 12, true),
            new Game("Give and take", "Comedy", 12, true),
            new Game("Pineapples", "Comedy", 12, false) };

    Game(){
    }

    Game(String gameTitle, String gameGenre, double gameRentCost) {
        this.id = UUID.randomUUID();
        this.genre = gameGenre;
        this.title = gameTitle;
        this.rentCost = gameRentCost;
        this.isRented = false;
        this.lastRentalDate = null;
    }


    Game(String gameTitle, String gameGenre, double gameRentCost, boolean gameIsRented) {
        this.id = UUID.randomUUID();
        this.title = gameTitle;
        this.genre = gameGenre;
        this.rentCost = gameRentCost;
        this.isRented = gameIsRented;
        this.lastRentalDate = null;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
         this.title = title;
    }

    public String getGenre(){
        return genre;
    }

    public void setGenre(String title){
        this.genre = genre;
    }

    public double getRentCost(){
        return rentCost;
    }

    public void setRentCost(String title){
        this.rentCost= rentCost;
    }

    public String getIsRented(){
        if (isRented){
            return "Out on rent";
        } else return "Available";
    }

    public void setIsRented(boolean isRented){
        this.isRented = isRented;
    }

    public void increaseArray(){

            Game[] gamesNew = new Game[games.length + (games.length/2)];
            for (int i = 0; i < games.length; i++) {
                gamesNew[i] = games[i];
            }
            games = gamesNew;

    }

    public void addNewGame() {
        if (games[games.length - 1] != null) {
            increaseArray();
        }
        Scanner newGameInput = new Scanner(System.in); //Opened scanner here as 3 inputs are required so I think it isn't best to open scanner for each one in helper..

        System.out.print("Title of Game? :  ");
        String newGameTitle = newGameInput.nextLine();

        System.out.print("Genre of Game? :  ");
        String newGameGenre = newGameInput.nextLine();

        System.out.print("Cost of rent for the day? :  ");
        double newGameRentCost = newGameInput.nextDouble();
        newGameInput.nextLine();

        int countArray = 0;
        for (int i = 0; games[i] != null; i++){
            countArray = i + 1;
        }

        games[countArray] = new Game(newGameTitle, newGameGenre, newGameRentCost);
        System.out.println("Game Added Successfully : " + "\n" + games[countArray].id + " : " + games[countArray].title + " (" + games[countArray].genre + "). " + games[countArray].rentCost
                + "kr. " + "Status: " + games[countArray].isRented + "\n");

        System.out.println("1) Add another game" + "\n" + "2) View all games" + "\n" + "3) Employee Menu");
        int userChoice = newGameInput.nextInt();
        if (userChoice == 1) {
            addNewGame();
        } else if (userChoice == 2) {
            viewAll();
        } else EmployeeMenu.employeeMenu();
      newGameInput.close();
    }

    public void removeGame() {
        Scanner gameToRemove = new Scanner(System.in);
        System.out.println("Title of game to remove?");
        String gameTitle = gameToRemove.nextLine();
        for (int i = 0; i < games.length; i++) {
            if (games[i].title.equalsIgnoreCase(gameTitle)) {
                for (int j = i + 1; j < games.length + 1; j++) {
                    if (games[i].isRented == false) {
                        if (i == games.length - 1) {
                            games[i] = null;
                        } else {
                            games[i] = games[j];
                            i++;
                        }
                    } else System.out.println("Game has to be returned before it can be removed from the system.");
                }
            }
        }
        viewAll();
    }

    public void viewAll(){
        System.out.println("Games:");
        for (int i = 0; i < games.length; i++) {
            if (games[i] != null){
                System.out.println(games[i].id + " : " + games[i].title + " (" + games[i].genre + "). " + games[i].rentCost
                        + "kr. " + "Status: " + games[i].isRented + "\n");
        }
        }
        System.out.println("1) Back to Employee Menu " + "\n" + "2) Back to Main Menu");
        Scanner userChoice = new Scanner(System.in);
        int whereTo = userChoice.nextInt();

        if (whereTo == 1){
            EmployeeMenu.employeeMenu();
        } else DartController.DartController();
    }
}