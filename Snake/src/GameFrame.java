import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;

public class GameFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	CardLayout cardLayout = new CardLayout();
    GameFrame() {
        this.setTitle("Snake");
        this.setResizable(false);
        
        getContentPane().setLayout(cardLayout);
        
        GamePanel gamePanel = new GamePanel(this);
        ScorePanel scorePanel = new ScorePanel();
        JPanel gameAndScorePanel = new JPanel();
        MainMenu menuPanel = new MainMenu(this,gamePanel);
        
        
        //inserting game and score panel into a seperate JPanel GameAndScorePanel;
        gameAndScorePanel.setLayout(new BorderLayout());
        gameAndScorePanel.add(gamePanel, BorderLayout.NORTH);
        gameAndScorePanel.add(scorePanel, BorderLayout.SOUTH);
        
        getContentPane().add(menuPanel,"MenuPanel");
        getContentPane().add(gameAndScorePanel,"GameAndScorePanel");
        
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}