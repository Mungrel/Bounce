package sprite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

/*
    A3 class is responsible for setting up the interactive buttons,
    panels and boxes (JPanel) at the head of the window and the
    window itself(JFrame).

    A3 is a child of the JFrame class.
    It uses an object of type: Animation Viewer.
 */
public class A3 extends JFrame {
    AnimationViewer viewer;    // panel for bouncing area

    /**
     * main method for A3
     */
    public static void main(String[] args) {
        JFrame frame = new A3("Bouncing Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        frame.setLocation((d.width - frameSize.width) / 2, (d.height - frameSize.height) / 2);
        frame.setVisible(true);
    }

    /**
     */
    public A3(String title) {
        super(title);
        setSize(500, 500);
        viewer = new AnimationViewer();
        add(viewer, BorderLayout.CENTER);
        add(setUpToolsPanel(), BorderLayout.NORTH);
        add(bottomSlider(), BorderLayout.SOUTH);
    }

    /**
     * Sets up the tools panel
     *
     * @return toolsPanel        the Panel
     */
    public JPanel setUpToolsPanel() {
        //Set up the shape combo box
        ImageIcon rectangleButtonIcon = createImageIcon("rectangle.gif");
        ImageIcon ovalButtonIcon = createImageIcon("oval.gif");
        ImageIcon diamondButtonIcon = createImageIcon("diamond.gif");
        ImageIcon pacmanButtonIcon = createImageIcon("pacman.gif");
        JComboBox<ImageIcon> shapesComboBox = new JComboBox<ImageIcon>(new ImageIcon[]{rectangleButtonIcon,
                ovalButtonIcon, diamondButtonIcon, pacmanButtonIcon});
        shapesComboBox.setToolTipText("Set shape");
        shapesComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                //set the default shape type based on the selection: 0 for Rectangle, 1 for oval etc
                viewer.setDefaultShapeType(cb.getSelectedIndex());
            }
        });
        //Set up the height TextField
        JTextField heightTxt = new JTextField("50");
        heightTxt.setToolTipText("Set Height");
        heightTxt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextField tf = (JTextField) e.getSource();
                try {
                    int newValue = Integer.parseInt(tf.getText());
                    if (newValue > 0)
                        viewer.setHeight(newValue);
                } catch (Exception ex) {
                    tf.setText("20");
                }

            }
        });
        //Set up the width TextField
        JTextField widthTxt = new JTextField("100");
        widthTxt.setToolTipText("Set Width");
        widthTxt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextField tf = (JTextField) e.getSource();
                try {
                    int newValue = Integer.parseInt(tf.getText());
                    if (newValue > 0)
                        viewer.setWidth(newValue);
                } catch (Exception ex) {
                    tf.setText("20");
                }
            }
        });
        // button for fillColor
        JButton fillButton = new JButton("Fill");
        fillButton.setToolTipText("Set Fill Color");
        fillButton.setForeground(Color.blue);
        fillButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color newColor = JColorChooser.showDialog(viewer, "Fill Color", Color.black);
                viewer.changeFillColor(newColor);
            }
        });
        // button for borderColor
        JButton borderButton = new JButton("Border");
        borderButton.setToolTipText("Set Border Color");
        borderButton.setForeground(Color.black);
        borderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color newColor = JColorChooser.showDialog(viewer, "Border Color", Color.black);
                viewer.changeBorderColor(newColor);
            }
        });

        JButton crazyButton = new JButton("Colourful");
        crazyButton.setToolTipText("Makes shapes colourful");
        crazyButton.setForeground(Color.black);
        crazyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                viewer.makeColourful();

            }
        });


        JPanel toolsPanel = new JPanel(new GridBagLayout());

        toolsPanel.setLayout(new BoxLayout(toolsPanel, BoxLayout.X_AXIS));
        toolsPanel.add(new JLabel(" Shape: ", JLabel.RIGHT));
        toolsPanel.add(shapesComboBox);
        toolsPanel.add(new JLabel(" Height: ", JLabel.RIGHT));
        toolsPanel.add(heightTxt);
        toolsPanel.add(new JLabel(" Width: ", JLabel.RIGHT));
        toolsPanel.add(widthTxt);
        toolsPanel.add(fillButton);
        toolsPanel.add(borderButton);
        toolsPanel.add(crazyButton);
        return toolsPanel;
    }

    /**
     * creates the imageIcon
     *
     * @param filename the filename of the image
     * @return ImageIcon        the imageIcon
     */
    protected static ImageIcon createImageIcon(String filename) {
        java.net.URL imgURL = A3.class.getResource(filename);
        return new ImageIcon(imgURL);
    }

    /**
     * Adds a component to a Panel.
     *
     * @param p   is the panel
     * @param c   is the component to add
     * @param gbc the grid bag constraints
     * @param x   the grid bag column
     * @param y   the grid bag row
     * @param w   the number of grid bag columns spanned
     * @param h   the number of grid bag rows spanned
     */
    private void add(JPanel p, Component c, GridBagConstraints gbc, int x, int y, int w, int h) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        p.add(c, gbc);
    }

    public JPanel bottomSlider() {
        JPanel jp = new JPanel(new GridBagLayout());
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
        JSlider slider = new JSlider(0, 0, 100, 50);
        slider.setToolTipText("Set the speed between frames.");
        slider.setForeground(Color.black);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);
        slider.setSnapToTicks(true);
        slider.setLabelTable(slider.createStandardLabels(20, 10));
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setPaintTrack(true);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int val = source.getValue();
                    viewer.changeDelay(val);
                }
            }
        });
        jp.add(new JLabel("Delay"));
        jp.add(slider);
        return jp;
    }
}