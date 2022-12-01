package src.CarModels;

import java.awt.*;

import src.Car.TrimmedCar;


public class Volvo240 extends TrimmedCar {

    public Volvo240(double trimFactor) {
        super("Volvo240", Color.black, 4, 100, 5, trimFactor);
    }

    @Override
    protected double getSpeedFactor() {
        return getEnginePower() * 0.01 * getTrimFactor();
    }
}
