import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

class Themes extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	Themes() {

		this.setBounds(10, 10, 560, 382);
		this.setBackground(new Color(40, 38, 52));
		this.setLayout(null);

		JButton btnDarkDungeon = new JButton("Dark Dungeon");
		btnDarkDungeon.setBounds(93, 21, 378, 106);
		btnDarkDungeon.setFont(new Font("Consolas", Font.PLAIN, 50));
		btnDarkDungeon.setForeground(new Color(254, 64, 86));
		btnDarkDungeon.setBackground(new Color(40, 38, 52));
		btnDarkDungeon.setBorder(null);
		btnDarkDungeon.setFocusPainted(false);
		this.add(btnDarkDungeon);
		btnDarkDungeon.addActionListener(this);

		JButton btnGreenFields = new JButton("Green Fields");
		btnGreenFields.setBounds(93, 137, 378, 106);
		btnGreenFields.setFont(new Font("Consolas", Font.PLAIN, 50));
		btnGreenFields.setForeground(new Color(254, 64, 86));
		btnGreenFields.setBackground(new Color(40, 38, 52));
		btnGreenFields.setBorder(null);
		btnGreenFields.setFocusPainted(false);
		this.add(btnGreenFields);
		btnGreenFields.addActionListener(this);

		JButton btnColorful = new JButton("Rainbow Ride");
		btnColorful.setBounds(93, 253, 378, 106);
		btnColorful.setFont(new Font("Consolas", Font.PLAIN, 50));
		btnColorful.setForeground(new Color(254, 64, 86));
		btnColorful.setBackground(new Color(40, 38, 52));
		btnColorful.setBorder(null);
		btnColorful.setFocusPainted(false);
		this.add(btnColorful);
		btnColorful.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String args[] = new String[0];
		if (event.getActionCommand().equals("Rainbow Ride")) {
			staticColors.bgColor = new Color(255, 228, 248);
			staticColors.headColor = Color.black;
			staticColors.btnColor = new Color(255, 225, 245);
			staticColors.btnTextColor = new Color(105, 45, 162);
			GamePanel.colorFul = true;
			Main.gameFrame.setVisible(false);
			Main.main(args);
		} else if (event.getActionCommand().equals("Dark Dungeon")) {
			staticColors.bgColor = new Color(40, 38, 52);
			staticColors.headColor = new Color(88, 87, 96);
			staticColors.bodyColor = new Color(218, 218, 218);
			staticColors.appleColor = new Color(254, 64, 86);
			staticColors.btnColor = new Color(40, 38, 52);
			staticColors.btnTextColor = new Color(254, 64, 86);
			Main.gameFrame.setVisible(false);
			GamePanel.colorFul = false;
			Main.main(args);
		} else if (event.getActionCommand().equals("Green Fields")) {
			staticColors.bgColor = new Color(102, 255, 102);
			staticColors.headColor = new Color(0, 20, 51);
			staticColors.bodyColor = new Color(0, 71, 179);
			staticColors.appleColor = new Color(255, 51, 51);
			staticColors.btnColor = new Color(102, 255, 102);
			staticColors.btnTextColor = Color.white;
			GamePanel.colorFul = false;
			Main.gameFrame.setVisible(false);
			Main.main(args);
		}
	}
}