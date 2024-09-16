package Movement_of_arrows;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MovementOfArrows extends JPanel implements KeyListener {
    private int x = 0, y = 0;
    private BufferedImage img;
    private int speed = 50;

    MovementOfArrows() {

        try {
            img = ImageIO.read(new File("D:\\java developer\\GUI tasks\\src\\Movement_of_arrows\\smil.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(img, x, y, 50, 50, this);
        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.isShiftDown()){
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (x > 0 && x != speed) {
                    x -= speed*2;
                } else if(x == speed){
                    x = 750;
                } else {
                    x = 750 - speed;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (x < 750 && x != (750 - speed)) {
                    x += speed*2;
                } else if(x == (750 - speed)){
                    x = 0;
                }else {
                    x = speed;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                if (y > 0 && y != speed) {
                    y -= speed*2;
                } else if(y == speed){
                    y = 550;
                }else {
                    y = 550 - speed;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (y < 550 && y != (550 - speed)) {
                    y += speed*2;
                } else if(y == (550 - speed)){
                    y = 0;
                }else {
                    y = speed;
                }
            }
        }else{
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (x > 0) {
                    x -= speed;
                } else {
                    x = 750;
                }

            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (x < 750) {
                    x += speed;
                } else {
                    x = 0;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                if (y > 0) {
                    y -= speed;
                } else {
                    y = 550;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (y < 550) {
                    y += speed;
                } else {
                    y = 0;
                }
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {


    }
}
