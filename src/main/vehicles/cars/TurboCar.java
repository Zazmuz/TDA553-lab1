package main.vehicles.cars;

import main.vehicle_mods.TurboMod;
import main.vehicles.Vehicle;

import java.awt.*;


public abstract class TurboCar extends Vehicle {

    private final TurboMod turboMod;

    public TurboCar(String modelName, Color color, int nrDoors, double enginePower, double turningRate, double turbo) {
        super(modelName, color, nrDoors, enginePower, turningRate);
        this.turboMod = new TurboMod(turbo);
    }

    public TurboMod getTurboMod() {
        return this.turboMod;
    }

}
