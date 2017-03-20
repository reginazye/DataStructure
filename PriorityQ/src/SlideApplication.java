import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Slide show application class
 * @author ReginaYe
 *
 */
public class SlideApplication extends JComponent{

	public static void main(String args[]){ 
		JFrame game = new JFrame("Slide Show Application");
		game.setSize(800, 800);
		game.add(new SlideController());
		game.setVisible(true);

	}
}
