package main.vehicles.trucks;

import main.vehicle_mods.AngledPlatformMod;
import main.vehicles.Vehicle;

import java.awt.*;


public abstract class TruckWithAngledPlatform extends Vehicle {

    private final AngledPlatformMod platformMod;

    public TruckWithAngledPlatform(String modelName, Color color, int nrDoors, double enginePower, double turningRate, double maxAngle) {
        super(modelName, color, nrDoors, enginePower, turningRate);
        this.platformMod = new AngledPlatformMod(maxAngle);
    }

    @Override
    public boolean canDrive() {
        return super.canDrive() && !this.platformMod.isElevated();
    }

    @Override
    protected double getSpeedFactor() {
        return canDrive() ? this.getEnginePower() : 0.0;
    }

    public boolean canMovePlatform() {
        return this.getCurrentSpeed() == 0;
    }

    public void movePlatform(double angle) {
        if (canMovePlatform()) {
            this.platformMod.setAngle(angle);
        }
    }

    public boolean platformIsLowered() { return this.platformMod.isLowered(); }

    public boolean platformIsRaised() { return this.platformMod.isRaised(); }

    public boolean platformIsElevated() { return this.platformMod.isElevated(); }

    public double getMaxAngle() { return this.platformMod.getMaxAngle(); }

    public double getPlatformAngle() { return this.platformMod.getAngle(); }

}
