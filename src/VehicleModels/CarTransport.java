package src.VehicleModels;

import src.Trucks.TruckWithAngledPlatform;
import src.Vehicle;

import java.awt.*;
import java.util.Stack;


public class CarTransport extends TruckWithAngledPlatform {

    private final Stack<Vehicle> storedVehicles;
    public final double loadDistance = 5;
    private final int vehicleCapacity;

    public CarTransport(int capacity) {
        super("CarTransportomatica 2000", Color.BLACK, 2, 1.1, 0.9, 30);
        vehicleCapacity = capacity;
        storedVehicles = new Stack<Vehicle>();
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

    public int getCarAmount() {
        return storedVehicles.size();
    }

    public int getVehicleCapacity() {
        return vehicleCapacity;
    }

    public void addToStorage(Vehicle vehicle) {
        if (storedVehicles.size() >= vehicleCapacity)
            throw new IllegalStateException("Car transport is already full");
        if (getCurrentSpeed() != 0)
            throw new IllegalStateException("Car transport should be stationary when loading cars");
        if (vehicle.getPosition().distanceTo(getPosition()) > loadDistance)
            throw new IllegalStateException("Car is not close enough");
        if (!platformIsRaised())
            throw new IllegalStateException("Ramp has to be opened before adding vehicles");
        if (vehicle.getCurrentSpeed() != 0)
            throw new IllegalStateException("Car should be stationary when getting loaded");

        storedVehicles.add(vehicle);
    }

    public Vehicle removeFromStorage() {
        if (storedVehicles.empty())
            throw new IllegalStateException("There are no cars to unload");
        if (!platformIsRaised())
            throw new IllegalStateException("Ramp has to be open when removing a car");
        if (getCurrentSpeed() != 0)
            throw new IllegalStateException("Cannot unload a car while driving");

        Vehicle vehicle = storedVehicles.pop();
        double unloadAngle = getDirection() + Math.PI;
        double unloadDistance = Math.random() * loadDistance;
        vehicle.getPosition().x = getPosition().x + Math.cos(unloadAngle) * unloadDistance;
        vehicle.getPosition().y = getPosition().y + Math.sin(unloadAngle) * unloadDistance;

        return vehicle;
    }

}
