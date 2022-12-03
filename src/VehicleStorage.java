package src;

import java.util.List;


public abstract class VehicleStorage {

    List<Vehicle> vehicles;
    private int maxCapacity;

    public VehicleStorage(int capacity) {
        setMaxCapacity(capacity);
    }

    public void addVehicle(Vehicle vehicle) {
        if (vehicles.size() + 1 <= maxCapacity) {
            vehicles.add(vehicle);
        }
    }

    public Vehicle removeFromStorage() {
        if (vehicles.size() > 0) {
            Vehicle vehicle = vehicles.get(vehicles.size() - 1);
            vehicles.remove(vehicles.size() - 1);
            return vehicle;
        }
        return null;
    }

    public int getMaxCapacity() { return maxCapacity; }

    public void setMaxCapacity(int capacity) { maxCapacity = capacity; }

}
