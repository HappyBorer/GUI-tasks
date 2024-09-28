package Option_pane;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaneFromButton extends JPanel {
    PaneFromButton(){
        JButton but = new JButton("push");
        add(but);
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(but, "My name", "Massage", JOptionPane.INFORMATION_MESSAGE);
            }
        });

    }
}
