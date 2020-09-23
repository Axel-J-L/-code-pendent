package DartSystem;
// testing branch push
import DartSystem.DartController;

import java.lang.*;
import java.net.Authenticator;
import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        Helper helper = new Helper();
        DartController session = new DartController();
        session.DartController();

        //close (public static final scanner (in Helper class))
        helper.input.close();
    }

    // Default Constructor
    public Launcher() {
    }
}