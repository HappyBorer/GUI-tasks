package Widgets;

import javax.swing.*;

public class PanelForJRadioButton extends JPanel {
    PanelForJRadioButton(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton spring = new JRadioButton("Spring");
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
    }
}
