package DVD;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DVDPanel extends JPanel implements ActionListener {

    private int x =(int) (Math.random() * 350);
    private int y =(int) (Math.random() * 350);
    private Timer timer = new Timer(10, this);
    private boolean flagX, flagY;
    private BufferedImage dvd;




    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        try {
            dvd = ImageIO.read(new File("D:\\java developer\\GUI tasks\\src\\DVD\\dvd-video.png"));
        } catch (Exception ex){
            ex.printStackTrace();
        }
        setBackground(Color.BLACK);
        g2d.drawImage(dvd, x, y, 150, 70, null);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        if(x == 337 && y >= 0){
            flagX = false;
        }else if(y == 397 && x >= 0){
            flagY = false;
        }else if(x == 0 && y < 397){
            flagX = true;
        } else if (y == 0 && x < 337) {
            flagY = true;
        }

        if(flagX && flagY){
            x++;
            y++;
            dvd.setRGB(150, 70, 255);
        }else if(flagX){
            x++;
            y--;
            dvd.setRGB(150, 70, 100);
        }else if (flagY){
            x--;
            y++;
            dvd.setRGB(150, 70, 150);
        }else {
            x--;
            y--;
            dvd.setRGB(150, 70, 222);
        }
    }
}
