/*
 * Driver class creates only instance of the Admin Control Panel. 
 * Thus Admin Control Panel follows the Singleton Pattern
 */

/**
 *
 * @author mannyjuarez
 */
public class Driver {

    public static void main(String[] args) {
	AdminControlPanel.getInstance();
    }
}
