package src.Cars;

import src.Vehicle;
import src.VehicleMods.TrimMod;

import java.awt.*;


public abstract class TrimmedCar extends Vehicle {

    private final TrimMod trimMod;

    public TrimmedCar(String modelName, Color color, int nrDoors, double enginePower, double turningRate, double trimFactor) {
        super(modelName, color, nrDoors, enginePower, turningRate);
        trimMod = new TrimMod(trimFactor);
    }

    public TrimMod getTrimMod() {
        return trimMod;
    }

}
