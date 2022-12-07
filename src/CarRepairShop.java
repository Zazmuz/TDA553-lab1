package src;

import src.VehicleMods.Storages.HeapVehicleStorage;


public class CarRepairShop {

    public final String shopName;
    private final Vector2D position;
    public final double loadDistance = 100;
    private final HeapVehicleStorage vehicleStorage;

    public CarRepairShop(String name, Vector2D position, int capacity) {
        this.shopName = name;
        this.position = position;
        this.vehicleStorage = new HeapVehicleStorage(capacity, loadDistance, this.position);
    }

    public Vector2D getPosition() {
        return position;
    }

    public void addToStorage(Vehicle vehicle) {
        if (vehicle.getCurrentSpeed() != 0)
            throw new IllegalStateException("Car should be stationary when getting loaded!");

        vehicleStorage.addVehicle(vehicle);
    }

    public Vehicle removeFromStorage(Vehicle vehicle) {
        Vehicle storedVehicle = vehicleStorage.removeVehicle(vehicle);
        vehicleStorage.unloadVehicleTo(storedVehicle, Math.random() * 2 * Math.PI, Math.random() * loadDistance);
        return storedVehicle;
    }

}
