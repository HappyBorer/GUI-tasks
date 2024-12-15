package Registration_form_GUI;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Registration windowRegistration = new Registration();
        windowRegistration.setTitle("Registration");
        windowRegistration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        windowRegistration.setBounds(screen.width/2 - 200, screen.height/2 - 300, 400, 800);
        windowRegistration.pack();
        windowRegistration.revalidate();
        windowRegistration.setVisible(true);
    }
}
