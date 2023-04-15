import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class MainMenu extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	MainMenu() {
        this.setPreferredSize(new Dimension(400, 500));
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {

    }
}