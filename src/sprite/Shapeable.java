package sprite;

import java.awt.*;

/**
 * Created by Nick p on 25/05/2015.
 */
public interface Shapeable extends InterDiamondShape, InterPacmanShape, InterRectangleShape, InterOvalShape{
	void move(int boundaryWidth, int boundaryHeight);

	void changeFillColour(Color c);

	void changeBorderColour(Color c);

	/** abstract contains method
	 * Returns whether the point p is inside the shape or not.
	 * @param p	the mouse point
	 */
	boolean contains(Point p);

	void setfX(int x);

	void setfY(int y);

	void setfDeltaX(int dX);

	void setfDeltaY(int dY);

	int x();

	int y();

	int deltaX();

	int deltaY();

	int width();

	int height();

	void setWidth(int w);

	void setHeight(int h);

	boolean isSelected();

	void setSelected(boolean s);

	void drawHandles(Graphics g);
}
