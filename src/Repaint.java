import java.util.LinkedList;


import java.awt.*;

public class Repaint {

    //用于保存所有需要repaint的图形,注意新建画板要把原来的图形清空
    public static LinkedList<Repaint> repaintList = new LinkedList<Repaint>();

    //图形的类别定义
    public static enum GraphtType {pencil, line, brush, cycle_fill, cycle_wire, rect_fill, rect_wire, rect_rc_wire, rect_rc_fill, eraser}

    //图形的坐标信息 由于铅笔和橡皮等连续画图使用
    public static class Position
    {
        int x;
        int y;
        public Position(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }

    //图形的信息
    private GraphtType graphtType;
    private int x_past,y_past;
    private int x_current,y_current;
    private Color color;
    private int stroke;
    private int rc_vertical,rc_horizontal;
    @SuppressWarnings("unused")
    private String imagePath;//画图重绘使用
    @SuppressWarnings("unused")
	private String imageName;//画图重绘使用
    public LinkedList<Position> positionList;

    //非圆角类构造
    public Repaint(GraphtType graphtType,int x_past,int y_past,int x_current,int y_current,Color color,int stroke)
    {
        this.graphtType=graphtType;
        this.x_past=x_past;
        this.y_past=y_past;
        this.x_current=x_current;
        this.y_current=y_current;
        this.color=color;
        this.stroke=stroke;
    }
    //圆角类构造
    public Repaint(GraphtType graphtType,int x_past,int y_past,int x_current,int y_current,Color color,int stroke,int rc_vertical,int rc_horizontal)
    {
        this(graphtType,x_past,y_past,x_current,y_current,color,stroke);
        this.rc_vertical=rc_vertical;
        this.rc_horizontal=rc_horizontal;
    }
    //插入图片重绘构造
    public Repaint(GraphtType graphtType,int x_past,int y_past,String imagePath,String imageaName)
    {
        this(graphtType,x_past,y_past,0,0,Color.BLACK,0);
        this.imagePath=imagePath;
        this.imageName=imageaName;
    }
    //铅笔橡皮类构造
    public Repaint(GraphtType graphtType,Color color,int stroke)
    {
        this.graphtType=graphtType;
        this.color=color;
        this.stroke=stroke;
    }


    //重绘
    public static void repainGraph(Graphics2D graphics)
    {
        for(Repaint repaint : repaintList)
        {
            graphics.setStroke(new BasicStroke(repaint.stroke));
            graphics.setColor(repaint.color);
            switch (repaint.graphtType) {
                case line:
                    graphics.drawLine(repaint.x_past, repaint.y_past, repaint.x_current, repaint.y_current);
                    break;
                case rect_wire:
                    graphics.drawRect(repaint.x_past, repaint.y_past, repaint.x_current, repaint.y_current);
                    break;
                case rect_fill:
                    graphics.fillRect(repaint.x_past, repaint.y_past, repaint.x_current, repaint.y_current);
                    break;
                case rect_rc_wire:
                    graphics.drawRoundRect(repaint.x_past, repaint.y_past, repaint.x_current, repaint.y_current,repaint.rc_horizontal, repaint.rc_vertical);
                    break;
                case rect_rc_fill:
                    graphics.fillRoundRect(repaint.x_past, repaint.y_past, repaint.x_current, repaint.y_current, repaint.rc_horizontal, repaint.rc_vertical);
                    break;
                case cycle_wire :
                    graphics.drawOval(repaint.x_past, repaint.y_past, repaint.x_current, repaint.y_current);
                    break;
                case cycle_fill :
                    graphics.fillOval(repaint.x_past, repaint.y_past, repaint.x_current, repaint.y_current);
                    break;
                case pencil :
                    for (int i = 0; i < repaint.positionList.size()-1; i++) 
                    {
                        graphics.drawLine(repaint.positionList.get(i).x, repaint.positionList.get(i).y, repaint.positionList.get(i+1).x, repaint.positionList.get(i+1).y);
                    }
                    break;
                case eraser :
                    for (int i = 0; i < repaint.positionList.size()-1; i++) 
                    {
                        graphics.drawLine(repaint.positionList.get(i).x, repaint.positionList.get(i).y, repaint.positionList.get(i+1).x, repaint.positionList.get(i+1).y);
                    }
                    break;
                default:
                    break;
            }
        }
    }

}
