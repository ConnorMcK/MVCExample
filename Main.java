
/**
 * @author savi
 */
// Launcher for application

public class Main {

    public static void main(String args[]) {

        Model model = new Model();               // Create shared database
        Controller1 c1 = new Controller1(model, "Controller 1", 300,400); // Create first controller
        Controller2 c2 = new Controller2(model, "Controller 2", 700, 400); // Create second controller
          Controller2 c3 = new Controller2(model, "Controller 3", 700, 600);
            Controller2 c4 = new Controller2(model, "Controller 4", 700, 800);

    } // main

} // Main
