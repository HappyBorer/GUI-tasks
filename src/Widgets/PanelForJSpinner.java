package Widgets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelForJSpinner extends JPanel {
    private JSpinner spinner;
    private JButton button;
    private JLabel label;
    PanelForJSpinner(){
        spinner = new JSpinner(new SpinnerNumberModel(1,1,20,1));
        button = new JButton("Answer");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        label = new JLabel("Answer: ");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        spinner.setMaximumSize(new Dimension(50, 25));
        button.setMaximumSize(new Dimension(100, 30));
        label.setMaximumSize(new Dimension(70, 30));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createVerticalStrut(20));
        add(spinner);
        add(Box.createVerticalStrut(20));
        add(button);
        add(Box.createVerticalStrut(20));
        add(label);
        add(Box.createVerticalStrut(20));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("");
                label.setText("Answer: " + (int)spinner.getValue());
            }
        });

        validate();
    }
}
