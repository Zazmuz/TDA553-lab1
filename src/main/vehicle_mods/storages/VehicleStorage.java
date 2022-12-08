package main.vehicle_mods.storages;

import main.vehicles.Vehicle;
import main.math.Vector2D;

import java.util.Collection;


public abstract class   VehicleStorage {

    Collection<Vehicle> storedVehicles;
    private int maxCapacity;
    public final double loadDistance;
    Vector2D position;

    public VehicleStorage(Collection<Vehicle> storage, int capacity, double loadDistance, Vector2D position) {
        this.position = position;
        this.loadDistance = loadDistance;
        this.setMaxCapacity(capacity);
        this.storedVehicles = storage;
    }

    public int getStoredAmount() { return this.storedVehicles.size(); }

    public void addVehicle(Vehicle vehicle) {
        if (vehicle.getCurrentSpeed() != 0)
            throw new IllegalArgumentException("Can't add a moving vehicle to storage!");
        if (this.getStoredVehicleCount() >= getMaxCapacity())
            throw new IllegalStateException("vehicles.Vehicle storage is full!");
        if (this.position.distanceTo(vehicle.getPosition()) > this.loadDistance)
            throw new IllegalStateException("Car is not close enough!");

        addToStorage(vehicle);
    }

    protected abstract void addToStorage(Vehicle vehicle);

    public Vehicle removeVehicle(Vehicle vehicle) {
        if (this.getStoredVehicleCount() == 0) {
            throw new IllegalStateException("Can't remove from empty storage!");
        }

        return vehicle == null ? removeFromStorage() : removeFromStorage(vehicle);
    }

    public Vehicle removeVehicle() {
        return removeVehicle(null);
    }

    public boolean isInStorage(Vehicle vehicle) { return this.storedVehicles.contains(vehicle); }

    protected abstract Vehicle removeFromStorage();

    protected abstract Vehicle removeFromStorage(Vehicle vehicle);

    public int getMaxCapacity() { return this.maxCapacity; }

    public void setMaxCapacity(int capacity) { this.maxCapacity = capacity; }

    public int getStoredVehicleCount() { return this.storedVehicles.size(); }

    public void unloadVehicleTo(Vehicle vehicle, double angle, double distance) {
        vehicle.getPosition().x = this.position.x + Math.cos(angle) * distance;
        vehicle.getPosition().y = this.position.y + Math.sin(angle) * distance;
    }

    public void unloadVehicleTo(Vehicle vehicle, double distance) {
        unloadVehicleTo(vehicle, Math.random() * Math.PI * 2, distance);
    }

}
