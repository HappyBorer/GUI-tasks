package Option_pane;

import javax.swing.*;

public class Main {
    private static int width, height;

    public static void main(String[] args) {
        Object[] resolutions = {"800x600", "1024x768", "1200x600", "1280x1024", "1680x1050", "1920x1080"};
        String resolution = (String) JOptionPane.showInputDialog(null, "You select the screen resolution",
                "Screen resolution", JOptionPane.QUESTION_MESSAGE, null, resolutions, "800x600");
        try {
            switch (resolution) {
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
