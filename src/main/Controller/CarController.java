package main.Controller;

import main.events.*;
import main.vehicle_models.Saab95;
import main.vehicle_models.Volvo240;
import main.views.WorldView;
import main.world.World;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
 * This class represents the Controller part in the MVC pattern.
 * Its responsibilities are to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController implements EventListener {
    // member fields:

    // The delay (ms) corresponds to 1000/50= 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer;

    public WorldView frame;
    public World world;

    public CarController() {
        GuiEventManager.getInstance().register(this);

        this.timer = new Timer(delay, new TimerListener());
        this.world = new World();
        this.world.spawnVehicle(new Saab95());
        this.world.spawnVehicle(new Volvo240(2));

        // Start a new view and send a reference of the model
        this.frame = new WorldView("CarSim 1.0", world);
        // Register to receive UI events
        this.frame.eventManager.register(this);

        // Start the timer
        this.timer.start();
    }

    // Handle user input
    public void onEvent(Event e)
    {
        if (e.type == EventType.gasButton)          world.gas(1);
        if (e.type == EventType.brakeButton)        world.brake(1);
        if (e.type == EventType.startCarsButton)    world.setAllEngines(true);
        if (e.type == EventType.stopCarsButton)     world.setAllEngines(false);
        if (e.type == EventType.turboOnButton)      world.setTurbo(true);
        if (e.type == EventType.turboOffButton)     world.setAllEngines(false);
        if (e.type == EventType.raiseLiftBedButton) world.moveBed(true);
        if (e.type == EventType.lowerLiftBedButton) world.setAllEngines(false);
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            world.update();
        }
    }

}