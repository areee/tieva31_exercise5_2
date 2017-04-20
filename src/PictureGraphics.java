
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import javax.swing.JPanel;

/**
 *
 * @author ylhaart
 */
public class PictureGraphics extends JPanel {

    Image i;

    public void setImage(Image i) {
        this.i = i;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        
        if(i!=null){
            AffineTransform imageAdjust = AffineTransform.getScaleInstance((float) getWidth() / i.getWidth(this), (float) getHeight() / i.getHeight(this));
            g2.drawImage(i, imageAdjust, this);
        }
    }

}
