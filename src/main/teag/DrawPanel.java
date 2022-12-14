package main.teag;

import main.events.Event;
import main.events.EventType;
import main.events.MovedEvent;
import main.events.WorldUpdateEvent;
import main.world.World;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.*;


// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    BufferedImage vehicleImage;
    // To keep track of a singel cars position
    Point vehiclePoint = new Point();

    // TODO: Make this genereal for all cars
    void moveit(int x, int y){
        vehiclePoint.x = x;
        vehiclePoint.y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // vehicleImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            vehicleImage = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("/main/pics/Volvo240.jpg")));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(vehicleImage, vehiclePoint.x, vehiclePoint.y, null); // see javadoc for more info on the parameters
    }

}