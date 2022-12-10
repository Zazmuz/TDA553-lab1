package main.teag;

import main.vehicle_models.Saab95;
import main.vehicle_models.Scania;
import main.vehicle_models.Volvo240;
import main.vehicles.Vehicle;
import main.vehicles.trucks.TruckWithAngledPlatform;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;


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
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Saab95());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                car.move();
                int x = (int) Math.round(car.getPosition().x);
                int y = (int) Math.round(car.getPosition().y);
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;

        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake_amount = ((double) amount) / 100;

        for (Vehicle car : cars) {
            car.brake(brake_amount);
        }
    }

    void startAllEnginges() {
        for (Vehicle car : cars) {
            car.startEngine();
        }
    }

    void stopAllEnginges() {
        for (Vehicle car : cars) {
            car.stopEngine();
        }
    }

    void setTurboOn() {
        for (Vehicle car : cars) {
            if (car instanceof Saab95) {
                ((Saab95)car).getTurboMod().setTurboOn();
            }
        }
    }

    void setTurboOff() {
        for (Vehicle car : cars) {
            if (car instanceof Saab95) {
                ((Saab95)car).getTurboMod().setTurboOff();
            }
        }
    }

    void liftBed() {
        for (Vehicle car : cars) {
            if (car instanceof TruckWithAngledPlatform) {
                Scania scania = (Scania)car;
                scania.movePlatform(scania.getPlatformAngle() + 1);
            }
        }
    }

    void lowerBed() {
        for (Vehicle car : cars) {
            if (car instanceof TruckWithAngledPlatform) {
                Scania scania = (Scania)car;
                scania.movePlatform(scania.getPlatformAngle() - 1);
            }
        }
    }
}