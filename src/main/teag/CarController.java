package main.teag;

import main.vehicle_models.Saab95;
import main.vehicle_models.Volvo240;
import main.world.World;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer;

    // The frame that represents this instance View of the MVC pattern
    public WorldView frame;
    public World world;

    public CarController() {
        this.timer = new Timer(delay, new TimerListener());
        this.world = new World();
        this.world.spawnVehicle(new Saab95());
        this.world.spawnVehicle(new Volvo240(2));

        this.world.setAllEngines(true);

        // Start a new view and send a reference of self
        this.frame = new WorldView("CarSim 1.0", world);

        // Start the timer
        this.timer.start();
    }

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            world.gas(1);
            world.update();
        }
    }

}