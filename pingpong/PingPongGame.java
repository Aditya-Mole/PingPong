package pingpong;

import javax.swing.*;

/**
 * The PingPongGame class is the entry point of the Ping Pong game.
 * It creates and starts the game frame.
 */
public class PingPongGame {
    /**
     * The main method of the Ping Pong game.
     * It creates and displays the game frame on the Swing event dispatch thread.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            /**
             * The run method executed on the Swing event dispatch thread.
             * It creates the game frame.
             */
            public void run() {
                new GameFrame();
            }
        });
    }
}
