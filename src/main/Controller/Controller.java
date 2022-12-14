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

public abstract class Controller implements EventListener {
    // member fields:

    // The delay (ms) corresponds to 1000/50= 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer;

    public WorldView frame;
    public World world;

    public Controller() {
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
        if (e.type == EventType.gasButton)          onGasPress(e);
        if (e.type == EventType.brakeButton)        onBrakePress(e);
        if (e.type == EventType.startCarsButton)    onStartCarsPress(e);
        if (e.type == EventType.stopCarsButton)     onStopCarsPress(e);
        if (e.type == EventType.turboOnButton)      onTurboOnCarsPress(e);
        if (e.type == EventType.turboOffButton)     onTurboOffPress(e);
        if (e.type == EventType.raiseLiftBedButton) onRaiseLiftBedPress(e);
        if (e.type == EventType.lowerLiftBedButton) onLowerLiftBedPress(e);
        if (e.type == EventType.gasSpinnerChanged)  onGasSpinnerChanged(e);
    }

    protected abstract void onGasPress(Event e);
    protected abstract void onBrakePress(Event e);
    protected abstract void onStartCarsPress(Event e);
    protected abstract void onStopCarsPress(Event e);
    protected abstract void onTurboOnCarsPress(Event e);
    protected abstract void onTurboOffPress(Event e);
    protected abstract void onRaiseLiftBedPress(Event e);
    protected abstract void onLowerLiftBedPress(Event e);
    protected abstract void onGasSpinnerChanged(Event e);

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            world.update();
        }
    }

}