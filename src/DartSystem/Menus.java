package src.DartSystem;


public class Menus {
    private String title;
    private String[] options;
    private String prompt;

    private DartController dartController = new DartController();

    public Menus() {
    }

    public Menus(String title, String[] options, String prompt) {
        this.title = title;
        this.options = options;
        this.prompt = prompt;
    }

    private static void exit() {
        System.out.println("-----------------\n    Good Bye!\n-----------------");
        System.exit(0);
    }

    public void mainMenu() {
        String[] options = {" 1) Manager Menu", " 2) Employee Menu", " 3) Customer Menu", " 4) Exit System"};
        Menus menu = new Menus("Welcome to DART, your good old game rental system. \nThe competition has no steam to keep up!\n\n----Main-Menu----",
                options, "-----------------\nChoose your option: ");
        System.out.println(menu.title);
        for (int i = 0; i < options.length; i++) {
            System.out.println(options[i]);
        }
        System.out.print(menu.prompt);
        do {
            String choice = Helper.input.nextLine();
            switch (choice) {
                case "1":
                    authManager();
                   // managerMenu(); swap to turn off password
                    break;
                case "2":
                    authEmployee();
                   // employeeMenu(); swap to turn off password
                    break;
                case "3":
                    customerMenu();
                    break;
                case "4":
                    exit();
                    break;
                default:
                    System.out.println("-----------------\n- Invalid input -");
                    System.out.print(menu.prompt);
                    break;
            }
        } while (true);
    }

    public void managerMenu() {
        String[] options = {" 1) Register Employee", " 2) Remove Employee", " 3) View Employees", " 4) Return to Main Menu"};
        Menus menu = new Menus("--Manager-Menu--", options, "------------------\nChoose your option: ");
        System.out.println(menu.title);
        for (int i = 0; i < options.length; i++) {
            System.out.println(options[i]);
        }
        System.out.print(menu.prompt);
        do {
            String choice = Helper.input.nextLine();
            switch (choice) {
                case "1":
                    Employee addEmployee = new Employee();
                    System.out.print("Creating an Employee. Please type the Employee’s:\n");
                    dartController.addEmployee();
                    break;
                case "2":
                    System.out.println("removes an employee (make new remove to work with arraylsit)");
                    break;
                case "3":
                    System.out.println("All employees"); // not currently working
                    dartController.viewEmployee();
                    break;
                case "4":
                    mainMenu();
                    break;
                default:
                    System.out.println("-----------------\n- Invalid input -");
                    System.out.print(menu.prompt);
                    break;
            }
        } while (true);
    }

    //  changed this password authenticator to work for both employee and manager and customer if needed later. (d)
    //had to remove reference to menus at this time since the menus are currently static (d)
    public void authManager() {
        String password = "admin1234";
        Helper Authorize = new Helper();
        Boolean authSuccess = Authorize.authenticate(password);

        if (authSuccess) {
            managerMenu();
        } else {
            System.out.println("\n*** Wrong password *** \n");
            mainMenu();
        }
    }

