package src.CarModels;

import src.Trucks.TruckWithAngledPlatform;

import java.awt.*;


public class Scania extends TruckWithAngledPlatform {

    public Scania() {
        super("Scania Dumptruck", Color.WHITE, 2, 0.9, 0.9, 70);
    }

    @Override
    protected double getSpeedFactor() {
        return canDrive() ? getEnginePower() * 0.01 : 0;
    }

}
