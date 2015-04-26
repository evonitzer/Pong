import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

/**
 * 
 * @author Evan Sweeney
 * <p>
 * Controls the game of Pong by compositing the Ball class,
 * Paddle class, and DisplayPanel class into it.  Also calls
 * drawing methods of the classes according to a timer and listens
 * for mouse motion.
 * 
 * @see Ball
 * @see Paddle
 * @see DisplayPanel
 *
 */

public class PongController extends JFrame 
	implements MouseMotionListener, ActionListener{

	Timer t;
	Ball ball;
	DisplayPanel display;
	Paddle paddle;
	
	/**
	 * Creates a new PongController with a DisplayPanel, Ball, Paddle, and 25ms timer.
	 */
	PongController(){
		//initialize display
		display = new DisplayPanel(this);
		
		//initialize ball
		ball = new Ball(40,8);
		
		//initialize paddle
		paddle = new Paddle(80, 240, 435);
			
		//add mouse motion listener
		display.addMouseMotionListener(this);
		
		//start a timer
		t = new Timer(25, this);
		t.start();	
	}
	
	/**
	 * Call the draw methods of Ball and Paddle.
	 * 
	 * @param g Graphics object to be passed to Ball and Paddle.
	 */
	public void drawComponents(Graphics g){
		ball.drawBall(g);
		paddle.drawPaddle(g);
	}
	
	/**
	 * Timer listener that checks for contact between ball and paddle
	 * and also calls method to check for wall and Ball contact.
	 * 
	 * @param e ActionEvent object that is automatically passed.  Goes unused.
	 * 
	 */
	public void actionPerformed(ActionEvent e){
		ball.updatePosition();
 		ball.wallContact(display.getHeight(), display.getWidth());
 		if ((ball.xCenter() >= paddle.getLeft()) && 
 				(ball.xCenter() <= paddle.getRight())){
			if ((ball.getTop() <= paddle.getBottom()) && 
					(ball.getTop() >= (paddle.getBottom() - ball.getIncrement())))
				ball.reverseYdirection();}
		display.repaint();
	}
	
	/**
	 * Mouse event watcher for moving paddle.  Calls repaint for every mouse event.
	 * 
	 * @param e MouseEvent that is automatically passed.  Goes unused.
	 */
	public void mouseMoved(MouseEvent e) {
		paddle.updatePosition(e.getX());
		display.repaint();
	}

	/**
	 * Stubbed method that is unused.  Inherited from MouseMotionListener interface.
	 */
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub		
	}
		
	/**
	 * Main method instantiates a PongController.
	 * 
	 * @param args No arguments passed into main.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PongController();
	}
}
