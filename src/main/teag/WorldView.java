package main.teag;

import main.vehicles.Vehicle;
import main.world.World;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;


/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class WorldView extends JFrame {

    private static final int windowWidth = 800;
    private static final int windowHeight = 800;

    DrawPanel drawPanel = new DrawPanel(windowWidth, windowHeight - 240);
    JPanel controlPanel = new JPanel();
    World world;

    // Constructor
    public WorldView(String frameName, World world){
        this.world = world;
        initComponents(frameName);
    }

    // Sets everything in place and fits everything
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(windowWidth, windowHeight));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2 - this.getSize().width/2, dim.height/2 - this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void draw() {
        for (Vehicle vehicle : world.vehicles) {
            int vehicleX = (int) Math.round(vehicle.getPosition().x);
            int vehicleY = (int) Math.round(vehicle.getPosition().y);
            drawPanel.moveit(vehicleX, vehicleY);
            drawPanel.repaint();
        }
    }

}