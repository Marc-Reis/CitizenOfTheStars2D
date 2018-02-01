package gfx;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class TileTest extends JFrame {

    public static void main(String[] args) throws IOException {
        String url = new String("./gfx/universe.jpg");
        InputStream ios = ClassLoader.getSystemClassLoader().getResourceAsStream(url);
        TileTest tileTest = new TileTest(ImageIO.read(ios));
        tileTest.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        tileTest.setVisible(true);
    }

    private TileTest(BufferedImage image) throws IOException {
        this.image = image;
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        JLabel label = new JLabel(new ImageIcon(image));
        add(label);
        BufferedImage tile = image;//image.getSubimage(0, 0, 61, 61);
        add(new JButton(new RotateAction(tile, label)));
        pack();
    }

    private BufferedImage image;

}

class RotateAction extends AbstractAction {

    public void actionPerformed(ActionEvent e) {
        BufferedImage tmpImage = op.filter(image, null);
        image.setData(tmpImage.getRaster());
        component.repaint();
    }

    RotateAction(BufferedImage image, Component component) {
        super("Rotate");
        this.component = component;
        this.image = image;
        double x = 0.5 * image.getWidth();
        double y = 0.5 * image.getHeight();
        AffineTransform xfrm
                = AffineTransform.getQuadrantRotateInstance(3, x, y);
        op = new AffineTransformOp(
                xfrm, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
    }

    private final Component component;

    private final BufferedImage image;

    private final BufferedImageOp op;

}
