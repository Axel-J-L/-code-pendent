package DartSystem;

import java.util.Scanner;
import java.util.UUID;

public class Game {

    private UUID id;
    private String title;
    private String genre;
    private double rentCost;
    private boolean isRented;

    private static Game[] games = { new Game("It is this", "Comedy", 12, true),
            new Game("Brainfreeze", "Comedy", 12, true),
            new Game("Give and take", "Comedy", 12, true),
            new Game("Pineapples", "Comedy", 12, false) };

    /**
     * Default constructor
     */
    Game(){
    }

    Game(String gameTitle, String gameGenre, double gameRentCost) {
        this.id = UUID.randomUUID();
        this.genre = gameGenre;
        this.title = gameTitle;
        this.rentCost = gameRentCost;
        this.isRented = false;
    }


    Game(String gameTitle, String gameGenre, double gameRentCost, boolean gameIsRented) {
        this.id = UUID.randomUUID();
        this.title = gameTitle;
        this.genre = gameGenre;
        this.rentCost = gameRentCost;
        this.isRented = gameIsRented;
    }

    public void addNewGame() {
        // TODO make not static
        Scanner newGameInput = new Scanner(System.in); //Opened scanner here as 3 inputs are required so I think it isn't best to open scanner for each one in helper..

        System.out.print("Title of Game? :  ");
        String newGameTitle = newGameInput.nextLine();

        System.out.print("Genre of Game? :  ");
        String newGameGenre = newGameInput.nextLine();

        System.out.print("Cost of rent for the day? :  ");
        double newGameRentCost = newGameInput.nextDouble();
        newGameInput.nextLine();

        Game[] gamesNew = new Game[games.length + (games.length/2)];

        for (int i = 0; i < games.length; i++) {
            gamesNew[i] = games[i];
        }
        gamesNew[games.length] = new Game(newGameTitle, newGameGenre, newGameRentCost);

        games = gamesNew;

        int countArray = 0;
        for (int i = 0; games[i] != null; i++){
            countArray = i;
        }
        System.out.println("Game Added Successfully : " + "\n" + games[countArray].id + " : " + games[countArray].title + " (" + games[countArray].genre + "). " + games[countArray].rentCost
                + "kr. " + "Status: " + games[countArray].isRented + "\n");

        viewAll();
        System.out.println("1) Employee Menu " + "\n" + "2) Add another game");
        int userChoice = newGameInput.nextInt();
        if (userChoice == 1){
            EmployeeMenu.employeeMenu();
        } else addNewGame();
      newGameInput.close();
    }

    public void removeGame() {
        Scanner gameToRemove = new Scanner(System.in);
        System.out.println("Title of game to remove?");
        String gameTitle = gameToRemove.nextLine();
        for (int i = 0; i < games.length; i++) {
            if (games[i].title.equalsIgnoreCase(gameTitle)) {
                for (int j = i + 1; j < games.length + 1; j++) {
                    if (i == games.length - 1) {
                        games[i] = null;
                    } else {
                        games[i] = games[j];
                        i++;
                    }
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