package main.vehicle_models;

import java.awt.*;

import main.vehicles.cars.TurboCar;


public class Saab95 extends TurboCar {

    public Saab95(){
        super("Saab95", Color.red, 2, 125, 5, 1.3);
        this.getTurboMod().setTurboOn();
    }

    @Override
    protected double getSpeedFactor() {
        return this.getEnginePower() * 0.01 * this.getTurboMod().getTurbo();
    }

}
