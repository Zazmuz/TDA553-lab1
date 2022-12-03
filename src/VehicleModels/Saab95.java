package src.VehicleModels;

import java.awt.*;

import src.Cars.TurboCar;


public class Saab95 extends TurboCar {

    public Saab95(){
        super("Saab95", Color.red, 2, 125, 5, 1.3);
        getTurboMod().setTurboOn();
    }

    @Override
    protected double getSpeedFactor() {
        return getEnginePower() * 0.01 * getTurboMod().getTurbo();
    }

}
