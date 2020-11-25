import java.awt.*;
import java.awt.event.*;
import java.util.*;



public class BoardPanelListener implements MouseListener,MouseMotionListener,KeyListener{

	//���ǰһʱ�̺͵�ǰʱ�̵�λ��
	private int x_past, y_past, x_current, y_current;
	
	//��ǰѡ��Ļ��幤��
	public String currentCommand = new String();
		
	//��ǰѡ�����ɫ
	public Color currentColor = Color.BLACK;

	//��ǰ�Ļ��ʴ�С
	public int currentStroke=1;
	
	//����Ļ���
	public Graphics2D graphics;

	//��ȡ��ǰ����Ļ���
	public void setGraphics()
	{
		this.graphics=(Graphics2D)Main.boardPanel.getGraphics();
		this.graphics.setColor(currentColor);
		this.graphics.setStroke(new BasicStroke(currentStroke));
	}

	//��ǰ���Ƶ����� ��Ҫ�����ŵ�repaintList����
	private Repaint currentRepaint;

	//��ǰ���µļ���
	private boolean is_ctrl_pressed =false;
	
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
		switch (currentCommand) {
			case "pencil":
				currentRepaint = new Repaint(Repaint.GraphtType.pencil,currentColor,currentStroke);
				currentRepaint.positionList=new LinkedList<Repaint.Position>();
				currentRepaint.positionList.add(new Repaint.Position(x_past,y_past));
				break;
			case "eraser":
				currentRepaint = new Repaint(Repaint.GraphtType.eraser, currentColor, currentStroke);
				currentRepaint.positionList=new LinkedList<Repaint.Position>();
				currentRepaint.positionList.add(new Repaint.Position(x_past,y_past));
			default:
				break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		 
		x_current=arg0.getX();
		y_current=arg0.getY();
		int x=Math.min(x_past, x_current);
		int y=Math.min(y_past, y_current);
		int width=Math.abs(x_current-x_past);
		int height=Math.abs(y_current-y_past);

		switch(currentCommand)
		{
			//ֱ��
			case "line":
			{
				setGraphics();
				graphics.drawLine(x_past, y_past, x_current, y_current);
				currentRepaint=new Repaint(Repaint.GraphtType.line, x_past, y_past,x_current,y_current,currentColor,currentStroke);
				Repaint.repaintList.add(currentRepaint);
				break;
			}
			//�����߿�
			case "rect_wire":
			{
				setGraphics();
				graphics.drawRect(x, y, width, height);
				currentRepaint=new Repaint(Repaint.GraphtType.rect_wire, x,y,width,height,currentColor,currentStroke);
				Repaint.repaintList.add(currentRepaint);
				break;
			}
			//����Բ���߿�
			case "rect_rc_wire":
			{
				setGraphics();
				//Բ�ǵĺ���ֱ��������ֱ��Ӧ�ð��ճ�������
				graphics.drawRoundRect(x, y, width, height, 30,30);
				currentRepaint = new Repaint(Repaint.GraphtType.rect_rc_wire, x, y, width, height,currentColor,currentStroke,30,30);
				Repaint.repaintList.add(currentRepaint);
				break;
			}
			//�������
			case "rect_fill":
			{
				setGraphics();
				graphics.fillRect(x, y, width, height);
				currentRepaint=new Repaint(Repaint.GraphtType.rect_fill, x,y,width,height,currentColor,currentStroke);
				Repaint.repaintList.add(currentRepaint);
				break;
			}
			//����Բ�����
			case "rect_rc_fill":
			{
				setGraphics();
				//Բ�ǵĺ���ֱ��������ֱ��Ӧ�ð��ճ�������
				graphics.fillRoundRect(x, y, width, height, 30,30);
				currentRepaint = new Repaint(Repaint.GraphtType.rect_rc_fill, x, y, width, height,currentColor,currentStroke,30,30);
				Repaint.repaintList.add(currentRepaint);
				break;
			}
			//Բ���߿�
			case "cycle_wire":
			{
				setGraphics();
				graphics.drawOval(x, y, width, height);
				currentRepaint= new Repaint(Repaint.GraphtType.cycle_wire, x, y, width, height,currentColor,currentStroke);
				Repaint.repaintList.add(currentRepaint);
				break;
			}
			//Բ�����
			case "cycle_fill":
			{
				setGraphics();
				graphics.fillOval(x, y, width, height);
				currentRepaint= new Repaint(Repaint.GraphtType.cycle_fill, x, y, width, height,currentColor,currentStroke);
				Repaint.repaintList.add(currentRepaint);
				break;
			}
			//Ǧ�� �ύ��repaintlist
			case "pencil":
			{
				Repaint.repaintList.add(currentRepaint);
				break;
			}
			//��Ƥ �ύ��repaintlist
			case "eraser":
			{
				Repaint.repaintList.add(currentRepaint);
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
				currentRepaint.positionList.add(new Repaint.Position(x_current, y_current));
				x_past=x_current;
				y_past=y_current;
				break;
			}
			case "eraser":
			{
				x_current=e.getX();
				y_current=e.getY();
				setGraphics();
				//��Ƥ����ɫ�̶�Ϊ������ɫ
				graphics.setColor(Main.boardPanel.getBackground());
				graphics.drawLine(x_past,y_past,x_current,y_current);
				currentRepaint.positionList.add(new Repaint.Position(x_current, y_current));
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

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.print("����"+KeyEvent.getKeyText(e.getKeyCode())+"\n");
		System.out.print(e.getKeyCode());
		//17 ctrl 83s 90z
		if(e.getKeyCode()==17)
			is_ctrl_pressed=true;
		if(e.getKeyCode()==90&&is_ctrl_pressed==true)
		{
			Repaint.repaintList.pollLast();
			Main.boardPanel.repaint();
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		System.out.print("�ſ�"+KeyEvent.getKeyText(e.getKeyCode())+"\n");
		if(e.getKeyCode()==17)
			is_ctrl_pressed=false;
	}

	

}
