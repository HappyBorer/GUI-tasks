package MouseHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class FrameForMouse extends JFrame implements MouseListener, MouseMotionListener {

    private int x = 0, y = 0, b = 0;
    private boolean isDrag;
    private MyString objDrag;
    private ArrayList<MyString> obj;


    FrameForMouse() {
        super("Mouse handler");
        obj = new ArrayList<>();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        isDrag = true;
        setDefaultLookAndFeelDecorated(true);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(dimension.width / 2 - 400, dimension.height / 2 - 300, 800, 600);
        addMouseListener(this);
        addMouseMotionListener(this);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        revalidate();
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        if(!obj.isEmpty()){
            for(int i = 0; i < obj.size(); i++){
                obj.get(i).draw(g);
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        b = e.getButton();
        if (b == 1) {
            obj.add( new MyString("x:" + x + " y:" + y, x, y));

            repaint();
        }
        if (b == 2) {

            if (!obj.isEmpty()) {
                for (int i = 0; i < obj.size(); i++) {
                    if (obj.get(i).getX() <= x && obj.get(i).getMaxX() >= x
                            && obj.get(i).getY() >= y && obj.get(i).getMaxY() <= y) {
                        obj.remove(i);

                        break;
                    }
                }
            }
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        b = e.getButton();
        if (b == 3) {
            if (!obj.isEmpty()) {
                for (int i = 0; i < obj.size() && !isDrag; i++) {
                    if (obj.get(i).getX() <= x && obj.get(i).getMaxX() >= x
                            && obj.get(i).getY() >= y && obj.get(i).getMaxY() <= y) {
                        objDrag = obj.get(i);
                        isDrag = true;
                    }
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isDrag = false;
        objDrag = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if (isDrag) {
            objDrag.setX(x);
            objDrag.setY(y);
            repaint();
        }
    }


    @Override
    public void mouseMoved(MouseEvent e) {

    }

    protected class MyString {
        String str;
        int x, y, maxX, maxY;

        MyString(String str, int x, int y) {
            this.str = str;
            this.x = x;
            this.y = y;
            maxX = this.x + str.length() * 10;
            maxY = this.y - 20;
        }


        public String getStr() {
            return str;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
            maxX = this.x + str.length() * 10;
        }
        public void draw(Graphics g){
            Graphics2D d2 = (Graphics2D)g;
            d2.drawString(str, x, y);
        }

        public void setY(int y) {
            this.y = y;
            maxY = this.y - 20;
        }

        public int getMaxX() {
            return maxX;
        }

        public int getMaxY() {
            return maxY;
        }
    }
}
