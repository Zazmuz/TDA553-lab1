package main.vehicles.cars;

import main.vehicle_mods.TrimMod;
import main.vehicles.Vehicle;

import java.awt.*;


public abstract class TrimmedCar extends Vehicle {

    private final TrimMod trimMod;

    public TrimmedCar(String modelName, Color color, int nrDoors, double enginePower, double turningRate, double trimFactor) {
        super(modelName, color, nrDoors, enginePower, turningRate);
        this.trimMod = new TrimMod(trimFactor);
    }

    public TrimMod getTrimMod() {
        return this.trimMod;
    }

}
