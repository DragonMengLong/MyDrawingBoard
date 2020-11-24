import java.awt.*;
import java.awt.event.*;



public class BoardPanelListener implements MouseListener,MouseMotionListener{

	//光标前一时刻和当前时刻的位置
	private int x_past, y_past, x_current, y_current;
	
	//当前选择的画板工具
	public String currentCommand = new String();
		
	//当前选择的颜色
	public Color currentColor = Color.BLACK;
	
	//画板的画笔
	public Graphics2D graphics;
	//获取当前画板的画笔
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
			//直线
			case "line":
			{
				x_current=arg0.getX();
				y_current=arg0.getY();
				setGraphics();
				graphics.drawLine(x_past, y_past, x_current, y_current);
				break;
			}
			//矩形线框
			case "rect_wire":
			{
				x_current=arg0.getX();
				y_current=arg0.getY();
				setGraphics();
				graphics.drawRect(Math.min(x_past, x_current), Math.min(y_past, y_current), Math.abs(x_current-x_past), Math.abs(y_current-y_past));
				break;
			}
			//矩形圆角线框
			case "rect_rc_wire":
			{
				x_current=arg0.getX();
				y_current=arg0.getY();
				setGraphics();
				//圆角的横向直径和纵向直径应该按照长宽设置
				graphics.drawRoundRect(Math.min(x_past, x_current), Math.min(y_past, y_current), Math.abs(x_current-x_past), Math.abs(y_current-y_past), 30,30);
				break;
			}
			//矩形填充
			case "rect_fill":
			{
				x_current=arg0.getX();
				y_current=arg0.getY();
				setGraphics();
				graphics.fillRect(Math.min(x_past, x_current), Math.min(y_past, y_current), Math.abs(x_current-x_past), Math.abs(y_current-y_past));
				break;
			}
			//矩形圆角填充
			case "rect_rc_fill":
			{
				x_current=arg0.getX();
				y_current=arg0.getY();
				setGraphics();
				//圆角的横向直径和纵向直径应该按照长宽设置
				graphics.fillRoundRect(Math.min(x_past, x_current), Math.min(y_past, y_current), Math.abs(x_current-x_past), Math.abs(y_current-y_past), 30, 30);
				break;
			}
			//圆形线框
			case "cycle_wire":
			{
				x_current=arg0.getX();
				y_current=arg0.getY();
				setGraphics();
				graphics.drawOval(Math.min(x_past, x_current), Math.min(y_past, y_current), Math.abs(x_current-x_past), Math.abs(y_current-y_past));
				break;
			}
			//圆形填充
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
