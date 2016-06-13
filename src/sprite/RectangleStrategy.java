package sprite;

import java.awt.*;

/**
 * Created by Nick p on 26/05/2015.
 */
public class RectangleStrategy implements PaintStrategy {

    @Override
    public void drawShapeOutline(Graphics g, int fX, int fY, int fWidth, int fHeight) {
        g.drawRect(fX, fY, fWidth, fHeight);
    }

    @Override
    public void ColourInShape(Graphics g, int fX, int fY, int fWidth, int fHeight) {
        g.fillRect(fX, fY, fWidth, fHeight);
    }

    @Override
    public boolean contains(Point mousePt, int fX, int fY, int fWidth, int fHeight) {
        return (fX <= mousePt.x && mousePt.x <= (fX + fWidth + 1) && fY <= mousePt.y && mousePt.y <= (fY + fHeight + 1));
    }
}
