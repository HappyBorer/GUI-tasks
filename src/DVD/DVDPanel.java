package DVD;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

public class DVDPanel extends JPanel implements ActionListener {

    private int x = (int) (Math.random() * 350);
    private int y = (int) (Math.random() * 350);
    private Timer timer = new Timer(10, this);
    private boolean flagX, flagY;
    private BufferedImage dvd;

    public DVDPanel() {

        try {
            FileInputStream fis = new FileInputStream(new File("D:\\java developer\\GUI tasks\\src\\DVD\\dvd-video.png"));
            dvd = ImageIO.read(fis);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        MyColor(Color.ORANGE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(dvd, x, y, 150, 70, null);

        setBackground(Color.BLACK);

        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        if(x == 337 && y >= 0){
            flagX = false;
            MyColor(Color.BLUE);

        }else if(y == 397 && x >= 0){
            flagY = false;
            MyColor(Color.GREEN);

        }else if(x == 0 && y < 397){
            flagX = true;
            MyColor(Color.CYAN);

        } else if (y == 0 && x < 337) {
            flagY = true;
            MyColor(Color.ORANGE);

        }

        if(flagX && flagY){
            x++;
            y++;

        }else if(flagX){
            x++;
            y--;

        }else if (flagY){
            x--;
            y++;

        }else {
            x--;
            y--;

        }
    }
    private void MyColor(Color color){
        for (int i = 0; i < dvd.getWidth(); i++) {
            for (int j = 0; j < dvd.getHeight(); j++) {
                int rgb = dvd.getRGB(i,j);
                if(rgb != -65281 && rgb != 0) {
                    dvd.setRGB(i, j, color.getRGB());
                }
            }
        }
    }
}
