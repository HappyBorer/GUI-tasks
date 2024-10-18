package Widgets;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

import static java.awt.Font.ITALIC;

public class PanelForWidgets extends JPanel {
    private int size;
    JSlider slider = new JSlider(JSlider.VERTICAL ,5, 100, 5);
    JLabel label = new JLabel("Моя первая надпись!", JLabel.CENTER);
    PanelForWidgets(){
        size = slider.getValue();
        slider.setMajorTickSpacing(19);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        label.setFont(new Font("Serief", ITALIC, size));
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                size = ((JSlider)e.getSource()).getValue();
                label.setFont(new Font("Serief", ITALIC, size));
            }
        });
        add(slider);
        add(label);

    }


}
