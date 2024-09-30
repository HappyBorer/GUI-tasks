package Option_pane;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PaneFromButton extends JPanel implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            JOptionPane.showMessageDialog(this, "My name", "Massage",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
