import DVD.DVDPanel;
import Earth.EarthAndSun;
import Movement_along_the_contour.RoundPanel;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame(){
        super("MyGUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
//        RoundPanel panel = new RoundPanel();
//        DVDPanel panel = new DVDPanel(); // Лейбл DVD
        EarthAndSun panel = new EarthAndSun(); // Земля и солнце
        Container container = getContentPane();
        container.add(panel);
        setBounds( 300, 70, 700, 700);
        setVisible(true);
    }
}
