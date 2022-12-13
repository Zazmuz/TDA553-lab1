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

    public Vehicle removeVehicle(Vehicle vehicle) {
        removeFromStorageCheck();

        HashSet<Vehicle> storedVehicles = (HashSet<Vehicle>) this.storedVehicles;

        if (!this.storedVehicles.contains(vehicle))
            throw new IllegalStateException("Vehicle doesn't exist in storage!");

        storedVehicles.remove(vehicle);

        return vehicle;
    }

}
