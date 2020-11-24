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
	
	//�򵥵���Ӱ�ť ����������
	private void defaultButtonAdd()
	{
		String[] commandName = {"pencl","line","brush","cycle_fill","cycle_wire","rect_fill","rect_wire","rect_rc_wire","rect_rc_fill","eraser"};
		for(String command : commandName)
		{
			JButton button = new JButton(command);
			//button.setSize(30, 30); ������Сʧ��
			//button.setSize(new Dimension(30,30));
			button.addActionListener(toolPanelListener);
			button.addMouseListener(toolPanelListener);
			this.add(button);
		}
	}
	
	//�򵥵���ӵ�ɫ�� ����������
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
