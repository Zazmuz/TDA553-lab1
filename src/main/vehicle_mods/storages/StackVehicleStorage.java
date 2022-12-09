package main.vehicle_mods.storages;

import main.vehicles.Vehicle;
import main.math.Vector2D;

import java.util.Stack;


public class StackVehicleStorage extends VehicleStorage {

    public StackVehicleStorage(int capacity, int loadDistance, Vector2D position) {
        super(new Stack<Vehicle>(), capacity, loadDistance, position);
    }

    @Override
    protected void addToStorage(Vehicle vehicle) {
        this.storedVehicles.add(vehicle);
    }

    public Vehicle removeVehicle() {
        removeFromStorageCheck();

        return ((Stack<Vehicle>)this.storedVehicles).pop();
    }

}
