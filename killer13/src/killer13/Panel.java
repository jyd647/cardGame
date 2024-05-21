package killer13;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JPanel;
public class Panel extends JPanel {
    BufferedImage image;

    public Panel(String fileName) {
        try {
            //String you are passing in "new File()" is a path to your image
            image = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*Override this method to display graphics on JPanel.
    * Do not override paint method!*/
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,0,0,this);

    }

    /*Override getPreferredSize method so it returns dimensions of your image.
    * Size of your container (Panel) will be equal to size of that image*/
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(image.getWidth(),image.getHeight());
    }

}