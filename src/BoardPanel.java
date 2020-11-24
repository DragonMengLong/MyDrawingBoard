import java.awt.*;

import javax.swing.JPanel;

public class BoardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
		

	//画板的监听器 工具栏监听器会对其进行修改 故为静态
	public static BoardPanelListener boardPanelListener = new BoardPanelListener();
	
	public BoardPanel(int width,int height) {
		
		//设置画板的大小和颜色
		this.setSize(width,height);
		this.setPreferredSize(new Dimension(width,height));
		
		//设置画板的背景颜色
		this.setBackground(Color.WHITE);
		
		//设置画笔的位置
		this.setBounds(0,0,width,height);
		
		//添加监听器
		this.addMouseListener(boardPanelListener);
		this.addMouseMotionListener(boardPanelListener);
		//boardPanelListener.graphics=(Graphics2D)this.getGraphics(); 在构造函数内部进行getGraphics得出的值为空值
		
		//添加画板并通过repaint显示，若不repaint则只有调整主窗口大小时才会显现
		Main.mainWindow.boardBackPanel.add(this);
		Main.mainWindow.repaint();
	}
	
}
