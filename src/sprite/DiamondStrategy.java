package sprite;

import java.awt.*;

/**
 * Created by Nick p on 26/05/2015.
 */
public class DiamondStrategy implements PaintStrategy {
    @Override
    public void drawShapeOutline(Graphics g, int fX, int fY, int fWidth, int fHeight) {
        g.drawPolygon(makeDiamond(fX, fY, fWidth, fHeight));

    }

    @Override
    public void ColourInShape(Graphics g, int fX, int fY, int fWidth, int fHeight) {
        g.fillPolygon(makeDiamond(fX, fY, fWidth, fHeight));
    }

    @Override
    public boolean contains(Point p, int fX, int fY, int fWidth, int fHeight) {
        Polygon l = makeDiamond(fX, fY, fWidth, fHeight);
        return l.contains(p);
            }

    public Polygon makeDiamond(int x1, int y1, int x2, int y2) {
        Polygon d = new Polygon();
        int x = Math.round((x2 / 2) + x1);
        int y = Math.round((y2 / 2) + y1);
        d.addPoint(x, y1);
        d.addPoint((x2 + x1), y);
        d.addPoint(x, (y2 + y1));
        d.addPoint(x1, y);
        return d;
    }
}
