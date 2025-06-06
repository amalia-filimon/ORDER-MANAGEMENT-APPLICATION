package start;
import presentation.Controller;
import presentation.MainView;
import java.util.logging.Logger;

/**
 * In aceasta clasa clasa se afla main-ul in care se creeaza un obiect de tipul "MainView" si un obiect de tipul "Controller"
 * @see MainView
 * @see Controller
 */
public class Start {
    protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());

    public static void main(String[] args){
        MainView mainView = new MainView();
        Controller controller = new Controller(mainView);
        mainView.setVisible(true);
    }
}
