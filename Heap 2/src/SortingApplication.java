// SortingApplication.java
// Audrey St. John
 
import javax.swing.JFrame;
import javax.swing.JPanel;
 
/**
 * SortingApplication wraps a SortingPanel for the Sorting game.
 * @author Audrey Lee
 **/
public class SortingApplication
{
	public static void main( String[] args )
	{	
		JFrame sortingFrame = new JFrame( "Sorting" );
	    sortingFrame.getContentPane().add( new SortingPanel() );
	    sortingFrame.setSize( 800, 400 );
	    sortingFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    sortingFrame.setVisible( true );
	}
}
