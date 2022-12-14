package main.views;

import main.assets.AssetManager;
import main.assets.themes.VehicleTheme01;
import main.vehicles.Vehicle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.*;


// This panel represent the animated part of the view with the car images.

public class ObjectView extends JPanel {

    // Initializes the panel and reads the images
    public ObjectView(int width, int height) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.green);
    }

    private ArrayList<Vehicle> todraw;

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (todraw == null)
            return;

        for (Vehicle vehicle : todraw) {
            int vehicleX = (int) Math.round(vehicle.getPosition().x);
            int vehicleY = (int) Math.round(vehicle.getPosition().y);
            String spritePath = VehicleTheme01.getImagePath(vehicle);
            BufferedImage sprite = AssetManager.getImage(spritePath);

            g.drawImage(sprite, vehicleX, vehicleY, null); // see javadoc for more info on the parameters
        }

    }

    void drawVehicles(ArrayList<Vehicle> vehicles) {
        todraw = vehicles;
        this.repaint();
    }

}

