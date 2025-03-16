import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	private GameFrame gameFrame;
	private GamePanel gamePanel;

	static CardLayout cardLayout = new CardLayout();
	static JPanel cardPanel = new JPanel(); 
	
	public MainMenu(GameFrame gameFrame, GamePanel gamePanel) {
		this.gameFrame = gameFrame;
		this.gamePanel = gamePanel;
		this.setBackground(new Color(40,38,52));
		setLayout(null);
		ImageIcon icon = new ImageIcon("logo.PNG");

		JPanel logoPanel = new JPanel();
		double posX = GamePanel.SCREEN_WIDTH - icon.getIconWidth();
		posX /= 2;
		logoPanel.setBounds((int)posX, 31, icon.getIconWidth(), 168);
		logoPanel.setBackground(new Color(40,38,52));
		add(logoPanel);

		JLabel lblIcon = new JLabel(icon);
		lblIcon.repaint();
		logoPanel.add(lblIcon);

		posX = GamePanel.SCREEN_WIDTH - GamePanel.SCREEN_WIDTH * 0.65;
		posX /= 2;
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds((int)posX, 10, (int)(GamePanel.SCREEN_WIDTH * 0.65), 382);
		mainPanel.setBackground(new Color(40,38,52));
		mainPanel.setLayout(null);
		
		
		cardPanel.setBounds(10, 221, 580, 369);
		cardPanel.setBackground(new Color(40,38,52));
		Themes themes = new Themes();
		add(cardPanel);
		cardPanel.setLayout(cardLayout);
		cardPanel.add(mainPanel,"mainPanel");
		cardPanel.add(themes,"themes");
		cardLayout.show(cardPanel,"mainPanel");
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(93, 21, 378, 106);
		btnStart.setFont(new Font("Consolas", Font.PLAIN, 50));
		btnStart.setForeground(new Color(254, 64, 86));
		btnStart.setBackground(new Color(40,38,52));
		btnStart.setBorder(null);
		btnStart.setFocusPainted(false);
		mainPanel.add(btnStart);
		btnStart.addActionListener(this);

		JButton btnThemes = new JButton("Themes");
		btnThemes.setBounds(93, 137, 378, 106);
		btnThemes.setFont(new Font("Consolas", Font.PLAIN, 50));
		btnThemes.setForeground(new Color(254, 64, 86));
		btnThemes.setBackground(new Color(40,38,52));
		btnThemes.setBorder(null);
		btnThemes.setFocusPainted(false);
		mainPanel.add(btnThemes);
		btnThemes.addActionListener(this);

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(93, 253, 378, 106);
		btnExit.setFont(new Font("Consolas", Font.PLAIN, 50));
		btnExit.setForeground(new Color(254, 64, 86));
		btnExit.setBackground(new Color(40,38,52));
		btnExit.setBorder(null);
		btnExit.setFocusPainted(false);
		mainPanel.add(btnExit );
		btnExit.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("Start")) {
			gameFrame.cardLayout.show(gameFrame.getContentPane(), "GameAndScorePanel");
			GamePanel.timer.start();
			gamePanel.requestFocusInWindow();
		} else if (event.getActionCommand().equals("Exit")) {
			System.exit(ABORT);
		} else if(event.getActionCommand().equals("Themes")) {
			cardLayout.show(cardPanel,"themes");
		}

	}
}
