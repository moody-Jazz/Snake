
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenu extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private GameFrame gameFrame;
	private GamePanel gamePanel;
	MainMenu(GameFrame gameFrame,GamePanel gamePanel) {
		this.gameFrame = gameFrame;
		this.gamePanel = gamePanel;
        this.setPreferredSize(new Dimension(400, 500));
        this.setVisible(true);
        
        JButton startGame = new JButton("Start");
        startGame.addActionListener(this);
        this.add(startGame);
        
    }

    public void actionPerformed(ActionEvent event) {
    	if(event.getActionCommand().equals("Start")) {
    		gameFrame.cardLayout.show(gameFrame.getContentPane(), "GameAndScorePanel");
    		GamePanel.timer.start();
    		gamePanel.requestFocusInWindow();
    	}
    }
}