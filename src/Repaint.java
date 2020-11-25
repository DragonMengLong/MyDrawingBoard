import java.util.LinkedList;

import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import java.awt.*;

public class Repaint {
    //���ڱ���������Ҫrepaint��ͼ��,ע���½�����Ҫ��ԭ����ͼ�����
    public static LinkedList<Repaint> repaintList = new LinkedList<Repaint>();
    //ͼ�ε������
    public enum GraphtType {pencil, line, brush, cycle_fill, cycle_wire, rect_fill, rect_wire, rect_rc_wire, rect_rc_fill, eraser}
    //ͼ�ε���Ϣ
    private GraphtType graphtType;
    private int x,y;
    private int width,height;
    private Color color;
    private int stroke;
    private int rc_vertical=0,rc_horizontal=0;
    private String imagePath;

    //��Բ���๹��
    public Repaint(GraphtType graphtType,int x,int y,int width,int height,Color color,int stroke)
    {
        this.graphtType=graphtType;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.color=color;
        this.stroke=stroke;
    }
    //Բ���๹��
    public Repaint(GraphtType graphtType,int x,int y,int width,int height,Color color,int stroke,int rc_vertical,int rc_horizontal)
    {
        this(graphtType,x,y,width,height,color,stroke);
        this.rc_vertical=rc_vertical;
        this.rc_horizontal=rc_horizontal;
    }
    //����ͼƬ�ػ湹��
    public Repaint(GraphtType graphtType,int x,int y,int width,int height,Color color,int stroke,String imagePath)
    {
        this(graphtType,x,y,width,height,color,stroke);
        this.imagePath=imagePath;
    }


    //�ػ�
    public static void repainGraph(Graphics2D graphics)
    {
        for(Repaint repaint : repaintList)
        {
            graphics.setStroke(new BasicStroke(repaint.stroke));
            graphics.setColor(repaint.color);
            switch (repaint.graphtType) {
                case line:
                    graphics.drawLine(repaint.x, repaint.y, repaint.width, repaint.height);
                    break;
                case rect_wire:
                    graphics.drawRect(repaint.x, repaint.y, repaint.width, repaint.height);
                    break;
                case rect_fill:
                    graphics.fillRect(repaint.x, repaint.y, repaint.width, repaint.height);
                    break;
                case rect_rc_wire:
                    graphics.drawRoundRect(repaint.x, repaint.y, repaint.width, repaint.height,repaint.rc_horizontal, repaint.rc_vertical);
                    break;
                case rect_rc_fill:
                    graphics.fillRoundRect(repaint.x, repaint.y, repaint.width, repaint.height, repaint.rc_horizontal, repaint.rc_vertical);
                    break;
                case cycle_wire :
                    graphics.drawOval(repaint.x, repaint.y, repaint.width, repaint.height);
                    break;
                case cycle_fill :
                    graphics.fillOval(repaint.x, repaint.y, repaint.width, repaint.height);
                    break;
                
                
                default:
                    break;
            }
        }
    }

}
