package DVD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class DVDPanel extends JPanel implements ActionListener {
    private Random rand = new Random();
    private int x = rand.nextInt(350);
    private int y = rand.nextInt(350);
    private Timer timer = new Timer(10, this);
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        Image image = new ImageIcon("D:\\java developer\\GUI tasks\\src\\DVD\\dvd_video.png").getImage();
        setBackground(Color.BLACK);
        g2d.drawImage(image, x, y, null);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        if(x == 350 && y > 0 ){
            x--;
            y++;
        }else if(y == 350 || y > 0 || x == 0){
            x++;
            y--;
        }
    }
}
