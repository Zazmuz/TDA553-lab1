package main.vehicle_models;

import main.math.Vector2D;
import main.vehicles.Vehicle;
import main.vehicle_mods.storages.StackVehicleStorage;
import main.vehicles.trucks.TruckWithAngledPlatform;

import java.awt.*;


public class CarTransport extends TruckWithAngledPlatform {

    private StackVehicleStorage vehicleStorage;


    public CarTransport(int capacity) {
        super("CarTransportomatica 2000", Color.BLACK, 2, 1.1, 0.9, 30);
        this.vehicleStorage = new StackVehicleStorage(capacity, 5, this.getPosition());
        this.eventManager.register(this.vehicleStorage);
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

    public Vector2D getStoragePosition() { return vehicleStorage.getPosition(); }

    public void addToStorage(Vehicle vehicle) {
        if (this.getCurrentSpeed() != 0)
            throw new IllegalStateException("Car transport should be stationary when loading cars!");
        if (!platformIsRaised())
            throw new IllegalStateException("Ramp has to be opened before adding vehicles!");

        this.vehicleStorage.addVehicle(vehicle);
        this.eventManager.register(vehicle);
    }

    public Vehicle removeFromStorage() {
        if (!platformIsRaised())
            throw new IllegalStateException("Ramp has to be open when removing a car");
        if (this.getCurrentSpeed() != 0)
            throw new IllegalStateException("Cannot unload a car while driving");

        Vehicle vehicle = vehicleStorage.removeVehicle();
        this.eventManager.unregister(vehicle);
        double unloadAngle = this.getDirection() + Math.PI;
        this.vehicleStorage.unloadVehicleTo(vehicle, unloadAngle);
        vehicle.setIsParked(false);

        return vehicle;
    }

    public double getLoadDistance() { return this.vehicleStorage.loadDistance; }

}
