package DartSystem;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

public class Game {

    private String id;
    private String title;
    private String genre;
    private double rentCost;
    private boolean isRented;
    private LocalDate rentedDate;

    private static Game[] games = { new Game( "Sonic: The Hedgehog", "Explore", 23, false),
            new Game( "Crash Bandicoot", "Racing", 24, false),
            new Game( "The Legend of Zelda", "Explore", 51, true),
            new Game( "Prince of Persia", "Impossible", 33, false),
            new Game( "Super Mario", "Classic", 32, false),
            new Game( "Street Fighter", "Fighting", 54, false),
            new Game( "Tekken", "Fighting", 29, false)};

    private final Helper helper = new Helper();

    Game(){
    }

    Game(String gameTitle, String gameGenre, double gameRentCost) {
        this.id = UUID.randomUUID().toString();
        this.genre = gameGenre;
        this.title = gameTitle;
        this.rentCost = gameRentCost;
        this.isRented = false;
        this.rentedDate = null;
    }


    Game(String gameTitle, String gameGenre, double gameRentCost, boolean gameIsRented) {
        this.id = UUID.randomUUID().toString();
        this.title = gameTitle;
        this.genre = gameGenre;
        this.rentCost = gameRentCost;
        this.isRented = gameIsRented;
        if (gameIsRented) {
            this.rentedDate =  LocalDate.of( 2020 , 8 , 23 );
        }else  this.rentedDate = null;
    }

    public static Game[] getGames(){
        return games;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
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
    public LocalDate getRentedDate(){
        return rentedDate;
    }

    public void setRentedDate(LocalDate rentedDate){
        this.rentedDate = rentedDate;
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
            outOnRent = "\033[31mOut on rent  \033[0m";
        } else outOnRent = "Available";
        String outputString = this.getId() + " : " + this.getTitle() + " (" + this.getGenre() + "). " + this.getRentCost()
                + "kr. " + "Status: " + outOnRent + "\n";
        return outputString;
    }

    public void addNewGame() {
        if (games[games.length - 1] != null) {
            increaseArray();
        }

        int countArray = 0;
        for (int i = 0; games[i] != null; i++){
            countArray = i + 1;
        }

        System.out.print("Title:  ");
        String newGameTitle = helper.input.nextLine();

        System.out.print("Genre:  ");
        String newGameGenre = helper.input.nextLine();

        System.out.print("Daily Rent Fee:  ");
        double newGameRentCost = helper.input.nextDouble();
        helper.input.nextLine();

        games[countArray] = new Game(newGameTitle, newGameGenre, newGameRentCost);
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
        System.out.println("Which game should be removed? ID:");
        String gameId = helper.input.nextLine();
        helper.input.nextLine();
        boolean contains = false;
        for (int i = 0; i < games.length; i++) {
            if (games[i].id.equals(gameId)) {
                contains = true;
                if (games[i].isRented == false) {
                    System.out.println("Are you sure you want to remove this game from the directory?" + "\n" + games[i].toString() + "\n" + "(Y/N)");
                    String doubleCheck = helper.input.nextLine();
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
                    viewAll();
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