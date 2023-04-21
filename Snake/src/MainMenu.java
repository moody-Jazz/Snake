import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class MainMenu extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	private GameFrame gameFrame;
	private GamePanel gamePanel;
	static Color btnColor = new Color(41, 39, 52);
	static Color bgColor = new Color(41, 39, 52);
	static Color btnTextColor = new Color(254, 64, 86);
	public MainMenu(GameFrame gameFrame,GamePanel gamePanel) {
		this.gameFrame = gameFrame;
		this.gamePanel = gamePanel;
		this.setBackground(bgColor);
		setLayout(null);
		URL url = getClass().getResource("logo.PNG");
		ImageIcon icon = new ImageIcon(url);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 10, 580, 168);
		panel_2.setBackground(bgColor);
		add(panel_2);
		
		
		JLabel lblIcon = new JLabel(icon);

		lblIcon.repaint();
		
		panel_2.add(lblIcon);
		
	
		
		JPanel panel = new JPanel();
		panel.setBounds(106, 222, 398, 368);
		add(panel);
		panel.setBackground(bgColor);
		panel.setLayout(null);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(10, 23, 378, 106);
		btnStart.setFont(new Font("Consolas", Font.PLAIN, 50));
		btnStart.setForeground(btnTextColor);
		btnStart.setBackground(btnColor);
		btnStart.setBorder(null);
		btnStart.setFocusPainted(false);
		panel.add(btnStart);
		btnStart.addActionListener(this);
		
		JButton btnTheme = new JButton("Theme");
		btnTheme.setBounds(10, 139, 378, 106);
		btnTheme.setFont(new Font("Consolas", Font.PLAIN, 50));
		btnTheme.setForeground(btnTextColor);
		btnTheme.setBackground(btnColor);
		btnTheme.setBorder(null);
		btnTheme.setFocusPainted(false);
		panel.add(btnTheme);
		btnTheme.addActionListener(this);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(10, 255, 378, 106);
		btnExit.setFont(new Font("Consolas", Font.PLAIN, 50));
		btnExit.setForeground(btnTextColor);
		btnExit.setBackground(btnColor);
		btnExit.setBorder(null);
		btnExit.setFocusPainted(false);
		panel.add(btnExit);
		btnExit.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("Start")) {
    		gameFrame.cardLayout.show(gameFrame.getContentPane(), "GameAndScorePanel");
    		GamePanel.timer.start();
    		gamePanel.requestFocusInWindow();
    	}
		else if(event.getActionCommand().equals("Exit")) {
			System.exit(ABORT);
		}
		
	
	}
}

