import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

/**
 * 
 * @author Evan Sweeney
 * <p>
 * Container for drawing all objects in the Pong game.
 * 
 * @see PongController
 * @see JPanel
 *
 */
public class DisplayPanel extends JPanel{
	PongController pongC;
	JFrame frame;
	/**
	 * Creates DisplayPanel frame of size 500,500 and centered. 
	 * @param pongC Adds PongController object to the frame.
	 */
	DisplayPanel(PongController pongC){
		//need the variable pongC so we can 
		//pass the graphics object around.
		this.pongC = pongC;
		this.frame = new JFrame();
		//add panel to a frame
		frame.add(this);
		//initialize the frame
		frame.setVisible(true);
		frame.setSize(500,500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}

	/**
	 * Draws a black background to the frame.  Passes graphical object into
	 * PongController object so other classes may draw upon it.
	 * 
	 * @param g Graphical object of Display panel.  Other classes may draw on this object.
	 * 
	 */
	public void paintComponent(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		pongC.drawComponents(g);
	}
}
