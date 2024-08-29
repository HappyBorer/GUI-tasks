package Race;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public class Race extends JPanel implements ActionListener {
    private BufferedImage[] cars;
    private Timer timer;
    private int sizeW = 80;
    private int sizeH = 60;
    private int[][] start;
    private Random r;
    private String str = "WIN ";
    boolean flag = true;
    public Race(){
        r = new Random();
        timer = new Timer(3000, this);
        cars = new BufferedImage[5];
        start = new int[9][2];
        try{
            cars[0] = ImageIO.read(getCar("F:\\курс разработчик\\курс java\\GUI-tasks\\src\\Race\\carOne.png"));
            cars[1] = ImageIO.read(getCar("F:\\курс разработчик\\курс java\\GUI-tasks\\src\\Race\\carTwo.png"));
            cars[2] = ImageIO.read(getCar("F:\\курс разработчик\\курс java\\GUI-tasks\\src\\Race\\carThree.png"));
            cars[3] = ImageIO.read(getCar("F:\\курс разработчик\\курс java\\GUI-tasks\\src\\Race\\carFour.png"));
            cars[4] = ImageIO.read(getCar("F:\\курс разработчик\\курс java\\GUI-tasks\\src\\Race\\carFive.png"));
        }catch(Exception ex){
            ex.printStackTrace();
        }

        for(int i = 1; i < start.length; i++){
            start[i][1] += start[i-1][1] + sizeH + 30;
        }
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        for(int i = 0; i < cars.length; i++){
            g2d.drawImage(cars[i], start[i][0], start[i][1], sizeW, sizeH, this);
        }

        if(flag) {
            timer.start();
            timer.setDelay(50);
        }else{
            g2d.drawString(str, 240, 220);
        }
    }
    private FileInputStream getCar(String path) throws FileNotFoundException {
        return new FileInputStream(new File(path));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();

        for(int i = 0; i < start.length; i++){
            int ran = r.nextInt(1,5);
            start[i][0] += ran;
            if(start[i][0] == 500 - sizeW - 15){
                flag = false;
            }
            if(!flag){
                str += (i+1);
                timer.stop();
                break;
            }
        }


    }
}
