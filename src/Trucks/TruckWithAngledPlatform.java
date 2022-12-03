package src.Trucks;

import src.Vehicle;
import src.VehicleMods.AngledPlatformMod;

import java.awt.*;

public abstract class TruckWithAngledPlatform extends Vehicle {

    private final AngledPlatformMod platformMod;

    public TruckWithAngledPlatform(String modelName, Color color, int nrDoors, double enginePower, double turningRate, double maxAngle) {
        super(modelName, color, nrDoors, enginePower, turningRate);

        platformMod = new AngledPlatformMod(maxAngle) {
            @Override
            protected boolean canBeMoved() {
                return getCurrentSpeed() == 0;
            }
        };
    }

    public AngledPlatformMod getPlatformMod() {
        return platformMod;
    }

    protected boolean canDrive() {
        return !getPlatformMod().isElevated();
    }

}
