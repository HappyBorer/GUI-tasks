package Option_pane;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static int width, height;

    public static void main(String[] args) {
        JRadioButton[] resolutions = {new JRadioButton("800x600", true),
                new JRadioButton("1024x768", false), new JRadioButton("1200x600", false),
                new JRadioButton("1280x1024", false), new JRadioButton("1680x1050", false),
                new JRadioButton("1920x1080", false)};
        JPanel panel = new JPanel(new GridLayout(0, 1, 0, 5));
        ButtonGroup group = new ButtonGroup();
        for (JRadioButton resolution : resolutions) {
            group.add(resolution);
            panel.add(resolution);
        }
        JOptionPane.showMessageDialog(null, panel,
                "Screen resolution", JOptionPane.QUESTION_MESSAGE);
        String select = "";
        for(JRadioButton radioButton : resolutions) {
            if(radioButton.isSelected()) {
                select = radioButton.getText();
            }
        }
        try {
            switch (select) {
                case "800x600" -> {
                    width = 800;
                    height = 600;
                }
                case "1024x768" -> {
                    width = 1024;
                    height = 768;
                }
                case "1200x600" -> {
                    width = 1200;
                    height = 600;
                }
                case "1280x1024" -> {
                    width = 1280;
                    height = 1024;
                }
                case "1680x1050" -> {
                    width = 1680;
                    height = 1050;
                }
                case "1920x1080" -> {
                    width = 1920;
                    height = 1080;
                }
            }

            new FrameForOption(width, height);
        }catch (NullPointerException ex){
            ex.printStackTrace();
        }

    }
}
