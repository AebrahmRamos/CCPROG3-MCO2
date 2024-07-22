import java.util.ResourceBundle.Control;

/**
 * Driver class is the main entry point of the program
 */
public class Driver {
    public static void main(String[] args) {
        ManagementSystem managementSystem = new ManagementSystem();
        //managementSystem.menuSystem();
        SystemGUI systemGUI = new SystemGUI();
        Controller controller = new Controller(systemGUI, managementSystem);

    }
}