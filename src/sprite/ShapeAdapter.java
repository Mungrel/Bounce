package sprite;

import java.awt.*;

/**
 * Created by Nick p on 25/05/2015.
 */
public class ShapeAdapter implements Shapeable {
    private Shape s;
    public ShapeAdapter(Shape s){
        this.s = s;
    }

    public void paint(Graphics g){
        s.paint(g);
    }

    public void move(int boundaryWidth, int boundaryHeight) {
        s.move(boundaryWidth, boundaryHeight);
    }

    
    public void changeFillColour(Color c) {
        s.setFillColor(c);
    }

    
    public void changeBorderColour(Color c) {
        s.setStrokeColor(c);
    }

    
    public boolean contains(Point p) {
        return s.contains(p);
    }

    
    public void setfX(int x) {
        s.setfX(x);
    }

    
    public void setfY(int y) {
        s.setfY(y);
    }

    
    public void setfDeltaX(int dX) {
        s.setfDeltaX(dX);
    }

    
    public void setfDeltaY(int dY) {
        s.setfDeltaY(dY);
    }

    
    public int x() {
        return s.getX();
    }

    
    public int y() {
        return s.getY();
    }

    
    public int deltaX() {
        return s.deltaX();
    }

    
    public int deltaY() {
        return s.deltaY();
    }

    
    public int width() {
        return s.getWidth();
    }

    
    public int height() {
        return s.getHeight();
    }

    
    public void setWidth(int w) {
        s.setWidth(w);
    }

    
    public void setHeight(int h) {
        s.setHeight(h);

    }

    
    public boolean isSelected() {
        return s.isSelected();
    }

    public void setSelected(boolean b) {
        s.setSelected(b);
    }

    public void drawHandles(Graphics g) {
        s.drawHandles(g);
    }


}
