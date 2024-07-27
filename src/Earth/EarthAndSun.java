package Earth;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;


public class EarthAndSun extends JPanel {
    private int xSun, ySun, xEarth, yEarth;
    private BufferedImage sun, earth;
    public EarthAndSun(){
        try{
            FileInputStream img = new FileInputStream(new File("D:\\java developer\\GUI tasks\\src\\Earth\\earth.png"));
            earth = ImageIO.read(img);
            img = new FileInputStream(new File("D:\\java developer\\GUI tasks\\src\\Earth\\sun.png"));
            sun = ImageIO.read(img);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        setBackground(Color.BLACK);
        g2d.drawImage(sun, 200, 200, 200, 200, this);
        g2d.drawImage(earth, 100,100, 120,100, this);
    }
}
