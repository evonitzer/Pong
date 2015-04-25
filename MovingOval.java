import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 
 * @author Evan Sweeney
 * <p>
 * This class draws a ball to the screen and updates its
 * position in response to action events.
 * 
 * @see JPanel
 * @see ActionListener
 *
 */
public class MovingOval extends JPanel implements ActionListener
{
      Timer t;
      final int increment = 4;      // Distance to move
      int x, y;               // Upper left corner of box containing ball
      int Xincrement = increment;   // Distance to move horizontally
      int Yincrement = increment;   // Distance to move vertically
      int diameter = 30;  
      /**
       * Creates a new 
       */
      MovingOval()
      {
            x = y = 10;             // Initial position of the ball
            t = new Timer(25, this);// Create a timer which fires every
                                    // 100 milliseconds and calls the
                              // actionPerformed method on this object
      t.setInitialDelay(1000);// Delay 1 second initial firing
      t.start();              // Start the timer running
}

      // Override the paintComponent to draw the ball!
      public void paintComponent(Graphics g)
      {
            super.paintComponent(g);// Base class method clears background
            // Change the position of the ball by the X and Y increment
            x += Xincrement;
            y += Yincrement;
            // If the ball hits a wall, negate the corresponding increment
            // Test to see if the ball has hit the left or right wall
            if ((x <= 0)||(x + diameter >= getWidth()))
                  Xincrement = -Xincrement;
            // Test to see if the ball has hit the top or bottom wall
            if ((y <= 0)||(y + diameter >= getHeight()))
                  Yincrement = -Yincrement;
            // Set color of the ball and draw it at the current position
            g.setColor(Color.green);
            g.fillOval(x, y, diameter, diameter);
      }
      public void actionPerformed(ActionEvent e)
      {
            repaint();  // Cause the panel to repaint itself.
      }
}

