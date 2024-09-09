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

    MovementOfArrows() {

        try {
            img = ImageIO.read(new File("F:\\курс разработчик\\курс java\\GUI-tasks\\src\\Movement_of_arrows\\smil.png"));
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
        if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
            if(x > 0) {
                x -= 50;
            }else{
                x = 750;
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(x < 750) {
                x += 50;
            }else{
                x = 0;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if( y > 0) {
                y -= 50;
            }else{
                y = 550;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            if(y < 550) {
                y += 50;
            }else{
                y = 0;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {


    }
}
