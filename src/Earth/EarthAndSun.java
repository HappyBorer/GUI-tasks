package Earth;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;



public class EarthAndSun extends JPanel implements ActionListener {
    private int xSun = 175;
    private int ySun = 175;
    private int x0 = 225;
    private int y0 = 225;
    private int radius = 150;


    private Timer time;
    private double t = 0;
    private int xEarth = 150;
    private int yEarth = 150;
    private BufferedImage sun, earth;
    public EarthAndSun(){
        try{
            FileInputStream img = new FileInputStream(new File("F:\\курс разработчик\\курс java\\GUI-tasks\\src\\Earth\\earth.png"));
            earth = ImageIO.read(img);
            img = new FileInputStream(new File("F:\\курс разработчик\\курс java\\GUI-tasks\\src\\Earth\\sun.png"));
            sun = ImageIO.read(img);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        time = new Timer(10, this);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        setBackground(Color.BLACK);

        g2d.drawImage(sun, xSun, ySun, 150, 150, this);
        g2d.drawImage(earth, xEarth,yEarth, 60,50, this);
        time.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double angle = t * 2.0 * Math.PI / 360.;
        xEarth = x0 - (int)(radius * Math.cos(angle));
        yEarth = y0 - (int)(radius * Math.sin(angle));
        t ++;
        repaint();
    }
}
