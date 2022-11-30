package src.CarModels;

import java.awt.*;

import src.Car.Car;


public class Volvo240 extends Car {

    protected double trimFactor;
    
    public Volvo240(double trimFactor) {
        super("Volvo240", Color.black, 4, 100);
        if (trimFactor < 0) this.trimFactor = 0;
        else this.trimFactor = trimFactor;
    }

    @Override
    protected double getSpeedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
}
