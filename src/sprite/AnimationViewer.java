package sprite;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
/*
 *	======================================================================
 *	AnimationViewer.java : Moves shapes around on the screen
 *	It is the main drawing area where shapes are manipulated
 *	and added using an ArrayList of type Shape and mouse events.
 *	It also contains a popup menu to clear all shapes.
 *
 *
 *  Is a child of JPanel class, while also implementing
 *  ActionListener Interface.
 *	======================================================================
 */

public class AnimationViewer extends JPanel implements ActionListener {
    private ArrayList<Shape> shapes;        // the list to store all shapes
    private int defaultShapeType = 0;       // the default shape type
    private final int DELAY = 50;        // the default animation speed
    private JPopupMenu popup;                // popup menu
    private javax.swing.Timer timer;
    private PaintStrategy defaultPaintStrategy = new OvalStrategy();

    /**
     * Constructor of the AnimationPanel
     */
    public AnimationViewer() {
        timer = new javax.swing.Timer(DELAY, this);
        shapes = new ArrayList<Shape>(); //create an ArrayList to store shapes
        popup = new JPopupMenu(); //create the popup menu
        makePopupMenu();
        timer.start();
        createStartShape();

        // add the mouse event to handle popup menu and create new shape
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                maybeShowPopup(e);
            }

            public void mouseReleased(MouseEvent e) {
                maybeShowPopup(e);
            }

            private void maybeShowPopup(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popup.show(e.getComponent(), e.getX(), e.getY());
                }
            }

            public void mouseClicked(MouseEvent e) {
                boolean found = false;
                for (Shape s : shapes) {
                    if (s.contains(e.getPoint())) { // if the mousepoint is within a shape, then set the shape to be selected/deselected
                        found = true;
                        s.setSelected(!s.isSelected());
                    }
                }
                if (!found)
                    createNewShape(e.getX(), e.getY()); // if the mousepoint is not within a shape, then create a new one according to the mouse position
            }
        });
    }

    /**
     * Notifies this AnimationViewer object of an ActionEvent.
     */
    public void actionPerformed(ActionEvent e) {
        // Request that the AnimationPanel repaints itself.
        repaint();
    }


    /**
     * creates a new shape
     *
     * @param x the x-coordinate of the mouse position
     * @param y the y-coordinate of the mouse position
     */
    private void createStartShape() {
        //creates a new rectangle upon application launch
        shapes.add(new Shape(new RectangleStrategy()));
    }

    protected void createNewShape(int x, int y) {
        // create a new shape dependent on all current properties and the mouse position
        PaintStrategy p = defaultPaintStrategy;
        switch (defaultShapeType) {

            case 0: {
                p = new RectangleStrategy();
                break;
            }
            case 1: {
                p = new OvalStrategy();
                break;
            }
            case 2: {
                p = new DiamondStrategy();
                break;
            }
            case 3: {
                p = new PacmanStrategy();
                break;
            }
        }
        Shape o = new Shape(p);
        o.setfX(x);
        o.setfY(y);

        shapes.add(o);
    }


    /**
     * sets the default shape type
     *
     * @param s the new shape type
     */
    public void setDefaultShapeType(int s) {
        defaultShapeType = s;
    }

    /**
     * set the width for all currently selected shapes
     *
     * @param w the new width value
     */
    public void setWidth(int w) {
        for (Shape s : shapes) {
            if (s.isSelected()) {
                if (s.s instanceof PacmanStrategy) {
                    s.setWidth(w);
                    s.setHeight(w);
                } else {
                    s.setWidth(w);
                }
            }
        }
    }

    /**
     * set the height for all currently selected shapes
     *
     * @param w the new width value
     */
    public void setHeight(int h) {
        for (Shape s : shapes) {
            if (s.isSelected()) {
                if (s.s instanceof PacmanStrategy) {
                    s.setWidth(h);
                    s.setHeight(h);
                } else {
                    s.setHeight(h);
                }
            }
        }
    }

    /**
     * removes all shapes from our vector
     */
    public void clearAllShapes() {
        shapes.clear();
    }

    /**
     * creates the popup menu for our animation program
     */
    protected void makePopupMenu() {
        JMenuItem menuItem;
        // clear all
        menuItem = new JMenuItem("Clear All");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearAllShapes();
            }
        });
        popup.add(menuItem);
    }

    /**
     * updates the painting area
     *
     * @param g the graphics control
     */
    public void update(Graphics g) {

        paint(g);

    }

    public void changeFillColor(Color c) {
        for (Shape s : shapes) {
            if (c == null) {
                //do nothing
            } else {
                if (s.isSelected()) {
                    s.setFillColor(c);
                }
            }
        }
    }

    public void changeBorderColor(Color c) {
        for (Shape s : shapes) {
            if (c == null) {
                //do nothing
            } else {
                if (s.isSelected()) {
                    s.setStrokeColor(c);
                }
            }
        }
    }

    /**
     * moves and paints all shapes within the animation area
     *
     * @param g the Graphics control
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Calculate bounds of animation screen area.
        int boundaryWidth = getSize().width;
        int boundaryHeight = getSize().height;

        for (Shape s : shapes) {
            s.paint(g);

            s.move(boundaryWidth, boundaryHeight);
        }
    }

    public void makeColourful() {
        Random r = new Random();
        for (Shape s : shapes) {
            Color c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256), r.nextInt(256));
            s.setFillColor(c);
            s.setStrokeColor(c);
        }
    }

    public void changeDelay(int delay) {
        timer.stop();
        timer = new javax.swing.Timer(delay, this);
        timer.start();

    }
}