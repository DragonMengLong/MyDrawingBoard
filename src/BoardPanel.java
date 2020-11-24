import java.awt.*;

import javax.swing.JPanel;

public class BoardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
		

	//����ļ����� ���������������������޸� ��Ϊ��̬
	public static BoardPanelListener boardPanelListener = new BoardPanelListener();
	
	public BoardPanel(int width,int height) {
		
		//���û���Ĵ�С����ɫ
		this.setSize(width,height);
		this.setPreferredSize(new Dimension(width,height));
		
		//���û���ı�����ɫ
		this.setBackground(Color.WHITE);
		
		//���û��ʵ�λ��
		this.setBounds(0,0,width,height);
		
		//��Ӽ�����
		this.addMouseListener(boardPanelListener);
		this.addMouseMotionListener(boardPanelListener);
		//boardPanelListener.graphics=(Graphics2D)this.getGraphics(); �ڹ��캯���ڲ�����getGraphics�ó���ֵΪ��ֵ
		
		//��ӻ��岢ͨ��repaint��ʾ������repaint��ֻ�е��������ڴ�Сʱ�Ż�����
		Main.mainWindow.boardBackPanel.add(this);
		Main.mainWindow.repaint();
	}
	
}
