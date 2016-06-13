package sprite;

import java.awt.*;

/**
 * Created by Nick p on 26/05/2015.
 */
public interface PaintStrategy {

    void drawShapeOutline(Graphics g, int fX, int fY, int fWidth, int fHeight);

    void ColourInShape(Graphics g, int fX, int fY, int fWidth, int fHeight);

    boolean contains(Point p, int fX, int fY, int fWidth, int fHeight);
}
