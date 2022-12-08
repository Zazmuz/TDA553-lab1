package main.vehicle_models;

import java.awt.*;

import main.vehicles.cars.TrimmedCar;


public class Volvo240 extends TrimmedCar {

    public Volvo240(double trimFactor) {
        super("Volvo240", Color.black, 4, 100, 5, trimFactor);
    }

    @Override
    protected double getSpeedFactor() {
        return this.getEnginePower() * 0.01 * this.getTrimMod().getTrimFactor();
    }
}
