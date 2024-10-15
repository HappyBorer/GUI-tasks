package Option_pane;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class PaneFromButton extends JPanel implements KeyListener {
    PaneFromButton(){
        int registration = JOptionPane.showConfirmDialog(this, "Hi! Do you want to register?",
                "welcome", JOptionPane.YES_NO_OPTION);
        if(registration == 0) {
            int length = 5;
            String space = " ";
            String log;
            JLabel label = new JLabel("You enter your login");
            JTextField field = new JTextField(20);
            JOptionPane.showMessageDialog(this, new JComponent[]{label, field},
                    "Login", JOptionPane.INFORMATION_MESSAGE);
            log = field.getText();
            while(log.length() < length && !log.contains(space)){
                JOptionPane.showMessageDialog(this, new JComponent[]{label, field},
                        "Login", JOptionPane.INFORMATION_MESSAGE);
                log = field.getText();
            }

            length = 8;
            boolean isChar = false;
            boolean isNumber = false;
            JPasswordField passwordField = new JPasswordField();
            JPasswordField passwordField2 = new JPasswordField();
            label = new JLabel("You enter your password");
            while(passwordField.getPassword().length < length|| !isChar || !isNumber){
                JOptionPane.showMessageDialog(this, new JComponent[]{label, passwordField},
                        "Password", JOptionPane.INFORMATION_MESSAGE);
                if(passwordField.getPassword().length >= length) {
                    for (char c : passwordField.getPassword()) {
                        if (!isChar && Character.isLetter(c)) {
                            isChar = true;
                        }
                        if (!isNumber && Character.isDigit(c)) {
                            isNumber = true;
                        }
                        if (isChar && isNumber) {
                            break;
                        }
                    }
                }
            }
            label = new JLabel("You enter your password again");
            JOptionPane.showMessageDialog(this, new JComponent[]{label, passwordField2},
                    "Repeat password", JOptionPane.INFORMATION_MESSAGE);
            while (!Arrays.equals(passwordField.getPassword(), passwordField2.getPassword())){
                JOptionPane.showMessageDialog(this, new JComponent[]{label, passwordField2},
                        "Repeat password", JOptionPane.INFORMATION_MESSAGE);
            }
            JOptionPane.showMessageDialog(this, "Registration was successful", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        }else{
            System.exit(0);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            int one = JOptionPane.showConfirmDialog(this, "Dose do you need it?", "Question one",
                    JOptionPane.YES_NO_OPTION);
            int two = JOptionPane.showConfirmDialog(this, "Do you have many?", "Question two",
                    JOptionPane.YES_NO_OPTION);
            String answer  = "";
            if(one == 0 && two == 0){
                answer = "You buy it";
            } else if (one == 1 && two == 0) {
                answer = "You keep many";
            } else if (one == 0 && two == 1){
                answer = "You go to work";
            } else {
                answer = "You think about job";
            }
            JOptionPane.showMessageDialog(this, answer, "you name", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
