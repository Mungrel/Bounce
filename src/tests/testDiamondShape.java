package tests;

import junit.framework.TestCase;
import sprite.*;

import java.awt.*;

/**
 * Created by Nick p on 14/05/2015.
 */
public class testDiamondShape extends TestCase {

    Shapeable o = new ShapeAdapter(new sprite.Shape(new sprite.DiamondStrategy()));
    public void testMove() throws Exception {
        // testing x movement of Oval shape
        // current x position is 0, and deltaX = -10,
        // testing to see if it changes its direction (bounces of left edge)
        //set up
        
        o.setfX(0);
        o.setfY(50);
        o.setfDeltaX(-10);
        o.setfDeltaY(10);
        //as x = 0, it will set nextX to 0 before bouncing
        o.move(100, 100);
        assertEquals(0, o.x());
        //deltaX should change sign (-10 -> 10)
        assertEquals(10, o.deltaX());
        //checking fX has begun moving away from edge
        o.move(100, 100);
        //x position after sprite should be 10 away from edge
        assertEquals(10, o.x());


        // testing y movement of Oval shape
        // current y position is 0, and deltaY = -10,
        // testing to see if it changes its direction (bounces off top edge)
        //set up
        o.setfX(50);
        o.setfY(0);
        o.setfDeltaX(10);
        o.setfDeltaY(-10);
        //as y = 0, it will set nextY to 0 before bouncing
        o.move(100, 100);
        assertEquals(0, o.y());
        //deltaY should change sign (-10 -> 10)
        assertEquals(10, o.deltaY());
        //checking fY has begun moving away from edge
        o.move(100, 100);
        //y position after sprite should be 10 away from edge
        assertEquals(10, o.y());

        
        

        //Oval shape att (90, 90) with (dX,dY) = (10, 10) and
        // width = 10, height = 10

        o.setfX(90);
        o.setfY(90);
        o.setfDeltaX(10);
        o.setfDeltaY(10);
        o.setWidth(10);
        o.setHeight(10);
        //after 1 move it will hit bottom right corner exactly
        //due to its width and height, it's already in the bottom corner

        o.move(100, 100);
        assertEquals(90, o.x());
        assertEquals(90, o.y());
        //it should sit there for 1 move and then move away by 10 in x and y
        o.move(100, 100);
        assertEquals(80, o.x());
        assertEquals(80, o.y());
        //fDeltaX and fDeltaY should've changed sign too
        assertEquals(-10, o.deltaX());
        assertEquals(-10, o.deltaY());


        // All tests successful
        
        
    }
    public void testContains() throws Exception{
        
        o.setfX(0);
        o.setfY(50);
        o.setfDeltaX(-10);
        o.setfDeltaY(10);
        o.setWidth(10);
        o.setHeight(10);
        //Test contains method
        // x = 0, y = 50, height and width of 10
        // point (5, 55) should lie within shape, contains method should return true.
        Point p = new Point(5, 55);
        assertEquals(true, o.contains(p));
        //Test successful

        //point (100, 100) should lie outside of shape
        Point q = new Point(100, 100);
        assertEquals(false, o.contains(q));
        //Test successful

        o = null;
        
    }
    public void testSprite() throws Exception{
        sprite.Shape d = new sprite.Shape(new sprite.DiamondStrategy());
        d.setfX(10);
        assertEquals(10, d.getX());
        d = null;
    }

}
