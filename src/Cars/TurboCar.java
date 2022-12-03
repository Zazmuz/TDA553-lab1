package src.Cars;

import src.Vehicle;
import src.VehicleMods.TurboMod;

import java.awt.*;


public abstract class TurboCar extends Vehicle {

    private final TurboMod turboMod;

    public TurboCar(String modelName, Color color, int nrDoors, double enginePower, double turningRate, double turbo) {
        super(modelName, color, nrDoors, enginePower, turningRate);
        turboMod = new TurboMod(turbo);
    }

    public TurboMod getTurboMod() {
        return turboMod;
    }

}
