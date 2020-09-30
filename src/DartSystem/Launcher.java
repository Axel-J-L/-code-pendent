package src.DartSystem;
// testing branch push

import java.lang.*;

public class Launcher {

    public static void main(String[] args) {
        DartController dartController = new DartController();
        dartController.run();

        //close (public static final scanner (in Helper class))
        Helper helper = new Helper();
        helper.input.close();
    }

    // Default Constructor
    public Launcher() {
    }
}