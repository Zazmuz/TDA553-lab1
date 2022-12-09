package main.vehicle_mods.storages;

import main.vehicles.Vehicle;
import main.math.Vector2D;

import java.util.HashSet;


public class HeapVehicleStorage extends VehicleStorage {
    
    public HeapVehicleStorage(int capacity, double loadDistance, Vector2D position) {
        super(new HashSet<Vehicle>(), capacity, loadDistance, position);
    }

    @Override
    protected void addToStorage(Vehicle vehicle)  {
        this.storedVehicles.add(vehicle);
    }

    @Override
    protected Vehicle removeFromStorage() {
        throw new IllegalArgumentException("Not implemented");
    }

    @Override
    protected Vehicle removeFromStorage(Vehicle vehicle) {
        HashSet<Vehicle> storedVehicles = (HashSet<Vehicle>) this.storedVehicles;

        if (!this.storedVehicles.contains(vehicle))
            throw new IllegalStateException("vehicles.Vehicle doesn't exist in storage!");

        storedVehicles.remove(vehicle);

        return vehicle;
    }

}
