import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * @author Evan Sweeney
 * <p>
 * Draw paddle on graphical object with desired length and position
 *
 */
public class Paddle {
	int length, xposition, yposition;
	/**
	 * Creates a new Paddle with specified position and length.
	 * @param length Length of paddle
	 * @param xposition Position of the center of the paddle
	 * @param yposition Position of the bottom of the paddle
	 */
	Paddle(int length, int xposition, int yposition){
		this.length = length;
		this.xposition = xposition;
		this.yposition = yposition;
	}
	
	/**
	 * Accessor for top of paddle of thickness 5
	 * @return Return top of paddle, thickness 5.
	 */
	public int getTop(){
		return yposition + 5;
	}
	
	/**
	 * Accessor for bottom of paddle.
	 * @return Returns bottom of paddle.
	 */
	public int getBottom(){
		return yposition;
	}
	
	/**
	 * Accessor for left side of paddle.
	 * @return Returns left side by subtracting half the length from the center
	 */
	public int getLeft(){
		return (int)(xposition - .5 * length);
	}

	/**
	 * Accessor for the right side of the paddle
	 * 
	 * @return Return the right side by adding half the length to the center
	 */
	public int getRight(){
		return (int)(xposition + .5 * length);
	}
	
	/**
	 * Change x position of the paddle.  Called by MouseEvent.
	 * @param x New X coordinates for paddle position.
	 */
	public void updatePosition(int x){
		xposition = x;
	}
	
	/**
	 * Draw the paddle on screen in white.
	 * @param g Graphics object to draw the paddle onto.
	 */
	public void drawPaddle(Graphics g){
		g.setColor(Color.white);
		g.fillRect(getLeft(), getBottom(), length, 5);
	}
}
