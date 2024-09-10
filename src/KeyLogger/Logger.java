package KeyLogger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;

public class Logger extends JFrame implements KeyListener {
    private FileWriter write;
    Logger(){
        super("KEY LOGGER");
        try {
            write = new FileWriter("Key_logger.txt", true);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();

        TextField textField = new TextField(50);
        add(textField);
        addKeyListener(this);

        setBounds(screen.width/2 - 250, screen.height/2 - 250, 500, 500);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Logger();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        try {
            write.write(e.getKeyChar());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
