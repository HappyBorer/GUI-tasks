package Widgets;

import javax.swing.*;
import java.awt.*;

import static java.awt.Font.*;

public class FrameForWidgets extends JFrame {
    private int width = 800, height = 600;
    FrameForWidgets(){
        super("Widgets");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(screen.width/2 - width/2, screen.height/2 - height/2, width, height);
        JLabel label = new JLabel("Моя первая надпись!", JLabel.CENTER);
        label.setFont(new Font("Serief", ITALIC, 50));
        add(label);
        setVisible(true);
    }
}
