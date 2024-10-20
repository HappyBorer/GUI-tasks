package Widgets;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelForJSpinner extends JPanel {
    private JSpinner spinner;
    private JButton button;
    private JLabel label;
    PanelForJSpinner(){
        spinner = new JSpinner(new SpinnerNumberModel(1,1,20,1));
        add(spinner);
        button = new JButton("Answer");
        add(button);
        label = new JLabel("Answer: ");
        add(label);
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
