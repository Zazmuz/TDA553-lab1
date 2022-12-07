package src.VehicleModels;

import src.Trucks.TruckWithAngledPlatform;
import src.Vehicle;
import src.VehicleMods.Storages.StackVehicleStorage;

import java.awt.*;


public class CarTransport extends TruckWithAngledPlatform {

    private final StackVehicleStorage vehicleStorage;

    public CarTransport(int capacity) {
        super("CarTransportomatica 2000", Color.BLACK, 2, 1.1, 0.9, 30);
        this.vehicleStorage = new StackVehicleStorage(capacity, 5, this.getPosition());
    }

    @Override
    protected double getSpeedFactor() {
        return super.getSpeedFactor() * 0.01;
    }

    public void openRamp() {
        movePlatform(getMaxAngle());
    }

    public void closeRamp() {
        movePlatform(0);
    }

    public void addToStorage(Vehicle vehicle) {
        if (getCurrentSpeed() != 0)
            throw new IllegalStateException("Car transport should be stationary when loading cars!");
        if (!platformIsRaised())
            throw new IllegalStateException("Ramp has to be opened before adding vehicles!");

        vehicleStorage.addVehicle(vehicle);
    }

    public Vehicle removeFromStorage() {
        if (!platformIsRaised())
            throw new IllegalStateException("Ramp has to be open when removing a car");
        if (getCurrentSpeed() != 0)
            throw new IllegalStateException("Cannot unload a car while driving");

        Vehicle vehicle = vehicleStorage.removeVehicle();
        double unloadAngle = getDirection() + Math.PI;
        vehicleStorage.unloadVehicleTo(vehicle, unloadAngle);

        return vehicle;
    }

    public double getLoadDistance() { return vehicleStorage.loadDistance; }

}
