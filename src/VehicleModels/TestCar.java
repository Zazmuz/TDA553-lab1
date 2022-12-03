package src.VehicleModels;

import src.Vehicle;

import java.awt.*;

public class TestCar extends Vehicle {

    public TestCar(String name, Color color, int nrDoors, double enginePower, double turningRate) {
        super(name, color, nrDoors, enginePower, turningRate);
    }

    public TestCar(double enginePower) {
        this("Test", Color.red, 2, enginePower, 5);
    }

    public TestCar() {
        this(125);
    }

    @Override
    protected double getSpeedFactor() {return 1;};

}
