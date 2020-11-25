import java.awt.*;
import java.awt.event.*;
import java.util.*;



public class BoardPanelListener implements MouseListener,MouseMotionListener,KeyListener{

	//光标前一时刻和当前时刻的位置
	private int x_past, y_past, x_current, y_current;
	
	//当前选择的画板工具
	public String currentCommand = new String();
		
	//当前选择的颜色
	public Color currentColor = Color.BLACK;

	//当前的画笔大小
	public int currentStroke=1;
	
	//画板的画笔
	public Graphics2D graphics;

	//获取当前画板的画笔
	public void setGraphics()
	{
		this.graphics=(Graphics2D)Main.boardPanel.getGraphics();
		this.graphics.setColor(currentColor);
		this.graphics.setStroke(new BasicStroke(currentStroke));
	}

	//当前绘制的内容 主要用来放到repaintList里面
	private Repaint currentRepaint;

	//当前按下的键盘
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
			//直线
			case "line":
			{
				setGraphics();
				graphics.drawLine(x_past, y_past, x_current, y_current);
				currentRepaint=new Repaint(Repaint.GraphtType.line, x_past, y_past,x_current,y_current,currentColor,currentStroke);
				Repaint.repaintList.add(currentRepaint);
				break;
			}
			//矩形线框
			case "rect_wire":
			{
				setGraphics();
				graphics.drawRect(x, y, width, height);
				currentRepaint=new Repaint(Repaint.GraphtType.rect_wire, x,y,width,height,currentColor,currentStroke);
				Repaint.repaintList.add(currentRepaint);
				break;
			}
			//矩形圆角线框
			case "rect_rc_wire":
			{
				setGraphics();
				//圆角的横向直径和纵向直径应该按照长宽设置
				graphics.drawRoundRect(x, y, width, height, 30,30);
				currentRepaint = new Repaint(Repaint.GraphtType.rect_rc_wire, x, y, width, height,currentColor,currentStroke,30,30);
				Repaint.repaintList.add(currentRepaint);
				break;
			}
			//矩形填充
			case "rect_fill":
			{
				setGraphics();
				graphics.fillRect(x, y, width, height);
				currentRepaint=new Repaint(Repaint.GraphtType.rect_fill, x,y,width,height,currentColor,currentStroke);
				Repaint.repaintList.add(currentRepaint);
				break;
			}
			//矩形圆角填充
			case "rect_rc_fill":
			{
				setGraphics();
				//圆角的横向直径和纵向直径应该按照长宽设置
				graphics.fillRoundRect(x, y, width, height, 30,30);
				currentRepaint = new Repaint(Repaint.GraphtType.rect_rc_fill, x, y, width, height,currentColor,currentStroke,30,30);
				Repaint.repaintList.add(currentRepaint);
				break;
			}
			//圆形线框
			case "cycle_wire":
			{
				setGraphics();
				graphics.drawOval(x, y, width, height);
				currentRepaint= new Repaint(Repaint.GraphtType.cycle_wire, x, y, width, height,currentColor,currentStroke);
				Repaint.repaintList.add(currentRepaint);
				break;
			}
			//圆形填充
			case "cycle_fill":
			{
				setGraphics();
				graphics.fillOval(x, y, width, height);
				currentRepaint= new Repaint(Repaint.GraphtType.cycle_fill, x, y, width, height,currentColor,currentStroke);
				Repaint.repaintList.add(currentRepaint);
				break;
			}
			//铅笔 提交给repaintlist
			case "pencil":
			{
				Repaint.repaintList.add(currentRepaint);
				break;
			}
			//橡皮 提交给repaintlist
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
				//橡皮的颜色固定为背景颜色
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
		System.out.print("按下"+KeyEvent.getKeyText(e.getKeyCode())+"\n");
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
		System.out.print("放开"+KeyEvent.getKeyText(e.getKeyCode())+"\n");
		if(e.getKeyCode()==17)
			is_ctrl_pressed=false;
	}

	

}
