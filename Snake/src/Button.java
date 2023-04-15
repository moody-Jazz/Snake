
import javax.swing.JButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	Button(Component parent,String name,int x, int y,int width, int height){
		switch(name) {
		case "Retry":System.out.println("Retry");
			retry(parent,name,x,y,width,height);
			break;
		case "Quit":System.out.println("Quit");
			quit(parent,name,x,y,width,height);
			break;
		}
	}
	void retry(Component parent,String name,int x, int y, int width, int height) {
		this.setBackground(GamePanel.bgColor);
        this.setBorder(null);
		this.setText(name);
        this.setFont(new Font("Arial", Font.BOLD, 30));
        this.setForeground(Color.white);
        this.setBounds(x,y,width,height);
        this.addActionListener(this);
	}
	
	void quit(Component parent, String name, int x, int y, int width, int height) {
		this.setBackground(GamePanel.bgColor);
        this.setBorder(null);
		this.setText(name);
        this.setFont(new Font("Arial", Font.BOLD, 30));
        this.setForeground(Color.white);
        this.setBounds(x,y,width,height);
        this.addActionListener(this);
	}
	
		@Override
		public void actionPerformed(ActionEvent event) {

			if(event.getActionCommand().equals("Retry")) {
				System.out.println("Retry Pressed");
			}
			else if(event.getActionCommand().equals("Quit")) {
				
			}
		}
	
}
