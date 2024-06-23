import Movement_along_the_contour.RoundPanel;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame(){
        super("MyGUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        RoundPanel panel = new RoundPanel();
        Container container = getContentPane();
        container.add(panel);
        setBounds( 500, 200, 500, 500);
        setVisible(true);
    }
}
