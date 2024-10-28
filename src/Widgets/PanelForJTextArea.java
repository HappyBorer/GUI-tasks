package Widgets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelForJTextArea extends JPanel {
    PanelForJTextArea(){
        // Layout for panel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // Objects
        JTextField textField = new JTextField(12);
        JButton button = new JButton("record");
        JTextArea textArea = new JTextArea(10, 12);
        JScrollPane scroll = new JScrollPane(textArea);
        // Parameters for JTextArea
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        // Parameters for JScrollPane
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        // Size
        scroll.setPreferredSize(new Dimension(150, 150));
        textField.setMaximumSize(new Dimension(150, 20));
        // Alignment
        textField.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        button.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        scroll.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        // add to JPanel
        add(textField);
        add(button);
        add(scroll);
        // Logic with a button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textField.getText().isEmpty()) {
                    textArea.append(textField.getText() + "\n");
                }
            }
        });
    }
}
