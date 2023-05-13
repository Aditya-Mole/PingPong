package pingpong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The GamePanel class represents the game panel where the Ping Pong game is played.
 * It handles the game logic, including updating the ball and paddles, checking collision, and rendering the game objects.
 */
public class GamePanel extends JPanel implements ActionListener {
    private Ball ball;
    private Paddle paddle1;
    private Paddle paddle2;
    private ScorePanel scorePanel;

    /**
     * Constructs a new instance of the GamePanel class.
     * It sets up the panel properties, initializes the game objects, adds key listeners, and starts a timer for game updates.
     */
    public GamePanel() {
        setFocusable(true);
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(900, 400));

        ball = new Ball();
        paddle1 = new Paddle(30, true); // Left paddle
        paddle2 = new Paddle(850, false); // Right paddle
        scorePanel = new ScorePanel();

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                paddle1.keyPressed(e);
                paddle2.keyPressed(e);
            }

            public void keyReleased(KeyEvent e) {
                paddle1.keyReleased(e);
                paddle2.keyReleased(e);
            }
        });

        Timer timer = new Timer(5, this);
        timer.start();
    }

    /**
     * Updates the game state.
     * It updates the ball and paddles, checks collision, and triggers repainting.
     *
     * @param e the ActionEvent triggering the update
     */
    public void actionPerformed(ActionEvent e) {
        ball.update();
        paddle1.update();
        paddle2.update();

        checkCollision();

        repaint();
    }

    /**
     * Checks for collision between the ball and paddles, and handles scoring and ball reset.
     */
    private void checkCollision() {
        if (ball.getBounds().intersects(paddle1.getBounds())) {
            ball.reverseDirectionX();
        }

        if (ball.getBounds().intersects(paddle2.getBounds())) {
            ball.reverseDirectionX();
        }

        if (ball.getY() <= 0) {
            ball.reverseDirectionY();
            ball.setY(0);
        }

        if (ball.getY() >= getHeight() - ball.getHeight()) {
            ball.reverseDirectionY();
            ball.setY(getHeight() - ball.getHeight());
        }

        if (ball.getX() < 0) {
            scorePanel.incrementPlayer2Score();
            ball.reset();
        }

        if (ball.getX() > getWidth() - ball.getWidth()) {
            scorePanel.incrementPlayer1Score();
            ball.reset();
        }
    }

    /**
     * Renders the game objects on the panel.
     *
     * @param g the Graphics object for rendering
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        ball.draw(g);
        paddle1.draw(g);
        paddle2.draw(g);
        scorePanel.drawScores(g);
    }
}