    public void employeeMenu() {
        String[] options = {" 1) Register Game", " 2) Remove Game", " 3) View Games", " 4) Register Album",
                " 5) Remove Albums", " 6) View Albums", " 7) Register Customer", " 8) Remove Customer",
                " 9) View Customers", " 10) Total Rent Profit", " 11) Return to Main Menu"};
        Menus menu = new Menus("---Employee-Menu---", options, "------------------\nChoose your option: ");
        System.out.println(menu.title);
        for (int i = 0; i < options.length; i++) {
            System.out.println(options[i]);
        }
        System.out.print(menu.prompt);
        do {
            String choice = Helper.input.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Register Game");
                    System.out.println("add the method for now returns you to main menu");
                    mainMenu();
                    break;
                case "2":
                    System.out.println("Remove Game");
                    System.out.println("add the method for now returns you to main menu");
                    mainMenu();
                    break;
                case "3":
                    System.out.println("View Games");
                    dartController.addAlbum();
                    break;
                case "4":
                    System.out.println("Register Album");
                    System.out.println("add the method for now returns you to main menu");
                    mainMenu();
                    break;
                case "5":
                    System.out.println("Remove albums");
                    dartController.viewAlbums();
                    employeeMenu();
                    break;
                case "6":
                    System.out.println("View Albums");
                    System.out.println("add the method for now returns you to main menu");
                    mainMenu();
                    break;
                case "7":
                    System.out.println("Register Customer");
                    System.out.println("add the method for now returns you to main menu");
                    mainMenu();
                    break;
                case "8":
                    System.out.println("Remove Customer");
                    System.out.println("add the method for now returns you to main menu");
                    mainMenu();
                    break;
                case "9":
                    System.out.println("View Customers");
                    System.out.println("add the method for now returns you to main menu");
                    mainMenu();
                    break;
                case "10":
                    System.out.println("View Total Rent Profit");
                    System.out.println("add the method for now returns you to main menu");
                    mainMenu();
                    break;
                case "11":
                    mainMenu();
                    break;
                default:
                    System.out.println("-----------------\n- Invalid input -");
                    System.out.print(menu.prompt);
                    break;
            }
        } while (true);
    }

    public void authEmployee() {
        String password = "password123";
        Helper Authorize = new Helper();
        Boolean authSuccess = Authorize.authenticate(password);

        if (authSuccess) {
            employeeMenu();
        } else {
            System.out.println("\n*** Wrong password ***\n");
            mainMenu();
        }
    }

    public void customerMenu() {
        String[] options = {" 1) Rent a Game", " 2) Return a Game", " 3) Rent Album", " 4) Return Album", " 5) Messages", " 6) Return to Main Menu"};
        Menus menu = new Menus("--Customer-Menu--", options, "-----------------\nChoose your option: ");
        System.out.println(menu.title);
        for (int i = 0; i < options.length; i++) {
            System.out.println(options[i]);
        }
        System.out.print(menu.prompt);
        do {
            String choice = Helper.input.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Rent Game");
                    System.out.println("add the method for now returns you to main menu");
                    mainMenu();
                    break;
                case "2":
                    System.out.println("Return Game");
                    System.out.println("add the method for now returns you to main menu");
                    mainMenu();
                    break;
                case "3":
                    System.out.println("Rent Album");
                    System.out.println("add the method for now returns you to main menu");
                    mainMenu();
                    break;
                case "4":
                    System.out.println("Return Album");
                    System.out.println("add the method for now returns you to main menu");
                    mainMenu();
                    break;
                case "5":
                    System.out.println("Inbox");
                    System.out.println("add the method for now returns you to main menu");
                    mainMenu();
                    break;
                case "6":
                    mainMenu();
                    break;
                default:
                    System.out.println("-----------------\n- Invalid input -");
                    System.out.print(menu.prompt);
                    break;
            }
        } while (true);
    }

    public void inboxMenu() {
        String[] options = {" 1) View messages", " 2) Send Message", " 3) Return to Main Menu"};
        Menus menu = new Menus("--Inbox--", options, "-----------------\nChoose your option: "); //add the name of the user whose inbox we are using to title
        System.out.println(menu.title);
        for (int i = 0; i < options.length; i++) {
            System.out.println(options[i]);
        }
        System.out.print(menu.prompt);
        do {
            String choice = Helper.input.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("View Messages");
                    System.out.println("add the method for now returns you to main menu");
                    mainMenu();
                    break;
                case "2":
                    System.out.println("Send Message");
                    System.out.println("add the method for now returns you to main menu");
                    mainMenu();
                    break;
                case "3":
                    mainMenu();
                    break;
                default:
                    System.out.println("-----------------\n- Invalid input -");
                    System.out.print(menu.prompt);
                    break;
            }
        } while (true);
    }
}
