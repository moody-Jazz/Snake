import javax.swing.JFrame;
import java.awt.BorderLayout;

public class GameFrame extends JFrame {


	private static final long serialVersionUID = 1L;
    GameFrame() throws InterruptedException {
        this.setTitle("Snake");
        this.setResizable(false);

        GamePanel gamePanel = new GamePanel();
        ScorePanel scorePanel = new ScorePanel();
        MainMenu menuPanel = new MainMenu();
        this.add(menuPanel);
        this.setLayout(new BorderLayout());
        this.add(gamePanel, BorderLayout.NORTH);
        this.add(scorePanel, BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}