package pingpong;

import javax.swing.*;

/**
 * The GameFrame class represents the main frame of the Ping Pong game.
 * It sets up the frame properties and adds the game panel to it.
 */
public class GameFrame extends JFrame {
    /**
     * Constructs a new instance of the GameFrame class.
     * It sets up the frame title, size, default close operation, and adds the game panel to the frame.
     */
    public GameFrame() {
        setTitle("Ping Pong Game");
        setSize(900, 400); // Increased width to accommodate both scores
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        GamePanel gamePanel = new GamePanel();
        add(gamePanel);

        setVisible(true);
    }
}
