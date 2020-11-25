import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;


public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private ToolPanel toolPanel;
	
	public JPanel boardBackPanel;

	public MainWindow() {
		
		toolPanel = new ToolPanel();
		
		//��������
        this.setSize(600,600);
        this.setBackground(Color.BLACK);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //�����˵�
        JMenuBar mainManuBar = new JMenuBar();
        //File�˵�
        JMenu fileMenu = new JMenu("�ļ�(F)");
        fileMenu.setFont(new Font("΢ܛ�����w", Font.PLAIN, 12));
        fileMenu.setMnemonic(KeyEvent.VK_F);
                
        //�½��ļ�
        JMenuItem menuItem = new JMenuItem("�½�(N)",KeyEvent.VK_N);
        menuItem.setFont(new Font("΢ܛ�����w", Font.PLAIN, 12));
        //�˵���ݷ�ʽ
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        //��Ӳ˵���ť������
        ManuButtonListener buttonListener = new ManuButtonListener();
        menuItem.addMouseListener(buttonListener);
        menuItem.addActionListener(buttonListener);
        fileMenu.add(menuItem);
        //���ļ�
        menuItem = new JMenuItem("��(O)",KeyEvent.VK_O);
        menuItem.setFont(new Font("΢ܛ�����w", Font.PLAIN, 12));
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        menuItem.addMouseListener(buttonListener);
        menuItem.addActionListener(buttonListener);
        fileMenu.add(menuItem);
        //�����ļ�
        menuItem = new JMenuItem("����(S)",KeyEvent.VK_S);
        menuItem.setFont(new Font("΢ܛ�����w", Font.PLAIN, 12));
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        menuItem.addMouseListener(buttonListener);
        menuItem.addActionListener(buttonListener);
        fileMenu.add(menuItem);
        //���Ϊ
        menuItem = new JMenuItem("���Ϊ(A)",KeyEvent.VK_A);
        menuItem.setFont(new Font("΢ܛ�����w", Font.PLAIN, 12));
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        menuItem.addMouseListener(buttonListener);
        menuItem.addActionListener(buttonListener);
        fileMenu.add(menuItem);
        //����
        menuItem = new JMenuItem("����(T)",KeyEvent.VK_T);
        menuItem.setFont(new Font("΢ܛ�����w", Font.PLAIN, 12));
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
        menuItem.addMouseListener(buttonListener);
        menuItem.addActionListener(buttonListener);
        fileMenu.add(menuItem);
        //�˳�
        menuItem = new JMenuItem("�˳�(E)",KeyEvent.VK_E);
        menuItem.setFont(new Font("΢ܛ�����w", Font.PLAIN, 12));
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        menuItem.addMouseListener(buttonListener);
        menuItem.addActionListener(buttonListener);
        fileMenu.add(menuItem);

        mainManuBar.add(fileMenu);
        mainManuBar.setBackground(Color.LIGHT_GRAY);
        fileMenu.addActionListener(buttonListener);
        //�˵�������ɫʧЧfileMenu.setBackground(Color.BLUE);
        this.setJMenuBar(mainManuBar);

        //��ӹ�����
        this.getContentPane().setLayout(new BorderLayout(0,0));
        this.getContentPane().add(toolPanel,BorderLayout.NORTH);
        
        //setSize ��Ҫ��setLocationRelativeTo֮ǰ setBackground ��Ҫ��setVisible֮��
        this.setVisible(true);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        
        //��ӻ���ĵװ�
        boardBackPanel = new JPanel();
        boardBackPanel.setBackground(Color.DARK_GRAY);
        boardBackPanel.setLayout(null);
        this.getContentPane().add(boardBackPanel,BorderLayout.CENTER);
        
	}
}
