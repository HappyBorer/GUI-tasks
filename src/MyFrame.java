import DVD.DVDPanel;
import Earth.EarthAndSun;
import Movement_along_the_contour.RoundPanel;
import Race.Race;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame(){
        super("MyGUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
//        RoundPanel panel = new RoundPanel();
//        DVDPanel panel = new DVDPanel(); // Лейбл DVD
//        EarthAndSun panel = new EarthAndSun(); // Земля и солнце
        Race panel = new Race();
        Container container = getContentPane();
        container.add(panel);
        setBounds( 300, 70, 500, 500);
        setVisible(true);
    }
}
