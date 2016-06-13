package sprite;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by Nick p on 26/05/2015.
 */
public class OvalStrategy implements PaintStrategy{

    @Override
    public void drawShapeOutline(Graphics g, int fX, int fY, int fWidth, int fHeight) {
        g.drawOval(fX, fY, fWidth, fHeight);
    }

    @Override
    public void ColourInShape(Graphics g, int fX, int fY, int fWidth, int fHeight) {
        g.fillOval(fX, fY, fWidth, fHeight);
    }
    @Override
    public boolean contains(Point mousePt, int fX, int fY, int fWidth, int fHeight){
        Ellipse2D.Double c = new Ellipse2D.Double(fX, fY, fWidth, fHeight);
        return c.contains(mousePt);
    }
}
