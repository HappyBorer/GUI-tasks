package DVD;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class DVDPanel extends JPanel{

    private int x =(int) (Math.random() * 350);
    private int y =(int) (Math.random() * 350);
//    private Timer timer = new Timer(10, this);
    private boolean flagX, flagY;
    private BufferedImage dvd;

    public DVDPanel(){
        try {
            dvd = ImageIO.read(new File("F:\\курс разработчик\\курс java\\GUI-tasks\\src\\DVD\\dvd-video.png"));
        } catch (Exception ex){
            ex.printStackTrace();
        }
//        dvd = new BufferedImage(dvd.getWidth(), dvd.getHeight(),
//                BufferedImage.TYPE_INT_ARGB);
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
//        for (int i = 0; i < dvd.getHeight(); i++) {
//            for (int j = 0; j < dvd.getWidth(); j++) {
//
//                dvd.setRGB(x, y, new Color(255, 0 ,0, 200).getRGB());
//            }
//        }

        g2d.drawImage(dvd, x, y, 150, 70, this);

//        setBackground(Color.BLACK);

//        timer.start();
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        repaint();
//        if(x == 337 && y >= 0){
//            flagX = false;
//        }else if(y == 397 && x >= 0){
//            flagY = false;
//        }else if(x == 0 && y < 397){
//            flagX = true;
//        } else if (y == 0 && x < 337) {
//            flagY = true;
//        }
//
//        if(flagX && flagY){
//            x++;
//            y++;
//
//        }else if(flagX){
//            x++;
//            y--;
//
//        }else if (flagY){
//            x--;
//            y++;
//
//        }else {
//            x--;
//            y--;
//
//        }
//    }
}
