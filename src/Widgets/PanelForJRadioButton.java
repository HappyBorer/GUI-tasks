package Widgets;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelForJRadioButton extends JPanel {
    PanelForJRadioButton(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton spring = new JRadioButton("Spring", true);
        JRadioButton summer = new JRadioButton("Summer");
        JRadioButton autumn = new JRadioButton("Autumn");
        JRadioButton winter = new JRadioButton("Winter");
        buttonGroup.add(spring);
        buttonGroup.add(summer);
        buttonGroup.add(autumn);
        buttonGroup.add(winter);
        add(spring);
        add(summer);
        add(autumn);
        add(winter);

        spring.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        summer.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        autumn.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        winter.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        JButton button = new JButton("Answer");
        add(button);
        button.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        JLabel label = new JLabel("You answer: ");
        add(label);
        label.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(spring.isSelected()){
                    label.setText("You answer: " + spring.getText());
                }else if(summer.isSelected()){
                    label.setText("You answer: " + summer.getText());
                }else if(autumn.isSelected()){
                    label.setText("You answer: " + autumn.getText());
                }else{
                    label.setText("You answer: " + winter.getText());
                }
            }
        });
    }
}
