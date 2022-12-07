package src.VehicleModels;

import java.awt.*;

import src.Cars.TurboCar;


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
