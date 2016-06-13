package sprite;

import java.awt.*;
import java.awt.geom.Arc2D;

/**
 * Created by Nick p on 26/05/2015.
 */
public class PacmanStrategy extends OvalStrategy implements PaintStrategy {
    @Override
    public void drawShapeOutline(Graphics g, int fX, int fY, int fWidth, int fHeight) {
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(makePacman(g, fX, fY, fWidth, fHeight, angleIn));
    }

    @Override
    public void ColourInShape(Graphics g, int fX, int fY, int fWidth, int fHeight) {
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(makePacman(g, fX, fY, fWidth, fHeight, angleIn));
        angleIn = getAngle();
    }
    int count = 0;
    public int getAngle() {
        int angleIn = 0;
        if (count == 0) {
            angleIn = 45;
            count++;
        } else if (count == 1) {
            angleIn = 30;
            count++;
        } else if (count == 2) {
            angleIn = 15;
            count++;
        } else {
            angleIn = 30;
            count -= 3;
        }
        return angleIn;
    }

    int angleIn = getAngle();
    public Arc2D.Float makePacman(Graphics g, int fX, int fY, int fWidth, int fHeight, int angleIn) {
        Graphics2D g2 = (Graphics2D) g;
        Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);
        arc.setFrame(fX, fY, fWidth, fHeight);
        arc.setAngleStart(angleIn);
        int ext = 360 - (angleIn * 2);
        arc.setAngleExtent(ext);
        g2.draw(arc);
        g2.fill(arc);
        return arc;
    }
}
