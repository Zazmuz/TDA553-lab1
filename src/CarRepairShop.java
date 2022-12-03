package src;

import java.util.HashSet;


public class CarRepairShop {

    public final String shopName;
    private final Vector2D position;

    private final HashSet<Vehicle> storedVehicles;
    public final double loadDistance = 100;
    private final int vehicleCapacity;

    public CarRepairShop(String name, Vector2D position, int capacity) {
        this.shopName = name;
        this.position = position;
        this.vehicleCapacity = capacity;
        this.storedVehicles = new HashSet<Vehicle>();
    }

    public int getCarAmount() {
        return storedVehicles.size();
    }

    public int getVehicleCapacity() {
        return vehicleCapacity;
    }

    public void addToStorage(Vehicle vehicle) {
        if (storedVehicles.size() >= vehicleCapacity)
            throw new IllegalStateException("Car transport is already full!");
        if (vehicle.getPosition().distanceTo(position) > loadDistance)
            throw new IllegalStateException("Car is not close enough!");
        if (vehicle.getCurrentSpeed() != 0)
            throw new IllegalStateException("Car should be stationary when getting loaded!");

        storedVehicles.add(vehicle);
    }

    public Vehicle removeFromStorage(Vehicle vehicle) {
        if (!storedVehicles.contains(vehicle)) {
            throw new IllegalStateException("Vehicle doesn't exist in storage!");
        }

        storedVehicles.remove(vehicle);
        double unloadAngle = Math.random() * 2 * Math.PI;
        double unloadDistance = Math.random() * loadDistance;
        vehicle.getPosition().x = getPosition().x + Math.cos(unloadAngle) * unloadDistance;
        vehicle.getPosition().y = getPosition().y + Math.sin(unloadAngle) * unloadDistance;

        return vehicle;
    }

    public Vector2D getPosition() {
        return position;
    }

}
