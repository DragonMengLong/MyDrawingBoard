import java.awt.*;
import java.awt.event.*;



public class BoardPanelListener implements MouseListener,MouseMotionListener{

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
		this.graphics.setStroke(new BasicStroke(1));
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		 
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		 
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		 
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		x_past=arg0.getX();
		y_past=arg0.getY();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		 
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
			case "rect_rc_wire":
			{
				x_current=arg0.getX();
				y_current=arg0.getY();
				setGraphics();
				//Բ�ǵĺ���ֱ��������ֱ��Ӧ�ð��ճ�������
				graphics.drawRoundRect(Math.min(x_past, x_current), Math.min(y_past, y_current), Math.abs(x_current-x_past), Math.abs(y_current-y_past), 30,30);
				break;
			}
			//�������
			case "rect_fill":
			{
				x_current=arg0.getX();
				y_current=arg0.getY();
				setGraphics();
				graphics.fillRect(Math.min(x_past, x_current), Math.min(y_past, y_current), Math.abs(x_current-x_past), Math.abs(y_current-y_past));
				break;
			}
			//����Բ�����
			case "rect_rc_fill":
			{
				x_current=arg0.getX();
				y_current=arg0.getY();
				setGraphics();
				//Բ�ǵĺ���ֱ��������ֱ��Ӧ�ð��ճ�������
				graphics.fillRoundRect(Math.min(x_past, x_current), Math.min(y_past, y_current), Math.abs(x_current-x_past), Math.abs(y_current-y_past), 30, 30);
				break;
			}
			//Բ���߿�
			case "cycle_wire":
			{
				x_current=arg0.getX();
				y_current=arg0.getY();
				setGraphics();
				graphics.drawOval(Math.min(x_past, x_current), Math.min(y_past, y_current), Math.abs(x_current-x_past), Math.abs(y_current-y_past));
				break;
			}
			//Բ�����
			case "cycle_fill":
			{
				x_current=arg0.getX();
				y_current=arg0.getY();
				setGraphics();
				graphics.fillOval(Math.min(x_past, x_current), Math.min(y_past, y_current), Math.abs(x_current-x_past), Math.abs(y_current-y_past));
				break;
			}
		}
		
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		switch (currentCommand) 
		{
			case "pencil":
			{
				x_current=e.getX();
				y_current=e.getY();
				setGraphics();
				graphics.drawLine(x_past,y_past,x_current,y_current);
				x_past=x_current;
				y_past=y_current;
				break;
			}
			case "eraser":
			{
				x_current=e.getX();
				y_current=e.getY();
				setGraphics();
				graphics.setStroke(new BasicStroke(50));
				graphics.setColor(Main.boardPanel.getBackground());
				graphics.drawLine(x_past,y_past,x_current,y_current);
				x_past=x_current;
				y_past=y_current;
				break;
			}	
			default:
				break;
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		

	}

}
