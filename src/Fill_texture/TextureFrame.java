package Fill_texture;

import javax.swing.*;
import java.awt.*;

public class TextureFrame extends JFrame {
    public TextureFrame() {
        super("Texture");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        FillTexture texture = new FillTexture();
        Container container = getContentPane();
        container.add(texture);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setBounds(dimension.width / 2 - 400, dimension.height / 2 - 300, 800, 600);
        setVisible(true);
    }
}
