import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComponent;

/** 
 * Displays an array of integers by using their values to determine bar heights.
 * @author Audrey St. John
 **/
public class BarArrayDisplay extends JComponent
{
	public static final Color BAR_COLOR = Color.blue; 
	
	// the array to display
	private Integer[] intArray;
	
	public BarArrayDisplay( Integer[] a )
	{
		super();
		intArray = a;
		repaint();
	}
	
	public void paint( Graphics g )
	{
		if ( intArray != null )
		{
			int barWidth = getWidth() / intArray.length;
			for ( int i = 0; i < intArray.length; i++ )
			{
				drawBar( g, intArray[i].intValue(), barWidth, i*barWidth );
			}
			
		}
	}
	
	private void drawBar( Graphics g, int height, int width, int xValue )
	{	
		// set the color of the "brush"
		g.setColor( BAR_COLOR );

		// draw the bar
		g.fillRect( xValue, getHeight() - height, width, height );

		// set the color of the "brush"
		g.setColor( Color.BLACK );

		// draw the bar
		g.drawRect( xValue, getHeight() - height, width, height );
		
		// print the height
		g.drawString( Integer.toString( height ), xValue, getHeight() - height + 10 );
	}
	
	public void setArray( Integer[] a ) 
	{
		intArray = a;
	}
}