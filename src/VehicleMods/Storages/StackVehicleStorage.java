package src.VehicleMods.Storages;

import src.Vector2D;
import src.Vehicle;

import java.util.Stack;


public class StackVehicleStorage extends VehicleStorage {

    public StackVehicleStorage(int capacity, int loadDistance, Vector2D position) {
        super(capacity, loadDistance, position);
        this.storedVehicles = new Stack<Vehicle>();
    }

    @Override
    protected void addToStorage(Vehicle vehicle) {
        this.storedVehicles.add(vehicle);
    }

    protected Vehicle removeFromStorage() {
        return ((Stack<Vehicle>)this.storedVehicles).pop();
    }

    protected Vehicle removeFromStorage(Vehicle v) {
        throw new IllegalArgumentException("Not implemented");
    }

}
