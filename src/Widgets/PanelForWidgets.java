package Widgets;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static java.awt.Font.ITALIC;

public class PanelForWidgets extends JPanel {
    private int size;
    private JSlider slider = new JSlider(5, 100);
    private JLabel label = new JLabel("Моя первая надпись!", JLabel.CENTER);
    int count = 0;
    private JLabel click = new JLabel("Click = " + count);
    private JButton button = new JButton("click me");
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

        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                int but = e.getButton();
                if (but == 1){
                    count++;
                    click.setText("Click = " + count);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        add(click);
        add(button);
        add(slider);
        add(label);


    }


}
