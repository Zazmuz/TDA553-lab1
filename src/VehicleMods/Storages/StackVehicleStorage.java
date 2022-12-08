package src.VehicleMods.Storages;

import src.Vector2D;
import src.Vehicle;

import java.util.Stack;


public class StackVehicleStorage extends VehicleStorage {

    public StackVehicleStorage(int capacity, int loadDistance, Vector2D position) {
        super(new Stack<Vehicle>(), capacity, loadDistance, position);
    }

    @Override
    protected void addToStorage(Vehicle vehicle) {
        this.storedVehicles.add(vehicle);
    }

    @Override
    protected Vehicle removeFromStorage() {
        return ((Stack<Vehicle>)this.storedVehicles).pop();
    }

    @Override
    protected Vehicle removeFromStorage(Vehicle v) {
        throw new IllegalArgumentException("Not implemented");
    }

}
