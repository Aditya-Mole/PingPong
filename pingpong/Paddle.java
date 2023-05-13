package pingpong;

import java.awt.*;
import java.awt.event.*;

/**
 * The Paddle class represents a paddle in the Ping Pong game.
 * It tracks the paddle's position, size, and provides methods to update its state and render it.
 */
public class Paddle {
    private int x;
    private int y;
    private int width = 20;
    private int height = 80;
    private int speed = 2;
    private boolean isLeftPaddle;
    private boolean isMovingUp;
    private boolean isMovingDown;

    /**
     * Constructs a new instance of the Paddle class.
     *
     * @param x            the initial x-coordinate of the paddle's position
     * @param isLeftPaddle a flag indicating if the paddle is the left paddle
     */
    public Paddle(int x, boolean isLeftPaddle) {
        this.x = x;
        this.y = 160;
        this.isLeftPaddle = isLeftPaddle;
    }

    /**
     * Updates the paddle's position based on the current movement state.
     * It moves the paddle up or down based on the movement state flags.
     */
    public void update() {
        if (isMovingUp && y >= speed) {
            y -= speed;
        }
        if (isMovingDown && y <= 320 - height - speed) {
            y += speed;
        }
    }

    /**
     * Handles the key press event to update the movement state flags.
     * It sets the appropriate flag based on the pressed key.
     *
     * @param e the KeyEvent object representing the key press event
     */
    public void keyPressed(KeyEvent e) {
        if (isLeftPaddle) {
            if (e.getKeyCode() == KeyEvent.VK_W) {
                isMovingUp = true;
            } else if (e.getKeyCode() == KeyEvent.VK_S) {
                isMovingDown = true;
            }
        } else {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                isMovingUp = true;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                isMovingDown = true;
            }
        }
    }

    /**
     * Handles the key release event to update the movement state flags.
     * It clears the appropriate flag based on the released key.
     *
     * @param e the KeyEvent object representing the key release event
     */
    public void keyReleased(KeyEvent e) {
        if (isLeftPaddle) {
            if (e.getKeyCode() == KeyEvent.VK_W) {
                isMovingUp = false;
            } else if (e.getKeyCode() == KeyEvent.VK_S) {
                isMovingDown = false;
            }
        } else {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                isMovingUp = false;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                isMovingDown = false;
            }
        }
    }

    /**
     * Retrieves the bounding rectangle of the paddle.
     *
     * @return the bounding rectangle of the paddle
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    /**
     * Renders the paddle on the specified Graphics object.
     *
     * @param g the Graphics object for rendering
     */
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }
}
