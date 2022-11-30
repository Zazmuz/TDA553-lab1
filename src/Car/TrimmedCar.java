package src.Car;

import java.awt.*;

public abstract class TrimmedCar extends Car {

    private double trimFactor;

    public TrimmedCar(String modelName, Color color, int nrDoors, double enginePower, double turningRate, double trimFactor) {
        super(modelName, color, nrDoors, enginePower, turningRate);
        this.setTrimFactor(trimFactor);
    }

    public void setTrimFactor(double value) { trimFactor = Math.max(value, 0); }

    public double getTrimFactor() { return trimFactor; }

}
