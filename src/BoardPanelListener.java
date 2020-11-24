import java.awt.*;
import java.awt.event.*;

public class BoardPanelListener implements MouseListener{

	//���ǰһʱ�̺͵�ǰʱ�̵�λ��
	private int x_past, y_past, x_current, y_current;
	
	//��ǰѡ��Ļ��幤��
	public String currentCommand = new String();
		
	//��ǰѡ�����ɫ
	public Color currentColor = Color.BLACK;
	
	//����Ļ���
	public Graphics2D graphics;
	//��ȡ��ǰ����Ļ���
	public void setGraphics()
	{
		this.graphics=(Graphics2D)Main.boardPanel.getGraphics();
		this.graphics.setColor(currentColor);

	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.print("����");
		if(currentCommand.equals("line")||currentCommand.equals("cycle")||currentCommand.equals("square"))
		{
			x_past=arg0.getX();
			y_past=arg0.getY();
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		switch(currentCommand)
		{
			//ֱ��
			case "line":
			{
				x_current=arg0.getX();
				y_current=arg0.getY();
				setGraphics();
				graphics.drawLine(x_past, y_past, x_current, y_current);
				break;
			}
			//�����߿�
			case "rect_wire":
			{
				x_current=arg0.getX();
				y_current=arg0.getY();
				setGraphics();
				graphics.drawRect(Math.min(x_past, x_current), Math.min(y_past, y_current), Math.abs(x_current-x_past), Math.abs(y_current-y_past));
				break;
			}
			//����Բ���߿�
			case "rect_re_wire":
			{
				x_current=arg0.getX();
				y_current=arg0.getY();
				setGraphics();
			
				
			}
		}
		
	}

}
