package MouseHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FrameForMouse extends JFrame implements MouseListener {
    private String lab = "";
    private int x = 0, y = 0;
    FrameForMouse(){
        super("Mouse handler");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(dimension.width/2 - 400, dimension.height/2 - 300, 800, 600);
        addMouseListener(this);
        setVisible(true);
    }

    public void paint(Graphics g){
        Graphics2D d2 = (Graphics2D) g;
        d2.drawString(lab, x, y);
        repaint();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        lab = "x:" + e.getX() + " y:" + e.getY();
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
}
