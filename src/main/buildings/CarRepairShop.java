package main.buildings;

import main.vehicle_mods.storages.HeapVehicleStorage;
import main.vehicles.Vehicle;
import main.math.Vector2D;


public class CarRepairShop {

    public final String shopName;
    private final Vector2D position;
    public final double loadDistance = 100;
    private final HeapVehicleStorage vehicleStorage;

    public CarRepairShop(String name, Vector2D position, int capacity) {
        this.shopName = name;
        this.position = position;
        this.vehicleStorage = new HeapVehicleStorage(capacity, loadDistance, this.getPosition());
    }

    public Vector2D getPosition() {
        return position;
    }

    public void addToStorage(Vehicle vehicle) {
        if (vehicle.getCurrentSpeed() != 0)
            throw new IllegalStateException("Car should be stationary when getting loaded!");

        this.vehicleStorage.addVehicle(vehicle);
    }

    public Vehicle removeFromStorage(Vehicle vehicle) {
        Vehicle storedVehicle = this.vehicleStorage.removeVehicle(vehicle);
        this.vehicleStorage.unloadVehicleTo(storedVehicle, Math.random() * 2 * Math.PI, Math.random() * this.loadDistance);
        return storedVehicle;
    }

}
