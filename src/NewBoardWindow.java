import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class NewBoardWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JTextField widthTextField;
	
	private JTextField heightTextField;
	
	private JButton confirmButton;

	public NewBoardWindow() {
		
		//����������
		ButtonListener buttonListener = new ButtonListener();
		
		getContentPane().setBackground(Color.DARK_GRAY);
		this.setTitle("�����µĻ���");
		this.setLocationRelativeTo(Main.mainWindow);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(400,200);
		
		//�̶����ڴ�С �����Ű�
		this.setResizable(false);
		this.getContentPane().setLayout(null);
		
		//����Ŀ�JLabel
		JLabel widthLabel = new JLabel("����Ŀ�Ϊ��");
		widthLabel.setBounds(81,21,120,40);
		widthLabel.setFont(new Font("΢ܛ�����w", Font.PLAIN, 18));
		widthLabel.setForeground(Color.WHITE);
		this.getContentPane().add(widthLabel);
		
		//����ĸ�JLabel
		JLabel heightLabel = new JLabel("����ĸ�Ϊ��");
		heightLabel.setBounds(81,71,120,40);
		heightLabel.setFont(new Font("΢ܛ�����w", Font.PLAIN, 18));
		heightLabel.setForeground(Color.WHITE);
		this.getContentPane().add(heightLabel);
		
		//����Ŀ�����
		widthTextField = new JTextField(4);
		widthTextField.setForeground(Color.WHITE);
		widthTextField.setBackground(Color.GRAY);
		widthTextField.setBounds(211,30,84,26);
		widthTextField.addActionListener(buttonListener);
		widthTextField.getDocument().addDocumentListener(buttonListener);
		this.getContentPane().add(widthTextField);
		
		//����ĸ�����
		heightTextField = new JTextField(4);
		heightTextField.setForeground(Color.WHITE);
		heightTextField.setBackground(Color.GRAY);
		heightTextField.setBounds(211, 80, 84, 26);
		heightTextField.addActionListener(buttonListener);
		heightTextField.getDocument().addDocumentListener(buttonListener);
		getContentPane().add(heightTextField);
		
		//ɫ��ģʽ��ť
		JRadioButton blackWhiteButton = new JRadioButton("�ڰ�");
		blackWhiteButton.setForeground(Color.WHITE);
		blackWhiteButton.setBackground(Color.DARK_GRAY);
		blackWhiteButton.setFont(new Font("΢ܛ�����w", Font.PLAIN, 16));
		blackWhiteButton.setBounds(162,130,63,26);
		JRadioButton colorButton = new JRadioButton("��ɫ",true);
		colorButton.setForeground(Color.WHITE);
		colorButton.setBackground(Color.DARK_GRAY);
		colorButton.setFont(new Font("΢ܛ�����w", Font.PLAIN, 16));
		colorButton.setBounds(70,130,64,26);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(blackWhiteButton);
		buttonGroup.add(colorButton);
		this.getContentPane().add(blackWhiteButton);
		this.getContentPane().add(colorButton);
		
		//ȷ����ť
		confirmButton = new JButton("ȷ��");
		confirmButton.setForeground(Color.WHITE);
		confirmButton.setBackground(Color.GRAY);
		confirmButton.setBorder(null);
		confirmButton.setFont(new Font("΢ܛ�����w", Font.PLAIN, 16));
		confirmButton.setBounds(247, 131, 76, 23);
		confirmButton.setEnabled(false);
		confirmButton.addActionListener(buttonListener);
		getContentPane().add(confirmButton);
	}
	
	//�������ñ�����ɫ����ʾ�ɼ�ǰ�Ļ��ᵼ�°ױߣ�ͬʱ����Ĭ��Ƥ���� �����Լ�дһ��setVisible
	public void mySetVisible(boolean status)
	{
		this.setVisible(status);
		this.getContentPane().setBackground(Color.DARK_GRAY);
	}
	
	//�����ڲ��� ������
	private class ButtonListener implements ActionListener,DocumentListener
	{
		
		int width=0;
		int height=0;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String command = arg0.getActionCommand();
			if("ȷ��".equals(command))
			{
				Main.boardPanel = new BoardPanel(width,height);
				//�����һ�λ������ʷ
				Repaint.repaintList.clear();
				//������ת�Ƶ�������
				Main.boardPanel.requestFocus();
				System.out.print("ȷ������");
				Main.newBoardWindow.mySetVisible(false);
			}
		}

		//update�ƺ���ʧЧ ���ǲ�֪����Ϊʲô
		@Override
		public void changedUpdate(DocumentEvent e) 
		{
			
		}

		@Override
		public void insertUpdate(DocumentEvent e) 
		{
			//�������������Ƿ�Ϸ� �Ϸ��Ļ��ͽ�confirmButton���ÿ��Ե���
			checkInputAndSetConfirmEnable(e);
		}

		@Override
		public void removeUpdate(DocumentEvent e) 
		{
			//�������������Ƿ�Ϸ� �Ϸ��Ļ��ͽ�confirmButton���ÿ��Ե���
			checkInputAndSetConfirmEnable(e);
		}
		
		//�������������Ƿ�Ϸ� �Ϸ��Ļ��ͽ�confirmButton���ÿ��Ե���
		private void checkInputAndSetConfirmEnable(DocumentEvent e)
		{
			Document doc = e.getDocument();
			String text = null;
			int length=0;
			//��ȡ��ǰ����������
            try
            {
           	 	text = doc.getText(0, doc.getLength());
           	 	length = Integer.parseInt(text);
            }
            catch (BadLocationException ex)
            {
                //ex.printStackTrace();
            }
            catch(RuntimeException runtimeException)
            {
       		 	//runtimeException.printStackTrace();
            }
            //����ͨ��document�Ƿ���ͬ���б���������һ��field
            if(e.getDocument().equals(widthTextField.getDocument()))
            {
           	 	width=length;
            }
            else if(e.getDocument().equals(heightTextField.getDocument()))
            {
           	 	height=length;
            }
            //�����Ϳ�����붼����Ҫ���ʱ����ȷ�����԰���
            if(height!=0&&width!=0)
            {
           	 	confirmButton.setEnabled(true);
            }
            else
            {
           	 	confirmButton.setEnabled(false);
            }
		}
		
	}
	
}
