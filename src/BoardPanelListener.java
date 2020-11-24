import java.awt.*;
import java.awt.event.*;

public class BoardPanelListener implements MouseListener{

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
		System.out.print("按下");
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
			case "rect_re_wire":
			{
				x_current=arg0.getX();
				y_current=arg0.getY();
				setGraphics();
			
				
			}
		}
		
	}

}
