
import javax.swing.JButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverButtons extends JButton implements ActionListener {

	private static final long serialVersionUID = 1L;
	private GamePanel game;
	private GameFrame gameFrame;
	GameOverButtons(GameFrame gameFrame, GamePanel gamepanel, String name, int x, int y, int width, int height) {
		game = gamepanel;
		this.gameFrame = gameFrame;
		switch (name) {
		case "Retry":
			retry(name, x, y, width, height);
			break;
		case "Quit":
			quit(name, x, y, width, height);
			break;
		}
	}

	void retry(String name, int x, int y, int width, int height) {
		
		this.setBorder(null);
		this.setFocusPainted(false);
		this.setText(name);
		this.setFont(new Font("Consolas", Font.PLAIN, 40));
		this.setForeground(staticColors.btnTextColor);
		this.setBounds(x, y, width+10, height);
		this.setBackground(staticColors.btnColor);
		this.addActionListener(this);
	}

	void quit(String name, int x, int y, int width, int height) {
		
		this.setBorder(null);
		this.setFocusPainted(false);
		this.setText(name);
		this.setFont(new Font("Consolas", Font.PLAIN, 40));
		this.setForeground(staticColors.btnTextColor);
		this.setBounds(x, y, width, height);
		this.setBackground(staticColors.btnColor);
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("Retry")) {
			game.startGame();
			GamePanel.timer.start();
		}
		if (event.getActionCommand().equals("Quit")) {
			game.startGame();
			GamePanel.timer.stop();
			gameFrame.cardLayout.show(gameFrame.getContentPane(), "MenuPanel");
		}
	}

}
