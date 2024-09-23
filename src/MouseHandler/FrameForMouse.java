package MouseHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class FrameForMouse extends JFrame implements MouseListener {
    private MyString lab;
    private int x = 0, y = 0, b = 0;
    private boolean isDelete;
    protected ArrayList<MyString> obj;

    FrameForMouse() {
        super("Mouse handler");
        obj = new ArrayList<>();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(dimension.width / 2 - 400, dimension.height / 2 - 300, 800, 600);
        addMouseListener(this);
        revalidate();
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D d2 = (Graphics2D) g;
        for (int i=0; i < obj.size(); i++) {
            d2.drawString(obj.get(i).getStr(), obj.get(i).getX(), obj.get(i).getY());
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        b = e.getButton();
        if (b == 1) {
            lab = new MyString("x:" + x + " y:" + y, x, y);
            obj.add(lab);
            repaint();
        }
        if (b == 2) {

            if(!obj.isEmpty()) {
                for (int i = 0; i < obj.size(); i++) {
                    if(obj.get(i).getX() <= x && obj.get(i).getMaxX() >= x
                            && obj.get(i).getY() >= y && obj.get(i).getMaxY() <= y){
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


    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    protected class MyString {
        String str;
        int x, y, maxX, maxY;
        MyString(String str, int x, int y){
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
        public int getMaxX(){
            return maxX;
        }
        public int getMaxY(){
            return maxY;
        }
    }
}
