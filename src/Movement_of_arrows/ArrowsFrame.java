package Movement_of_arrows;

import javax.swing.*;
import java.awt.*;

public class ArrowsFrame extends JFrame {
    ArrowsFrame(){
        super("Movement of arrows");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        Container container = getContentPane();
        MovementOfArrows panel = new MovementOfArrows();
        container.add(panel);
        addKeyListener(panel);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setBounds(dimension.width/2 - 408, dimension.height/2 - 320, 816, 640);
        setVisible(true);
    }
}
