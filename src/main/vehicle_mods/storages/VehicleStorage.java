package main.vehicle_mods.storages;

import main.events.Event;
import main.events.EventListener;
import main.events.EventType;
import main.events.MovedEvent;
import main.vehicles.Vehicle;
import main.math.Vector2D;

import java.util.Collection;


public abstract class VehicleStorage implements EventListener {

    protected Collection<Vehicle> storedVehicles;
    private int maxCapacity;
    public final double loadDistance;
    private final Vector2D position;

    public VehicleStorage(Collection<Vehicle> storage, int capacity, double loadDistance, Vector2D position) {
        this.loadDistance = loadDistance;
        this.setMaxCapacity(capacity);
        this.storedVehicles = storage;
        this.position = new Vector2D(0,0);
        this.position.set(position);
    }

    public void onEvent(Event e) {
        if (e.type == EventType.onMove) {
            this.position.set(((MovedEvent)e).position);
        }
    }

    public void addVehicle(Vehicle vehicle) {
        if (vehicle.getCurrentSpeed() != 0)
            throw new IllegalArgumentException("Can't add a moving vehicle to storage!");
        if (this.getStoredVehicleCount() >= getMaxCapacity())
            throw new IllegalStateException("vehicles.Vehicle storage is full!");
        if (this.position.distanceTo(vehicle.getPosition()) > this.loadDistance)
            throw new IllegalStateException("Car is not close enough!");

        addToStorage(vehicle);
        vehicle.setIsParked(true);
    }

    protected abstract void addToStorage(Vehicle vehicle);

    public boolean canRemoveFromStorage() {
        return this.getStoredVehicleCount() != 0;
    }

    protected void removeFromStorageCheck() {
        if (!this.canRemoveFromStorage()) {
            throw new IllegalStateException("Can't remove from empty storage!");
        }
    }
    
    public boolean isInStorage(Vehicle vehicle) { return this.storedVehicles.contains(vehicle); }

    public int getMaxCapacity() { return this.maxCapacity; }

    public void setMaxCapacity(int capacity) { this.maxCapacity = capacity; }

    public Vector2D getPosition() { return position; }

    public int getStoredVehicleCount() { return this.storedVehicles.size(); }

    public void unloadVehicleTo(Vehicle vehicle, double angle, double distance) {
        vehicle.getPosition().x = this.position.x + Math.cos(angle) * distance;
        vehicle.getPosition().y = this.position.y + Math.sin(angle) * distance;
    }

    public void unloadVehicleTo(Vehicle vehicle, double distance) {
        unloadVehicleTo(vehicle, Math.random() * Math.PI * 2, distance);
    }

}
