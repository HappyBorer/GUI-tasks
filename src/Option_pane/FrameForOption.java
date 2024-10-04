package Option_pane;

import javax.swing.*;
import java.awt.*;

public class FrameForOption extends JFrame {
    private int width;
    private int height;


    FrameForOption(int width, int height) {
        super("Option pane");
        this.width = width;
        this.height = height;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(screen.width / 2 - width / 2, screen.height / 2 - height / 2, width, height);
        Container container = getContentPane();
        PaneFromButton pane = new PaneFromButton();
        container.add(pane);
        addKeyListener(pane);
        revalidate();
        setVisible(true);

    }

}
