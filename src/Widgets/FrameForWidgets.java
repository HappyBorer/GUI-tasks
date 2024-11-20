package Widgets;

import javax.swing.*;
import java.awt.*;

public class FrameForWidgets extends JFrame {
    private int width = 800, height = 600;
    FrameForWidgets(){
        super("Widgets");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(screen.width/2 - width/2, screen.height/2 - height/2, width, height);
//        PanelForWidgets panel = new PanelForWidgets();
//        PanelForJSpinner panel = new PanelForJSpinner();// панель с JSpinner
//        PanelForJComboBox panel = new PanelForJComboBox(); // панель с JComboBox
//        PanelForJRadioButton panel = new PanelForJRadioButton(); // панель с JRadioButton
//        PanelForJTextArea panel = new PanelForJTextArea(); // панель с JTextArea
//        PanelForCalculator panel = new PanelForCalculator(); // панель с Calculator
        PanelForQuiz panel = new PanelForQuiz();
        Container container = getContentPane();
        container.add(panel);
        pack();
        revalidate();
        setVisible(true);
    }
}
