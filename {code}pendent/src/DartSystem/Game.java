package DartSystem;

import java.util.Scanner;
import java.util.UUID;
import java.util.Date;

public class Game {

    private int id;
    private String title;
    private String genre;
    private double rentCost;
    private boolean isRented;
    private UUID rentedBy;

    private static Game[] games = { new Game(1, "It is this", "Comedy", 12, false),
            new Game(2, "Brainfreeze", "Comedy", 12, false),
            new Game(3, "Give and take", "Comedy", 12, true),
            new Game(4, "Pineapples", "Comedy", 12, false) };

    private Helper helper = new Helper();

    Game(){
    }

    Game(int gameId, String gameTitle, String gameGenre, double gameRentCost) {
        this.id = gameId;
        this.genre = gameGenre;
        this.title = gameTitle;
        this.rentCost = gameRentCost;
        this.isRented = false;
        this.rentedBy = null;
    }


    Game(int gameId, String gameTitle, String gameGenre, double gameRentCost, boolean gameIsRented) {
        this.id = gameId;
        this.title = gameTitle;
        this.genre = gameGenre;
        this.rentCost = gameRentCost;
        this.isRented = gameIsRented;
        this.rentedBy = null;
    }

    public static Game[] getGames(){
        return games;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
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

    public void setGenre(String genre){
        this.genre = genre;
    }

    public double getRentCost(){
        return rentCost;
    }

    public void setRentCost(double rentCost){
        this.rentCost= rentCost;
    }

    public boolean getIsRented(){
        return isRented;
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

    public String toString(){
        String outOnRent;
        if (this.isRented){
             outOnRent = "Out on rent";
        } else outOnRent = "Available";
              String outputString = this.id + " : " + this.getTitle() + " (" + this.getGenre() + "). " + this.getRentCost()
                + "kr. " + "Status: " + outOnRent + "\n";
        return outputString;
    }

    public void addNewGame() {
        int idCounter = games.length + 1;
        if (games[games.length - 1] != null) {
            increaseArray();
        }

        System.out.println("* suggestion ID - " + idCounter + " *");
        System.out.print("ID:  ");
        int newGameID = helper.input.nextInt();
        helper.input.nextLine();

        System.out.print("Title:  ");
        String newGameTitle = helper.input.nextLine();

        System.out.print("Genre:  ");
        String newGameGenre = helper.input.nextLine();

        System.out.print("Daily Rent Fee:  ");
        double newGameRentCost = helper.input.nextDouble();
        helper.input.nextLine();

        int countArray = 0;
        for (int i = 0; games[i] != null; i++){
            countArray = i + 1;
        }

        games[countArray] = new Game(newGameID, newGameTitle, newGameGenre, newGameRentCost);
        System.out.println("Game Added Successfully : " + games[countArray].toString());

        System.out.println("1) Add another game" + "\n" + "2) View all games" + "\n" + "3) Employee Menu");
        int userChoice = helper.input.nextInt();
        if (userChoice == 1) {
            addNewGame();
        } else if (userChoice == 2) {
            viewAll();
        } else EmployeeMenu.employeeMenu();
    }

    public void removeGame() {
        Scanner gameToRemove = new Scanner(System.in);
        System.out.println("Which game should be removed? ID:");
        int gameId = gameToRemove.nextInt();
        boolean contains = false;
        for (int i = 0; i < games.length; i++) {
            if (games[i].id == (gameId)) {
               contains = true;
                if (games[i].isRented == false) {
                    System.out.println("Are you sure you want to remove this game from the directory?" + "\n" + games[i].toString() + "\n" + "(Y/N)");
                    String doubleCheck = gameToRemove.nextLine();
                    if (doubleCheck.equalsIgnoreCase("y")) {
                        for (int j = i + 1; j < games.length + 1; j++) {
                            if (i == games.length - 1) {
                                games[i] = null;
                            } else {
                                games[i] = games[j];
                                i++;
                            }
                        }
                        System.out.println("Game removed");
                        viewAll();
                    } else removeGame();
                } else {
                    System.out.println("Game has to be returned before it can be removed from the system.\n");
                    EmployeeMenu.employeeMenu();
                }
            }
        } if (!contains) System.out.println("Couldn't find that game. Please make sure you enter the correct ID.\n");
    }

    public void viewAll(){
        System.out.println("Games:" + "\n");
        for (int i = 0; i < games.length; i++) {
            if (games[i] != null){
                System.out.println(games[i].toString());
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