import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * @author Evan Sweeney
 * <p>
 * Draw Ball on graphical object and detect collision with other objects.
 *
 */
public class Ball{
	
	//needed parameters: size, position, increment
	int diameter;
	int xposition, yposition;
	int increment;
	int xincrement = increment;
	int yincrement = increment;
	
	/**
	 * Create new Ball with specified diameter and movement speed.  Starts at origin.
	 * @param diameter Diameter of ball
	 * @param increment Distance to move with each timer event
	 */
	Ball(int diameter, int increment){
  	this.diameter = diameter;
  	xincrement = increment;
  	yincrement = increment;
  	xposition = 0;
  	yposition = 0;
	}
	
	/**
	 * Accessor for top of ball
	 * @return Return top of ball
	 */
	public int getTop(){
  	return yposition + diameter;
	}
	
	/**
	 * Accessor for speed in y direction
	 * @return Return yIncrement, which controls ball speed.
	 */
	public int getIncrement(){
  	return yincrement;
	}
	
	/**
	 * Accessor for bottom of ball
	 * @return Return bottom of ball
	 */
	public int getBottom(){
  	return yposition;
	}
	
	/**
	 * Accessor for left side of ball
	 * @return Return left side of ball
	 */
	public int getLeft(){
  	return xposition;
	}
	/**
	 * Accessor for right side of ball
	 * @return Return right side of ball
	 */
	public int getRight(){
  	return xposition + diameter;
	}
	
	/**
	 * Reverse y direction by negating it
	 */
	public void reverseYdirection(){
  	yincrement = -yincrement;
	}
	
	/**
	 * Reverse x direction by negating it
	 */
	public void reverseXdirection(){
  	xincrement = -xincrement;
	}
	
	/**
	 * Update position with new ball coordinates.  Determined by increment.
	 */
	public void updatePosition(){
  	xposition += xincrement;
  	yposition += yincrement;
	}
	
	/**
	 * Find the center of the ball
	 * @return Return x center of ball
	 */
	public int xCenter(){
  	return (int)(xposition + .5*diameter);
	}
	
	/**
	 * Detect collision between ball and wall
	 * @param height Height of frame containing the game
	 * @param width Width of frame containing the game
	 */
	public void wallContact(int height, int width){
  	if ((xposition <= 0 )||(xposition + diameter >= width))
	  	reverseXdirection();
  	if ((yposition <= 0)|| (yposition + diameter >= height))
	  	reverseYdirection();
	}
	
	/**
	 * Draw a new ball on screen
	 * @param g Draw onto a graphical object the new position of the ball
	 */
	public void drawBall(Graphics g){
        g.setColor(Color.white);
        g.fillOval(xposition, yposition, diameter, diameter);
	}
}
