
import java.awt.event.*;



public class ManuButtonListener implements ActionListener, MouseListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command)
        {
            case "新建(N)":
                Main.newBoardWindow.mySetVisible(true);
                break;
            default:
                break;
        }
    }

    @Override
    //JmenuItem 下的mouseClicked失效
    public void mouseClicked(MouseEvent e) {
        

    }

    @Override
    public void mousePressed(MouseEvent e) {
       //System.out.print("fuck");

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.print("fuck");

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //System.out.print("fuck");

    }

    @Override
    public void mouseExited(MouseEvent e) {
        //System.out.print("fuck");

    }

    
    
}