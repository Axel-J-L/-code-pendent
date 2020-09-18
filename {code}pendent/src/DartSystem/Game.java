package DartSystem;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.UUID;
/**
 *
 */
public class Game {

    private final UUID id;
    private final String title;
    private final String genre;
    private final double rentCost;
    private final String status;

    private static Game[] games = { new Game("It is what it is", "Comedy", 12, "Not Available"),
            new Game("Brainfreeze", "Comedy", 12, "Available"),
            new Game("Give and take", "Comedy", 12, "Not Available"),
            new Game("Pineapples", "Comedy", 12, "Available") };

    /**
     * Default constructor
     */

    Game(String gameTitle, String gameGenre, double gameRentCost) {
        this.id = UUID.randomUUID();
        this.genre = gameGenre;
        this.title = gameTitle;
        this.rentCost = gameRentCost;
        this.status = "Available";
    }


    Game(String gameTitle, String gameGenre, double gameRentCost, String gameStatus) {
        this.id = UUID.randomUUID();
        this.title = gameTitle;
        this.genre = gameGenre;
        this.rentCost = gameRentCost;
        this.status = gameStatus;
    }

    // TODO Just adding a note to remove this main later once we clean up the project code (D)
    public static void main(String[] args) {
        // create array of games
        // ArrayList<Game> listOfGames = new ArrayList<>();
        // listOfGames.add();
    }

  //  public static void addGame(int id, String title, String genre, double rentCost, String status) {} Considering using one method for asking input and another for applying to new array.

    /**
     *
     */
    public static void addNewGame() {
        // TODO make not static
        Scanner newGameInput = new Scanner(System.in); //Opened scanner here as 3 inputs are required so I think it isn't best to open scanner for each one in helper..

        System.out.print("Title of Game? :  ");
        String newGameTitle = newGameInput.nextLine();

        System.out.print("Genre of Game? :  ");
        String newGameGenre = newGameInput.nextLine();

        System.out.print("Cost of rent for the day? :  ");
        double newGameRentCost = newGameInput.nextDouble();
        newGameInput.nextLine();

        Game[] gamesNew = new Game[games.length + 1];
        for (int i = 0; i < games.length; i++) {
            gamesNew[i] = games[i];
        }

        gamesNew[games.length] = new Game(newGameTitle, newGameGenre, newGameRentCost);
        games = gamesNew;

        System.out.println("Game Added Successfully : " + "\n" + games[games.length - 1].id + " : " + games[games.length - 1].title + " (" + games[games.length - 1].genre + "). " + games[games.length - 1].rentCost
                + "kr. " + "Status: " + games[games.length - 1].status + "\n");

        viewGames(games);
        System.out.println("Press enter to go back to Employee menu");
        newGameInput.nextLine();
      //  newGameInput.close();
        Employee.employeeMenu();
    }

    /**
     *
     */
    public static void removeGame() {
        // TODO make not static
        // TODO implement here
        System.out.println("Remove a game");
    }

    public String toString() {
        return (id + " : " + title + " (" + genre + "). " + rentCost + "kr. " + "Status: " + status + "\n");
    }

    /**
     *
     */
    public static void seeAll() {
    }


    public static void viewGames(Game[] games) {
        // TODO make not static
        // TODO implement here
        System.out.println("Updated game list:");
        for (Game game : games) {
            System.out.println(game.id + " : " + game.title + " (" + game.genre + "). " + game.rentCost
                    + "kr. " + "Status: " + game.status + "\n");
        }
    }
    public static void viewAll() {
        // TODO make not static
        // TODO implement here
        System.out.println("Games:");
        for (Game game : games) {
            System.out.println(game.id + " : " + game.title + " (" + game.genre + "). " + game.rentCost
                    + "kr. " + "Status: " + game.status + "\n");
        }
    }
}