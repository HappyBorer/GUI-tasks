package KeyLogger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger extends JFrame implements KeyListener {
    private File myFile = new File("Key_logger.txt");
    private BufferedWriter writer;



    Logger(){
        super("KEY LOGGER");
        try {
            writer = new BufferedWriter(new FileWriter(myFile, true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();
        TextField textField = new TextField(50);
        textField.addKeyListener(this);
        addKeyListener(this);
        add(textField);
        WindowListener windowListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                try {
                    writer.close();

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                System.exit(0);
            }
        };
        addWindowListener(windowListener);
        setBounds(screen.width/2 - 250, screen.height/2 - 250, 500, 500);
        setVisible(true);
    }


    public static void main(String[] args) {
        new Logger();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        try {
            writer.write(e.getKeyChar());

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override    public void keyReleased(KeyEvent e) {

    }
}
