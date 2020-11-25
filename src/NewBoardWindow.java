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
		
		//建立监听器
		ButtonListener buttonListener = new ButtonListener();
		
		getContentPane().setBackground(Color.DARK_GRAY);
		this.setTitle("创建新的画板");
		this.setLocationRelativeTo(Main.mainWindow);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(400,200);
		
		//固定窗口大小 绝对排版
		this.setResizable(false);
		this.getContentPane().setLayout(null);
		
		//画板的宽JLabel
		JLabel widthLabel = new JLabel("画板的宽为：");
		widthLabel.setBounds(81,21,120,40);
		widthLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		widthLabel.setForeground(Color.WHITE);
		this.getContentPane().add(widthLabel);
		
		//画板的高JLabel
		JLabel heightLabel = new JLabel("画板的高为：");
		heightLabel.setBounds(81,71,120,40);
		heightLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		heightLabel.setForeground(Color.WHITE);
		this.getContentPane().add(heightLabel);
		
		//画板的宽输入
		widthTextField = new JTextField(4);
		widthTextField.setForeground(Color.WHITE);
		widthTextField.setBackground(Color.GRAY);
		widthTextField.setBounds(211,30,84,26);
		widthTextField.addActionListener(buttonListener);
		widthTextField.getDocument().addDocumentListener(buttonListener);
		this.getContentPane().add(widthTextField);
		
		//画板的高输入
		heightTextField = new JTextField(4);
		heightTextField.setForeground(Color.WHITE);
		heightTextField.setBackground(Color.GRAY);
		heightTextField.setBounds(211, 80, 84, 26);
		heightTextField.addActionListener(buttonListener);
		heightTextField.getDocument().addDocumentListener(buttonListener);
		getContentPane().add(heightTextField);
		
		//色彩模式按钮
		JRadioButton blackWhiteButton = new JRadioButton("黑白");
		blackWhiteButton.setForeground(Color.WHITE);
		blackWhiteButton.setBackground(Color.DARK_GRAY);
		blackWhiteButton.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		blackWhiteButton.setBounds(162,130,63,26);
		JRadioButton colorButton = new JRadioButton("彩色",true);
		colorButton.setForeground(Color.WHITE);
		colorButton.setBackground(Color.DARK_GRAY);
		colorButton.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		colorButton.setBounds(70,130,64,26);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(blackWhiteButton);
		buttonGroup.add(colorButton);
		this.getContentPane().add(blackWhiteButton);
		this.getContentPane().add(colorButton);
		
		//确定按钮
		confirmButton = new JButton("确定");
		confirmButton.setForeground(Color.WHITE);
		confirmButton.setBackground(Color.GRAY);
		confirmButton.setBorder(null);
		confirmButton.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		confirmButton.setBounds(247, 131, 76, 23);
		confirmButton.setEnabled(false);
		confirmButton.addActionListener(buttonListener);
		getContentPane().add(confirmButton);
	}
	
	//由于设置背景颜色在显示可见前的话会导致白边，同时考虑默认皮肤， 所以自己写一个setVisible
	public void mySetVisible(boolean status)
	{
		this.setVisible(status);
		this.getContentPane().setBackground(Color.DARK_GRAY);
	}
	
	//设置内部类 监听器
	private class ButtonListener implements ActionListener,DocumentListener
	{
		
		int width=0;
		int height=0;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String command = arg0.getActionCommand();
			if("确定".equals(command))
			{
				Main.boardPanel = new BoardPanel(width,height);
				//清空上一次画板的历史
				Repaint.repaintList.clear();
				//将焦点转移到画板下
				Main.boardPanel.requestFocus();
				System.out.print("确定按下");
				Main.newBoardWindow.mySetVisible(false);
			}
		}

		//update似乎会失效 但是不知道是为什么
		@Override
		public void changedUpdate(DocumentEvent e) 
		{
			
		}

		@Override
		public void insertUpdate(DocumentEvent e) 
		{
			//检查输入的内容是否合法 合法的话就将confirmButton设置可以点下
			checkInputAndSetConfirmEnable(e);
		}

		@Override
		public void removeUpdate(DocumentEvent e) 
		{
			//检查输入的内容是否合法 合法的话就将confirmButton设置可以点下
			checkInputAndSetConfirmEnable(e);
		}
		
		//检查输入的内容是否合法 合法的话就将confirmButton设置可以点下
		private void checkInputAndSetConfirmEnable(DocumentEvent e)
		{
			Document doc = e.getDocument();
			String text = null;
			int length=0;
			//获取当前的输入内容
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
            //可以通过document是否相同来判别在来做哪一个field
            if(e.getDocument().equals(widthTextField.getDocument()))
            {
           	 	width=length;
            }
            else if(e.getDocument().equals(heightTextField.getDocument()))
            {
           	 	height=length;
            }
            //当长和宽的输入都符合要求的时候让确定可以按下
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
