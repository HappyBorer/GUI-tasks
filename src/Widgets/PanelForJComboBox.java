package Widgets;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelForJComboBox extends JPanel {
    private String[] colors = {"Red", "Green", "Blue"};
    private JComboBox<String> comboBox;
    private JCheckBox checkBox;
    private JTextField textField;
    private JLabel label;
    private JButton button;
    PanelForJComboBox(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        comboBox = new JComboBox<>(colors);
        add(comboBox);
        checkBox = new JCheckBox("My option", false);
        checkBox.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(checkBox);
        textField = new JTextField("Placeholder");
        textField.setEnabled(false);
        checkBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(checkBox.isSelected()) {
                    textField.setEnabled(true);
                    comboBox.setEnabled(false);
                }else{
                    textField.setEnabled(false);
                    comboBox.setEnabled(true);
                }
            }
        });
        textField.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(textField);
        button = new JButton("Answer");
        button.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(button);
        label = new JLabel("You answer: ");
        label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(label);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String getString;
                if(checkBox.isSelected()){
                    getString = textField.getText();
                }else{
                    getString = (String) comboBox.getSelectedItem();
                }
                label.setText("You answer: " + getString);
            }
        });
        comboBox.setMaximumSize(new Dimension(150, 30));
        checkBox.setMaximumSize(new Dimension(150, 30));
        textField.setMaximumSize(new Dimension(150, 30));
        button.setMaximumSize(new Dimension(150, 30));
        label.setMaximumSize(new Dimension(150, 30));
        validate();
    }
}
