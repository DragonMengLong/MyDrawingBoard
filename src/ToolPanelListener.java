import java.awt.event.*;
import javax.swing.*;

//�������ڶԻ����������ĵ�ǰ��ť�͵�ǰ��ɫ�����޸�
public class ToolPanelListener implements ActionListener, MouseListener {
	
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
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		String currentCommand = arg0.getActionCommand();
		System.out.print("�����"+currentCommand);
		
		if(currentCommand.equals("color"))
		{
			BoardPanel.boardPanelListener.currentColor=((JButton)arg0.getSource()).getBackground();
		}
		else
		{
			BoardPanel.boardPanelListener.currentCommand=currentCommand;
		}
	}

}
