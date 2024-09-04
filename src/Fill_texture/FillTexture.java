package Fill_texture;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

public class FillTexture extends JPanel {
    private int offset = 50;
    private BufferedImage grass;

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        for(int i = 0; i < 12; i++) {
            for(int j = 0; j < 16; j++) {
                try {
                    grass = ImageIO.read(new FileInputStream("F:\\курс разработчик\\курс java\\GUI-tasks\\src\\Fill_texture\\grass.png"));
                    g2d.drawImage(grass, j * offset, i * offset, 50, 50, this);
                }catch (Exception ex){
                    ex.printStackTrace();
                }

            }
        }
        repaint();
    }


}
