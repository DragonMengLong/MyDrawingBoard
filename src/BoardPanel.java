import java.awt.*;

import javax.swing.JPanel;

public class BoardPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public BoardPanel(int width,int height) {
		this.setSize(width,height);
		this.setPreferredSize(new Dimension(width,height));
		this.setBackground(Color.WHITE);
		this.setBounds(0,0,width,height);
		Main.mainWindow.boardBackPanel.add(this);
		Main.mainWindow.repaint();
		
	}

}
