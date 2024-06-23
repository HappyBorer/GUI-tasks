package Movement_along_the_contour;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoundPanel  extends JPanel implements ActionListener {
    private int x = -25;
    private int y = 0;

    private Timer timer = new Timer(10, this);
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        Image image = new ImageIcon("D:\\java developer\\GUI tasks\\src\\dog.png").getImage();
        g2d.drawImage(image, x, y, null);
        timer.start();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        if(x < 410 && y == 0){
            x++;
        }else if(x == 410 && y < 415){
            y++;
        }else if(x > -25 && y == 415){
            x--;
        }else if(x == -25 && y > 0){
            y--;
        }
    }
}
