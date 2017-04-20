
import java.awt.Color;
import java.awt.Font;
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
    String upperInput;
    String lowerInput;
    int upperX;
    int upperY;
    int lowerX;
    int lowerY;

    public void setImage(Image i) {
        this.i = i;
        repaint();
    }

    public void setUpperText(String upperInput, int upperX, int upperY) {
        this.upperInput = upperInput;
        this.upperX = upperX;
        this.upperY = upperY;
        repaint();
    }

    public void setLowerText(String lowerInput, int lowerX, int lowerY) {
        this.lowerInput = lowerInput;
        this.lowerX = lowerX;
        this.lowerY = lowerY;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();

        if (i != null) {
            AffineTransform imageAdjust = AffineTransform.getScaleInstance((float) getWidth() / i.getWidth(this), (float) getHeight() / i.getHeight(this));
            g2.drawImage(i, imageAdjust, this);
        }

        if (upperInput != null) {
            g2.setFont(new Font("Arial", Font.BOLD, 32));
            g2.setColor(new Color(255, 255, 50));
            g2.drawString(upperInput, upperX, upperY);
        }

        if (lowerInput != null) {
            g2.setFont(new Font("Arial", Font.BOLD, 32));
            g2.setColor(new Color(255, 255, 50));
            g2.drawString(lowerInput, lowerX, lowerY);
        }
    }

}
