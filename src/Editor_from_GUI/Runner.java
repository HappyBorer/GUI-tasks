package Editor_from_GUI;

import javax.swing.*;
import java.awt.*;

public class Runner {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.setTitle("Editor");
        editor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        editor.setBounds(screen.width/2 - 400, screen.height/2 - 300, 800, 600);
        editor.pack();
        editor.setResizable(false);
        editor.setVisible(true);
    }
}
