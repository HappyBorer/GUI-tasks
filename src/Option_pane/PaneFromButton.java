package Option_pane;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PaneFromButton extends JPanel implements KeyListener {
    PaneFromButton(){
        System.out.println(JOptionPane.showConfirmDialog(this, "Hi! Do you want to register?", "welcome", JOptionPane.YES_NO_OPTION));
        System.out.println(JOptionPane.showInputDialog(this, null, "Login", JOptionPane.INFORMATION_MESSAGE));
        JPasswordField passwordField = new JPasswordField();
        System.out.println(JOptionPane.showConfirmDialog(this, passwordField, "Password", JOptionPane.YES_NO_OPTION));
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
