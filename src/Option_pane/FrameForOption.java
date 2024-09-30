package Option_pane;

import javax.swing.*;
import java.awt.*;

public class FrameForOption extends JFrame {
    FrameForOption(){
        super("Option pane");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(screen.width/2-400, screen.height/2-200, 800, 400);
        Container container = getContentPane();
        PaneFromButton pane = new PaneFromButton();
        container.add(pane);
        addKeyListener(pane);
        setVisible(true);
    }

}
