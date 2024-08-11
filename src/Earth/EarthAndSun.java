package Earth;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class EarthAndSun extends JPanel implements ActionListener {
    private int xSun = 300;
    private int ySun = 300;
    private int x0 = 345;
    private int y0 = 345;
    private int[] radius;
    private int beginPlanet = 320;
    private int[][] sizePlanet;
    private int beginRadius = 50;
    private Timer time;
    private double[] t;
    private double[]speeds;
    private int[] x;
    private int[] y;
    private BufferedImage sun;
    private BufferedImage[] planets;
    public EarthAndSun(){
        planets = new BufferedImage[9];
        x = new int[9];
        y = new int[9];
        radius = new int[9];
        speeds = new double[]{0.45, 0.40, 0.35, 0.3, 0.25, 0.2, 0.15, 0.1, 0.05};
        t = new double[9];
        sizePlanet = new int[9][2];
        sizePlanet[0][0] = 10;
        sizePlanet[0][1] = 10;
        sizePlanet[1][0] = 20;
        sizePlanet[1][1] = 20;
        sizePlanet[2][0] = 25;
        sizePlanet[2][1] = 25;
        sizePlanet[3][0] = 17;
        sizePlanet[3][1] = 17;
        sizePlanet[4][0] = 30;
        sizePlanet[4][1] = 30;
        sizePlanet[5][0] = 30;
        sizePlanet[5][1] = 30;
        sizePlanet[6][0] = 30;
        sizePlanet[6][1] = 30;
        sizePlanet[7][0] = 20;
        sizePlanet[7][1] = 20;
        sizePlanet[8][0] = 15;
        sizePlanet[8][1] = 15;


        for(int i = 0; i < x.length;i++){
            beginPlanet -= (3 + sizePlanet[i][0]) ;
            x[i] = beginPlanet;
            y[i] = beginPlanet;
            beginRadius += (7 + sizePlanet[i][1]);
            radius[i] = beginRadius;
        }
        try{

            planets[2] = ImageIO.read(getImg("F:\\курс разработчик\\курс java\\GUI-tasks\\src\\Earth\\earth.png"));
            planets[0] = ImageIO.read(getImg("F:\\курс разработчик\\курс java\\GUI-tasks\\src\\Earth\\mercury.png"));
            planets[1] = ImageIO.read(getImg("F:\\курс разработчик\\курс java\\GUI-tasks\\src\\Earth\\venus.png"));
            planets[3] = ImageIO.read(getImg("F:\\курс разработчик\\курс java\\GUI-tasks\\src\\Earth\\mars.png"));
            planets[4] = ImageIO.read(getImg("F:\\курс разработчик\\курс java\\GUI-tasks\\src\\Earth\\jupiter.png"));
            planets[5] = ImageIO.read(getImg("F:\\курс разработчик\\курс java\\GUI-tasks\\src\\Earth\\saturn.png"));
            planets[6] = ImageIO.read(getImg("F:\\курс разработчик\\курс java\\GUI-tasks\\src\\Earth\\uranus.png"));
            planets[7] = ImageIO.read(getImg("F:\\курс разработчик\\курс java\\GUI-tasks\\src\\Earth\\neptune.png"));
            planets[8] = ImageIO.read(getImg("F:\\курс разработчик\\курс java\\GUI-tasks\\src\\Earth\\pluto.png"));
            sun = ImageIO.read(getImg("F:\\курс разработчик\\курс java\\GUI-tasks\\src\\Earth\\sun.png"));
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

        g2d.drawImage(sun, xSun, ySun, 100, 100, this);
        for(int i = 0; i < planets.length; i++) {
            g2d.drawImage(planets[i], x[i], y[i], sizePlanet[i][0], sizePlanet[i][1], this);
        }
        time.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < planets.length;i++) {
            double angle = t[i] * 2.0 * Math.PI / 360.;
            x[i] = x0 - (int) (radius[i] * Math.cos(angle));
            y[i] = y0 - (int) (radius[i] * Math.sin(angle));
            t[i] += speeds[i];
        }
        repaint();
    }

    private FileInputStream getImg(String path) throws FileNotFoundException {
        return new FileInputStream(new File(path));
    }
}
