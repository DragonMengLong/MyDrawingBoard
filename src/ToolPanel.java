import java.awt.Color;
import java.awt.*;
import javax.swing.*;

public class ToolPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private ToolPanelListener toolPanelListener = new ToolPanelListener();

	public ToolPanel() {

		this.setPreferredSize(new Dimension(0,50));
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		defaultButtonAdd();
		defaultColorBoardAdd();
	}
	
	//简单的添加按钮 仅仅调试用
	private void defaultButtonAdd()
	{
		String[] commandName = {"pencl","line","brush","cycle_fill","cycle_wire","rect_fill","rect_wire","rect_rc_wire","rect_rc_fill","eraser"};
		for(String command : commandName)
		{
			JButton button = new JButton(command);
			//button.setSize(30, 30); 调整大小失败
			//button.setSize(new Dimension(30,30));
			button.addActionListener(toolPanelListener);
			button.addMouseListener(toolPanelListener);
			this.add(button);
		}
	}
	
	//简单的添加调色板 仅仅调试用
	private void defaultColorBoardAdd()
	{
		Color[] colors = {Color.BLACK,Color.WHITE,Color.RED,Color.GREEN,Color.BLUE};
		for(Color color : colors)
		{
			JButton colorButton = new JButton();
			colorButton.setActionCommand("color");
			colorButton.setBackground(color);
			colorButton.addActionListener(toolPanelListener);
			colorButton.addMouseListener(toolPanelListener);
			this.add(colorButton);
		}
	}

}
