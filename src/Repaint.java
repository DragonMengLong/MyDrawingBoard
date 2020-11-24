import java.util.LinkedList;
import java.awt.*;

public class Repaint {
    //用于保存所有需要repaint的图形,注意新建画板要把原来的图形清空
    public static LinkedList<Repaint> repaintList = new LinkedList<Repaint>();
    //图形的类别定义
    public enum GraphtType {pencil, line, brush, cycle_fill, cycle_wire, rect_fill, rect_wire, rect_rc_wire, rect_rc_fill, eraser}
    //图形的信息
    private GraphtType graphtType;
    private int x,y;
    private int width,height;
    private Color color;
    private int stroke;

    public Repaint(GraphtType graphtType,int x,int y,int width,int heigh,Color color,int stroke)
    {
        this.graphtType=graphtType;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.color=color;
        this.stroke=stroke;
    }

    //重绘
    public static void repainGraph(Graphics2D graphics)
    {
        for(Repaint repaint : repaintList)
        {
            switch (repaint.graphtType) {
                case line:
                    graphics.setStroke(new BasicStroke(repaint.stroke));
                    graphics.setColor(repaint.color);
                    graphics.drawLine(repaint.x, repaint.y, repaint.width, repaint.height);
                    break;
            
                default:
                    break;
            }
        }
    }

}
