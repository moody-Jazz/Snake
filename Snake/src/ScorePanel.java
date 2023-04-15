
//import static com.mycompany.snake.GamePanel.SCREEN_WIDTH;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ScorePanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	static JLabel scoreLabel = new JLabel("Score: 0");
    static JLabel highestScore = new JLabel("Highest Score: 0");

    ScorePanel() {
        scoreLabel.setFont(new Font(scoreLabel.getFont().getName(), scoreLabel.getFont().getStyle(), 24));
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        highestScore.setFont(new Font(highestScore.getFont().getName(), highestScore.getFont().getStyle(), 24));
        highestScore.setHorizontalAlignment(SwingConstants.CENTER);

        this.setLayout(new GridLayout(1, 2));
        this.setPreferredSize(new Dimension(GamePanel.SCREEN_WIDTH, 40));
        

        this.add(scoreLabel);
        this.add(highestScore);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {

    }
}