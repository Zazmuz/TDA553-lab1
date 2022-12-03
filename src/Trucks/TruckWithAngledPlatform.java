package src.Trucks;

import src.Vehicle;
import src.VehicleMods.AngledPlatformMod;

import java.awt.*;


public abstract class TruckWithAngledPlatform extends Vehicle {

    private final AngledPlatformMod platformMod;

    public TruckWithAngledPlatform(String modelName, Color color, int nrDoors, double enginePower, double turningRate, double maxAngle) {
        super(modelName, color, nrDoors, enginePower, turningRate);
        platformMod = new AngledPlatformMod(maxAngle);
    }

    protected boolean canDrive() {
        return !platformMod.isElevated();
    }

    public boolean canMovePlatform() {
        return getCurrentSpeed() == 0;
    }

    public void movePlatform(double angle) {
        if (canMovePlatform()) {
            platformMod.setAngle(angle);
        }
    }

    public boolean platformIsLowered() { return platformMod.isLowered(); }

    public boolean platformIsRaised() { return platformMod.isRaised(); }

    public boolean platformIsElevated() { return platformMod.isElevated(); }

    public double getMaxAngle() { return platformMod.getMaxAngle(); }

    public double getPlatformAngle() { return platformMod.getAngle(); }

}
