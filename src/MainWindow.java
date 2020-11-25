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
		
		//基础设置
        this.setSize(600,600);
        this.setBackground(Color.BLACK);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //创建菜单
        JMenuBar mainManuBar = new JMenuBar();
        //File菜单
        JMenu fileMenu = new JMenu("文件(F)");
        fileMenu.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
        fileMenu.setMnemonic(KeyEvent.VK_F);
                
        //新建文件
        JMenuItem menuItem = new JMenuItem("新建(N)",KeyEvent.VK_N);
        menuItem.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
        //菜单快捷方式
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        //添加菜单按钮监听器
        ManuButtonListener buttonListener = new ManuButtonListener();
        menuItem.addMouseListener(buttonListener);
        menuItem.addActionListener(buttonListener);
        fileMenu.add(menuItem);
        //打开文件
        menuItem = new JMenuItem("打开(O)",KeyEvent.VK_O);
        menuItem.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        menuItem.addMouseListener(buttonListener);
        menuItem.addActionListener(buttonListener);
        fileMenu.add(menuItem);
        //保存文件
        menuItem = new JMenuItem("保存(S)",KeyEvent.VK_S);
        menuItem.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        menuItem.addMouseListener(buttonListener);
        menuItem.addActionListener(buttonListener);
        fileMenu.add(menuItem);
        //另存为
        menuItem = new JMenuItem("另存为(A)",KeyEvent.VK_A);
        menuItem.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        menuItem.addMouseListener(buttonListener);
        menuItem.addActionListener(buttonListener);
        fileMenu.add(menuItem);
        //关于
        menuItem = new JMenuItem("关于(T)",KeyEvent.VK_T);
        menuItem.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
        menuItem.addMouseListener(buttonListener);
        menuItem.addActionListener(buttonListener);
        fileMenu.add(menuItem);
        //退出
        menuItem = new JMenuItem("退出(E)",KeyEvent.VK_E);
        menuItem.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        menuItem.addMouseListener(buttonListener);
        menuItem.addActionListener(buttonListener);
        fileMenu.add(menuItem);

        mainManuBar.add(fileMenu);
        mainManuBar.setBackground(Color.LIGHT_GRAY);
        fileMenu.addActionListener(buttonListener);
        //菜单设置颜色失效fileMenu.setBackground(Color.BLUE);
        this.setJMenuBar(mainManuBar);

        //添加工具栏
        this.getContentPane().setLayout(new BorderLayout(0,0));
        this.getContentPane().add(toolPanel,BorderLayout.NORTH);
        
        //setSize 需要在setLocationRelativeTo之前 setBackground 需要在setVisible之后
        this.setVisible(true);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        
        //添加画板的底板
        boardBackPanel = new JPanel();
        boardBackPanel.setBackground(Color.DARK_GRAY);
        boardBackPanel.setLayout(null);
        this.getContentPane().add(boardBackPanel,BorderLayout.CENTER);
        
	}
}
