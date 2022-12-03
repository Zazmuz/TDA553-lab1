package src.CarModels;

import src.Vehicle;

import java.awt.*;

public class TestCar extends Vehicle {

    public TestCar() {
        super("test", Color.red, 2, 125, 5);
    }

    public TestCar(String name, Color color, int nrDoors, double enginePower, double turningRate) {
        super(name, color, nrDoors, enginePower, turningRate);
    }

    public TestCar(double enginePower) {
        super("test", Color.red, 2, enginePower, 5);
    }

    @Override
    protected double getSpeedFactor() {return 1;};

}
