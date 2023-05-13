package pingpong;

import java.awt.*;

/**
 * The Ball class represents a ball in the Ping Pong game.
 * It tracks the ball's position, speed, and provides methods to update its state and render it.
 */
public class Ball {
    private int x;
    private int y;
    private int xSpeed = 1;
    private int ySpeed = 1;
    private int diameter = 20;

    /**
     * Constructs a new instance of the Ball class.
     * It initializes the ball's position and speed.
     */
    public Ball() {
        reset();
    }

    /**
     * Updates the ball's position based on its speed.
     * It moves the ball horizontally and vertically.
     */
    public void update() {
        x += xSpeed;
        y += ySpeed;
    }

    /**
     * Resets the ball's position and speed to their initial values.
     * It places the ball at the center of the screen and sets its speed to default values.
     */
    public void reset() {
        x = 440;
        y = 190;
        xSpeed = 1;
        ySpeed = 1;
    }

    /**
     * Reverses the ball's horizontal direction.
     * It changes the sign of the xSpeed value.
     */
    public void reverseDirectionX() {
        xSpeed = -xSpeed;
    }

    /**
     * Reverses the ball's vertical direction.
     * It changes the sign of the ySpeed value.
     */
    public void reverseDirectionY() {
        ySpeed = -ySpeed;
    }

    /**
     * Retrieves the x-coordinate of the ball's position.
     *
     * @return the x-coordinate of the ball
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the x-coordinate of the ball's position.
     *
     * @param x the new x-coordinate value
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Retrieves the y-coordinate of the ball's position.
     *
     * @return the y-coordinate of the ball
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y-coordinate of the ball's position.
     *
     * @param y the new y-coordinate value
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Retrieves the width of the ball.
     *
     * @return the width of the ball
     */
    public int getWidth() {
        return diameter;
    }

    /**
     * Retrieves the height of the ball.
     *
     * @return the height of the ball
     */
    public int getHeight() {
        return diameter;
    }

    /**
     * Retrieves the bounding rectangle of the ball.
     *
     * @return the bounding rectangle of the ball
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, diameter, diameter);
    }

    /**
     * Renders the ball on the specified Graphics object.
     *
     * @param g the Graphics object for rendering
     */
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, diameter, diameter);
    }
}
