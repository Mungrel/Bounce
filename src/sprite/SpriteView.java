package sprite;

import java.awt.*;

/**
 * Created by Nick p on 24/05/2015.
 */
public interface SpriteView {

    /*
    Methods in the View component of a Sprite
     */
    /*
    Customisable appearance

    @param g
    the Graphics context
     */

    public abstract void paint(Graphics g);
    public abstract void drawHandles(Graphics g);

}