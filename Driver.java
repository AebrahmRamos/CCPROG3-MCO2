import java.util.ResourceBundle.Control;

/**
 * Driver class is the main entry point of the program
 */
public class Driver {
    public static void main(String[] args) {
        // ManagementSystem managementSystem = new ManagementSystem();
        ManagementModel managementModel = new ManagementModel();
        //managementSystem.menuSystem();
        MainView mainView = new MainView();
        MainController mainController = new MainController(mainView, managementModel);
        mainView.setVisible(true);

        mainController.init();
        // Controller controller = new Controller(systemGUI, managementSystem);

    }
}