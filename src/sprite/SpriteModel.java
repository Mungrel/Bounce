package sprite;

import java.awt.*;

/**
 * Created by Nick p on 24/05/2015.
 */
public interface SpriteModel {

    /*
    Customisable movement
    @param bW
        width of movement area
    @param bH
        height of movement area

     */

    public abstract void move(int bW, int bH);
    public abstract int getX();
    public abstract int getY();

    /*
    Customisable selection
    @param p
            selection pointer (e.g from mouse-click event)

    @return true, if p is within the sprite's selection area
     */
    public abstract boolean contains(Point p);
    public abstract void setSelected(boolean s);
    public abstract boolean isSelected();

    /*
    Customisable size
     */

    public abstract int getWidth();
    public abstract void setWidth(int w);
    public abstract int getHeight();
    public abstract void setHeight(int h);

    /*
    Customisable colour
     */

    public abstract Color getStrokeColor();
    public abstract void setStrokeColor(Color sC);
    public abstract Color getFillColor();
    public abstract void setFillColor(Color fC);
}
