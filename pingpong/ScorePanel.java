package pingpong;

import java.awt.*;

/**
 * The ScorePanel class represents the panel that displays the scores of both players.
 * It keeps track of the player scores and provides methods to increment and render the scores.
 */
public class ScorePanel {
    private int player1Score = 0;
    private int player2Score = 0;
    private Font retroFont;

    /**
     * Constructs a new instance of the ScorePanel class.
     * It initializes the retro font for the score display.
     */
    public ScorePanel() {
        retroFont = new Font("Press Start 2P", Font.BOLD, 20);
    }

    /**
     * Increments the score of Player 1.
     */
    public void incrementPlayer1Score() {
        player1Score++;
    }

    /**
     * Increments the score of Player 2.
     */
    public void incrementPlayer2Score() {
        player2Score++;
    }

    /**
     * Renders the scores on the specified Graphics object.
     *
     * @param g the Graphics object for rendering
     */
    public void drawScores(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(retroFont);
        g.drawString("Player 1: " + player1Score, 20, 30);
        g.drawString("Player 2: " + player2Score, 700, 30);
    }
}
