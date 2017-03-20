import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;


/**
 * Roster Application
 * 
 * @author ReginaYe
 *
 */
public class RosterApp extends JComponent {
	
	public static void main(String[] args) {
		//create and add the app controller 
		JFrame frame = new JFrame("Rooster Spring 2017 --- Regina Ye");
		frame.setSize(900,700);
		frame.setLayout(new BorderLayout());
		frame.add(new RosterController(), BorderLayout.CENTER);
		frame.setVisible(true);
		RosterController Rcontroller = new RosterController();
	}
}
