package sprite;

import java.awt.*;

/**
 * Created by Nick p on 25/05/2015.
 */
public interface InterOvalShape {
    void paint(Graphics g);

    boolean contains(Point mousePt);
}
